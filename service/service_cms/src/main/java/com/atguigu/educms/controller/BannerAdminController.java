package com.atguigu.educms.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educms.entity.CrmBanner;
import com.atguigu.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器 管理员操作
 * </p>
 *
 * @author testjava
 * @since 2020-07-22
 */
@CrossOrigin
@RestController
@RequestMapping("/educms/banneradmin")
public class BannerAdminController {
    @Autowired
    private CrmBannerService bannerService;

    //1.分页查询banner
    @GetMapping("/pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable("page")Long page,@PathVariable("limit")Long limit){
        Page<CrmBanner> pageBanner = new Page<>();
        bannerService.page(pageBanner,null);
        return R.ok().data("items",pageBanner.getRecords()).data("total",pageBanner.getTotal());
    }

    //2.添加banner
    @PostMapping("/addBanner")
    public R addBanner(@RequestBody CrmBanner banner){
        bannerService.save(banner);
        return R.ok();
    }

    //3.根据bannerId查询
    @GetMapping("/getBanner/{id}")
    public R getBanner(@PathVariable("id")String id){
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("banner",banner);
    }

    //4.根据bannerId修改
    @PutMapping("/update")
    public R updateById(@RequestBody CrmBanner banner) {
        bannerService.updateById(banner);
        return R.ok();
    }

    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        bannerService.removeById(id);
        return R.ok();
    }

}

