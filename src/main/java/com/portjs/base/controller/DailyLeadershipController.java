package com.portjs.base.controller;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.DailyLeadershipService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dengshuangzhen on 2018\12\17 0017
 */
@RestController
@CrossOrigin
@RequestMapping("/DailyLeadership")
public class DailyLeadershipController extends BaseController{
    private String tag = "DepartmentController=======>";
    @Autowired
    private DailyLeadershipService dailyLeadershipService;

    /**
     *按条件查询领导日常展示页（按领导展示）
     * @param requestBody
     * @return
     */
    //按时间查询领导日常展示页
    @LogInfo(methodName = "按条件查询领导日常展示页（按时间展示）")
    @RequestMapping("selectLeadershipAgenda")
    public ResponseMessage selectLeadershipAgenda (@RequestBody String requestBody)  {
        logger.debug("selectLeadershipAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectLeadershipAgenda(requestBody);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectLeadershipAgenda() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *
     * @param requestBody
     * @return
     */
    //按条件查询领导日常展示页（按日期展示）
    @LogInfo(methodName = "按条件查询领导日常展示页（按日期展示）")
    @RequestMapping("selectLeadershipAgendaByTime")
    public ResponseMessage selectLeadershipAgendaByTime (@RequestBody String requestBody)  {
        logger.debug("selectLeadershipAgendaByTime() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectLeadershipAgendaByTime(requestBody);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectLeadershipAgendaByTime() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *
     * @param requestBody
     * @return
     */
    //按条件查询领导日常展示页（按日期展示）
    @LogInfo(methodName = "按条件查询领导日常展示页（按日期展示）")
    @RequestMapping("selectLeadershipAgendaByNull")
    public ResponseMessage selectLeadershipAgendaByNull (@RequestBody String requestBody)  {
        logger.debug("selectLeadershipAgendaByNull() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectLeadershipAgendaByNull(requestBody);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectLeadershipAgendaByNull() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }


    /**
     * 查询所有领导
     * @return
     */
    @LogInfo(methodName = "查询所有领导")
    @RequestMapping("selectLeader")
    public ResponseMessage selectLeader (@RequestBody String requestBody) {
        logger.debug("selectLeader() begin...requestBody");
        try {
            return dailyLeadershipService.selectLeader(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectLeader() end...");
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *添加领导日程
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "添加领导日程")
    @RequestMapping("insertLeadershipAgenda")
    public ResponseMessage insertLeadershipAgenda (@RequestBody String requestBody) {
        logger.debug("insertLeadershipAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage insertResponse=  dailyLeadershipService.insertLeadershipAgenda(requestBody);
            return insertResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertLeadershipAgenda() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *批量添加领导日程
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "添加领导日程")
    @RequestMapping("insertAllLeadershipAgenda")
    public ResponseMessage insertAllLeadershipAgenda (@RequestBody String requestBody) {
        logger.debug("insertAllLeadershipAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage insertResponse=  dailyLeadershipService.insertAllLeadershipAgenda(requestBody);
            return insertResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAllLeadershipAgenda() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *根据会议id删除会议以及对应关系新增时删除
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "根据会议id删除会议以及对应关系新增时删除")
    @RequestMapping("deleteLeadershipAgenda")
    public ResponseMessage deleteLeadershipAgenda (@RequestBody String requestBody) {
        logger.debug("deleteLeadershipAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage deleteResponse=  dailyLeadershipService.deleteLeadershipAgenda(requestBody);
            return deleteResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteLeadershipAgenda() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *根据会议id删除会议以及对应关系审核时删除
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "根据会议id删除会议以及对应关系审核时删除")
    @RequestMapping("deleteLeadershipAgenda1")
    public ResponseMessage deleteLeadershipAgenda1 (@RequestBody String requestBody) {
        logger.debug("deleteLeadershipAgenda1() begin...requestBody=",requestBody);
        try {
            ResponseMessage deleteResponse=  dailyLeadershipService.deleteLeadershipAgenda1(requestBody);
            return deleteResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteLeadershipAgenda1() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *根据会议id修改会议以及对应关系
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "根据会议id修改会议以及对应关系")
    @RequestMapping("updateLeadershipAgenda")
    public ResponseMessage updateLeadershipAgenda (@RequestBody String requestBody) {
        logger.debug("updateLeadershipAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage updateResponse=  dailyLeadershipService.updateLeadershipAgenda(requestBody);
            return updateResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateLeadershipAgenda() end...=",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }


    /**
     *领导日程批量导入
     * @param file
     * @return
     */
    @LogInfo(methodName = "领导日程批量导入")
    @RequestMapping("getAgendaForExcel")
    public ResponseMessage getAgendaForExcel (@RequestParam("file") MultipartFile file) {
        logger.debug("getAgendaForExcel() begin...file=",file);
        try {

            if(file == null){
                return new ResponseMessage(Code.CODE_ERROR,"文件为空");
            }
            ResponseMessage uploadResponse= dailyLeadershipService.getAgendaForExcel(file);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("getAgendaForExcel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }


    /**
     *领导填写页查询
     * @param requestBody
     * @return
     */
    //领导填写页查询
    @LogInfo(methodName = "领导填写页查询")
    @RequestMapping("selectAgenda")
    public ResponseMessage selectAgenda (@RequestBody String requestBody)  {
        logger.debug("selectAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectAgenda(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAgenda() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }


    /**
     *机要员发布
     * @param requestBody
     * @return
     */
    //机要员发布
    @LogInfo(methodName = "机要员发布")
    @RequestMapping("updateAgenda")
    public ResponseMessage updateAgenda (@RequestBody String requestBody)  {
        logger.debug("updateAgenda() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.updateAgenda(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateAgenda() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }
    /**
     *新增领导日程领导下拉框查询
     * @param requestBody
     * @return
     */
    //新增领导日程领导下拉框查询
    @LogInfo(methodName = "新增领导日程领导下拉框查询")
    @RequestMapping("insertSelectLeader")
    public ResponseMessage insertSelectLeader (@RequestBody String requestBody)  {
        logger.debug("insertSelectLeader() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.insertSelectLeader(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertSelectLeader() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *新增领导日程领导下拉框查询
     * @param requestBody
     * @return
     */
    //新增领导日程领导下拉框查询
    @LogInfo(methodName = "审核领导日程领导下拉框查询")
    @RequestMapping("examineSelectLeader")
    public ResponseMessage examineSelectLeader (@RequestBody String requestBody)  {
        logger.debug("examineSelectLeader() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.examineSelectLeader(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("examineSelectLeader() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *查看已发布页面
     * @param requestBody
     * @return
     */
    //查看已发布页面
    @LogInfo(methodName = "查看已发布页面")
    @RequestMapping("selectRecord")
    public ResponseMessage selectRecord (@RequestBody String requestBody)  {
        logger.debug("selectRecord() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectRecord(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectRecord() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *查询机要员领导
     * @param requestBody
     * @return
     */
    //查看已发布页面
    @LogInfo(methodName = "查询机要员领导")
    @RequestMapping("selectPerson")
    public ResponseMessage selectPerson (@RequestBody String requestBody)  {
        logger.debug("selectPerson() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectPerson(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectPerson() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *提交审核
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "提交审核")
    @RequestMapping("submitAudit")
    public ResponseMessage submitAudit (@RequestBody String requestBody)  {
        logger.debug("submitAudit() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.submitAudit(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("submitAudit() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *审核
     * @param requestBody
     * @return
     */

    @LogInfo(methodName = "审核")
    @RequestMapping("examine")
    public ResponseMessage examine (@RequestBody String requestBody)  {
        logger.debug("examine() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.examine(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("examine() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }


    /**
     *审核记录查询
     * @param
     * @return
     */

    @LogInfo(methodName = "审核记录查询")
    @RequestMapping("selectExamine")
    public ResponseMessage selectExamine ()  {
        logger.debug("selectExamine() begin...requestBody=");
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectExamine();

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectExamine() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }

    /**
     *根据部门id查询部门人员
     * @param
     * @return
     */

    @LogInfo(methodName = "根据部门id查询部门人员")
    @RequestMapping("selectDepartment")
    public ResponseMessage selectDepartment (@RequestBody String requestBody)  {
        logger.debug("selectDepartment() begin...requestBody=",requestBody);
        try {
            ResponseMessage responseMessage=  dailyLeadershipService.selectDepartment(requestBody);

            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectDepartment() end...", e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");

        }
    }


















    /**
     *领导日程可见人员范围配置新增
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "领导日程可见人员范围配置新增")
    @RequestMapping("insertAgendaVisualHuanm")
    public ResponseMessage insertAgendaVisualHuanm (@RequestBody String requestBody) {
        logger.debug("insertAgendaVisualHuanm() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.insertAgendaVisualHuanm(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAgendaVisualHuanm() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程可见人员范围配置查询
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程可见人员范围配置查询")
    @RequestMapping("selectAgendaVisualHuanm")
    public ResponseMessage selectAgendaVisualHuanm () {
        logger.debug("selectAgendaVisualHuanm() begin...file=");
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.selectAgendaVisualHuanm();
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAgendaVisualHuanm() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程可见人员范围配置修改
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程可见人员范围配置修改")
    @RequestMapping("updateAgendaVisualHuanm")
    public ResponseMessage updateAgendaVisualHuanm (@RequestBody String requestBody) {
        logger.debug("updateAgendaVisualHuanm() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.updateAgendaVisualHuanm(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateAgendaVisualHuanm() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程可见人员范围配置删除
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程可见人员范围配置删除")
    @RequestMapping("deleteAgendaVisualHuanm")
    public ResponseMessage deleteAgendaVisualHuanm (@RequestBody String requestBody) {
        logger.debug("deleteAgendaVisualHuanm() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.deleteAgendaVisualHuanm(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteAgendaVisualHuanm() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程汇总人员新增
     * @param
     * @return
     *//*
    @LogInfo(methodName = "领导日程汇总人员新增")
    @RequestMapping("insertAggregatedPersonnel")
    public ResponseMessage insertAggregatedPersonnel (@RequestBody String requestBody) {
        logger.debug("insertAggregatedPersonnel() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.insertAggregatedPersonnel(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAggregatedPersonnel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }*/

    /**
     *领导日程汇总人员查询
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程汇总人员查询")
    @RequestMapping("selectAggregatedPersonnel")
    public ResponseMessage selectAggregatedPersonnel () {
        logger.debug("selectAggregatedPersonnel() begin...file=");
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.selectAggregatedPersonnel();
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAggregatedPersonnel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程汇总人员修改
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程汇总人员修改")
    @RequestMapping("updateAggregatedPersonnel")
    public ResponseMessage updateAggregatedPersonnel (@RequestBody String requestBody) {
        logger.debug("updateAggregatedPersonnel() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.updateAggregatedPersonnel(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateAggregatedPersonnel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程汇总人员删除
     * @param
     * @return
     *//*
    @LogInfo(methodName = "领导日程汇总人员删除")
    @RequestMapping("deleteAggregatedPersonnel")
    public ResponseMessage deleteAggregatedPersonnel (@RequestBody String requestBody) {
        logger.debug("deleteAggregatedPersonnel() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.deleteAggregatedPersonnel(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteAggregatedPersonnel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }*/

    /**
     *领导日程部委审核人员查询新增
     * @param
     * @return
     */
    /*@LogInfo(methodName = "领导日程部委审核人员查询新增")
    @RequestMapping("insertAuditor")
    public ResponseMessage insertAuditor (@RequestBody String requestBody) {
        logger.debug("insertAuditor() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.insertAuditor(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }*/

    /**
     *领导日程部委审核人员查询
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程部委审核人员查询")
    @RequestMapping("selectAuditor")
    public ResponseMessage selectAuditor() {
        logger.debug("selectAuditor() begin...file=");
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.selectAuditor();
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程部委审核人员修改
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程部委审核人员修改")
    @RequestMapping("updateAuditor")
    public ResponseMessage updateAuditor (@RequestBody String requestBody) {
        logger.debug("updateAuditor() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.updateAuditor(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程部委审核人员删除
     * @param
     * @return
     */
   /* @LogInfo(methodName = "领导日程部委审核人员删除")
    @RequestMapping("deleteAuditor")
    public ResponseMessage deleteAuditor (@RequestBody String requestBody) {
        logger.debug("deleteAuditor() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.deleteAggregatedPersonnel(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("deleteAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }*/

    /**
     *领导日程一级审核人员查询
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程一级审核人员查询")
    @RequestMapping("selectOneAuditor")
    public ResponseMessage selectOneAuditor() {
        logger.debug("selectOneAuditor() begin...file=");
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.selectOneAuditor();
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectOneAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *领导日程一级审核人员修改
     * @param
     * @return
     */
    @LogInfo(methodName = "领导日程一级审核人员修改")
    @RequestMapping("updateOneAuditor")
    public ResponseMessage updateOneAuditor (@RequestBody String requestBody) {
        logger.debug("updateOneAuditor() begin...file=",requestBody);
        try {
            ResponseMessage uploadResponse= dailyLeadershipService.updateOneAuditor(requestBody);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("updateOneAuditor() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     * 查询领导日程代办
     * @param
     * @return
     */
    @LogInfo(methodName = "查询领导日程代办")
    @RequestMapping("select-schedule-agency")
    public ResponseMessage selectScheduleAgency(@RequestBody String requestBody) {
        logger.debug("selectScheduleAgency() begin body={}",requestBody);
        UnifiedExceptionHandler.method= tag+"selectScheduleAgency=============================="+requestBody;
        return dailyLeadershipService.selectScheduleAgency(requestBody);
    }

}
