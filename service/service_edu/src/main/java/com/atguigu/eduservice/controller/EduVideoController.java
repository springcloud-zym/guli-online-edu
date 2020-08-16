package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-17
 */
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/video")
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;
    @Autowired
    private VodClient vodClient;

    //添加小节
    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    //TODO 后面这个方法需要完善:删除小节的时候,同时把阿里云里面的视频删除
    @DeleteMapping("/{id}")
    public R deleteVideo(@PathVariable("id")String id){
        //根据小节id得到videoSourceId
        EduVideo video = videoService.getById(id);
        if (!StringUtils.isEmpty(video.getVideoSourceId())){
            vodClient.removeAlyVideo(video.getVideoSourceId());
        }
        //删除小节表中的数据
        videoService.removeById(id);
        return R.ok();
    }

    //修改小节

}

