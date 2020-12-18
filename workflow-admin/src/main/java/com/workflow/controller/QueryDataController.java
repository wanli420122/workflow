package com.workflow.controller;

import com.workflow.common.api.CommonResult;
import com.workflow.model.ActAgenting;
import com.workflow.model.ActDeployment;
import com.workflow.model.ActExecution;
import com.workflow.model.ActExecutionTask;
import com.workflow.service.QueryDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 工作流后台查询接口
 * Create by wl on 2020/11/2
 */
@RestController
@Api(tags = "QueryDataController", description = "工作流数据查询接口")
@RequestMapping("/qdc")
public class QueryDataController {

    @Autowired
    QueryDataService queryDataService;

    @GetMapping(value = "/queryDeploylist")
    @ApiOperation(value = "查询流程定义列表")
    public CommonResult getActList() {
        try {
            List<ActDeployment> deployments = queryDataService.queryDeplymentList();
            return CommonResult.success(deployments);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @PostMapping(value = "/addDeploy")
    @ApiOperation(value = "新增流程定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actDeployment", dataType = "ActDeployment",
                    required = true, value = "流程定义bean")
    })
    public CommonResult addDeployment(@RequestBody ActDeployment actDeployment) {
        try {
            queryDataService.addDeployment(actDeployment);
            return CommonResult.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @PostMapping(value = "/updateDeploy")
    @ApiOperation(value = "修改流程定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actDeployment", dataType = "ActDeployment",
                    required = true, value = "流程定义bean")
    })
    public CommonResult updateDeployment(@RequestBody ActDeployment actDeployment

    ) {
        try {
            queryDataService.updateDeployment(actDeployment);
            return CommonResult.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/deleteDeploy")
    @ApiOperation(value = "删除流程定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deployid", dataType = "String",
                    required = true, value = "流程定义id")
    })
    public CommonResult deleteDeployment(@RequestParam(value = "deployid", required = false) String deployid) {
        try {
            queryDataService.deleteDeployment(Long.parseLong(deployid));
            return CommonResult.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/queryTaskLists")
    @ApiOperation(value = "查询待办/已办任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userid", dataType = "String",
                    required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "flag", dataType = "String",
                    required = true, value = "待办已办状态 0-待办 ，1-已办")
    })
    public CommonResult queryTaskLists(@RequestParam(value = "userid", required = false) String userid,
                                       @RequestParam(value = "flag", required = false) String flag) {
        try {
            List<Map> actAgentings = queryDataService.queryTaskLists(userid, flag);
            return CommonResult.success(actAgentings);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/queryNode")
    @ApiOperation(value = "查询流程跟踪环节信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentingid", dataType = "String",
                    required = true, value = "待办/已办id")
    })
    public CommonResult queryExectionNode(@RequestParam(value = "agentingid", required = true) String agentingid) {
        try {
            List<Map> actAgentings = queryDataService.queryExectionNodes(agentingid);
            return CommonResult.success(actAgentings);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/queryTaskStatus")
    @ApiOperation(value = "查询流程跟踪任务状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentingid", dataType = "String",
                    required = true, value = "待办/已办id")
    })
    public CommonResult queryTaskStatus(@RequestParam(value = "agentingid", required = true) String agentingid) {
        try {
            int taskStatus = queryDataService.queryTaskStatus(agentingid);
            return CommonResult.success(taskStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/queryCanRejectNode")
    @ApiOperation(value = "查询可驳回的环节信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentingid", dataType = "String",
                    required = true, value = "待办/已办id")
    })
    public CommonResult queryCanRejectNode(@RequestParam(value = "agentingid", required = true) String agentingid) {
        try {
            List<ActExecutionTask> tasks = queryDataService.queryCanRejectNode(agentingid);
            return CommonResult.success(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping("/querySponsorTasks")
    @ApiOperation(value = "查询'我发起的任务'")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userid", dataType = "String",
                    required = true, value = "用户id  (传sa查所有)")
    })
    public CommonResult querySponsorTasks(@RequestParam(value = "userid", required = true) String userid){
        try {
            List<ActExecution> tasks = queryDataService.querySponsorTasks(userid);
            return CommonResult.success(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping(value = "/queryDetailByTaskid")
    @ApiOperation(value = "根据任务id查询该任务执行明细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "taskid", dataType = "taskid",
                    required = true, value = "任务id")
    })
    public CommonResult queryDetailByTaskid(@RequestParam(value = "taskid", required = true) String taskid){
        try {
            List<Map> detail = queryDataService.queryDetailByTaskid(taskid);
            return CommonResult.success(detail);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
}
