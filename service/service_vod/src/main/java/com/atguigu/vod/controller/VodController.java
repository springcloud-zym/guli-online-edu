package com.atguigu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exception.MyException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVideoUtils;
import com.atguigu.vod.utils.InitVodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author
 * @date 2020/7/21-17:43
 */
@CrossOrigin
@RestController
@RequestMapping("/eduvod/video")
public class VodController {
    @Autowired
    private VodService vodService;

    //上传本地视频到阿里云的方法
    @PostMapping("/uploadAlyVideo")
    public R uploadAlyVideo(MultipartFile file){
        //返回上传视频的id
        String videoId = vodService.uploadVideoAly(file);

        return R.ok().data("videoId",videoId);
    }

    //根据视频id删除阿里云中的视频
    @DeleteMapping("/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id")String id) throws ClientException {
        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        request.setVideoIds(id);
        DefaultAcsClient client = InitVodClient.initVodClient(ConstantVideoUtils.ACCESS_KEY, ConstantVideoUtils.ACCESS_SECRET);
        DeleteVideoResponse response = new DeleteVideoResponse();
        try {
            response = client.getAcsResponse(request);
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return R.ok();
    }

    //根据多个视频id删除阿里云中多个视频
    @DeleteMapping("/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList")List<String> videoIdList) throws ClientException {
        vodService.removeMoreAlyVideo(videoIdList);
        return R.ok();
    }

    //根据视频id获取视频的播放凭证
    @GetMapping("/getPlayAuth/{id}")
    public R getPlayAuth(@PathVariable("id")String id){
        //2.根据视频id获取播放凭证
        DefaultAcsClient client = null;
        String playAuth = "";
        try {
            client = InitVodClient.initVodClient("LTAI4GHwnr7bWJqXDsJzSXAZ", "SYUiZju8Yns6kOazB6JAOGJphyC9FP");
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(id);
            GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
            response = client.getAcsResponse(request);
            playAuth = response.getPlayAuth();
            return R.ok().data("playAuth",playAuth);
        } catch (ClientException e) {
            throw new MyException(20001,"获取视频凭证失败");
        }
    }
}
