package com.workflow.controller;

import com.workflow.common.api.CommonResult;
import com.workflow.model.ActDeployment;
import com.workflow.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by wl on 2020/12/2
 */
@RestController
@Api(tags = "ExternalController", description = "工作流对外接口")
@RequestMapping("/external")
public class ExternalController {

   /* @Autowired
    private ActivityService activityService;


    @GetMapping(value = "/startAct")
    @ApiOperation(value = "启动工作流")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "deployid", dataType = "Long",
                    required = true, value = "流程定义id"),
            @ApiImplicitParam(paramType = "query", name = "formdata", dataType = "String",
                    required = true, value = "表单数据"),
            @ApiImplicitParam(paramType = "query", name = "userid", dataType = "String",
                    required = true, value = "用户id")
    })
    public CommonResult startAct(@RequestParam(value = "deployid", required = true) Long deployid,
                                 @RequestParam(value = "formdata", required = true) String formdata,
                                 @RequestParam(value = "userid", required = true) String userid){
        try {
            activityService.startActivity(deployid, formdata, userid);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("启动成功");
    }*/
}
