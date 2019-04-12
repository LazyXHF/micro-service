package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.InvestmentPlanMapper;
import com.portjs.base.dao.PurchaseListMapper;
import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.service.PurchaseListService;
import com.portjs.base.util.*;
import com.portjs.base.util.StringUtils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseListServiceImpl implements PurchaseListService {
    ResponseMessage responseMessage = null ;

    @Autowired
    PurchaseListMapper purchaseListMapper;

    @Autowired
    private PurchaseListMapper planMapper;
    @Autowired
    private ProjectAddorUpdateUtil updateUtil;
    /**
     * 添加/暂存 列表信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertPurchaseListSelective(PurchaseList record) {
        record.setId(UUID.randomUUID().toString());
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            record.setCreateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(record.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时projectId未传!",record.getProjectId());
        }
        int i = purchaseListMapper.insertPurchaseListSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加信息时失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加信息成功！",i);
    }

    /**
     * 根据列表自身id查询信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseListById(String id) {
        PurchaseList purchaseList = purchaseListMapper.queryPurchaseListById(id);
        if(purchaseList == null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",purchaseList);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",purchaseList);
    }

    /**
     * 修改列表信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(PurchaseList record) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            record.setUpdateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(record.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息时未选中信息！");
        }
        int i = purchaseListMapper.updateByPrimaryKeySelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息失败",i);
        }
        return new ResponseMessage(Code.CODE_ERROR,"修改信息失败",i);
    }

    /**
     * 查询列表并分页且模糊查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseListInfo(String requestBody) {
        JSONObject jsonObject=JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String requestId = jsonObject.getString("requestId");//问题分类
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        if(StringUtils.isEmpty(projectId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时projectId未传!",projectId);
        }
        if(StringUtils.isEmpty(requestId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时采购申请d未传!",requestId);
        }

        Page<PurchaseList> page = new Page<>();
        int totalCount = purchaseListMapper.purchaseListCounts(projectId,requestId);
        page.init(totalCount,pageNo,pageSize);
        List<PurchaseList> list = purchaseListMapper.queryPurchaseListInfo(projectId,requestId,page.getRowNum(), page.getPageCount());
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;
    }

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage updateDeleteTimeByIds(List<String> ids) {
        PurchaseList purchaseList = null;
        /*Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = null;
        try {
            time = sdf.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        for (int j = 0 ;j < ids.size() ; j++) {
            String id = ids.get(j);
            purchaseList = purchaseListMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(String.valueOf(purchaseList.getDeleteTime()))){
                return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的列表问题id："+purchaseList.getId()+" ： "+purchaseList.getDeleteTime());
            }
        }
        int i = purchaseListMapper.updateDeleteTimeByIds(ids);

        if(i == 0){
            return new ResponseMessage(Code.CODE_ERROR,"批量删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"批量删除成功！",i);
    }



    /**
     *TODO ----------Excel导入（poi）
     * @param file
     * @return
     */
    @Override
    public ResponseMessage insertExcel(MultipartFile file)  throws IOException, ParseException {
        InputStream is;

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (WDWUtil.isExcel2007(file.getOriginalFilename())) {
            isExcel2003 = false;
        }
        is = file.getInputStream();
        Workbook workbook = read(is, isExcel2003);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row!=null){
                PurchaseList plan = new PurchaseList();
                plan.setId(String.valueOf(IDUtils.genItemId()));
                //设置品名
                if(!StringUtils.isEmpty(row.getCell(0).toString())){

                    plan.setName(row.getCell(0).toString());
                }
                // 设置品牌
                if (!StringUtils.isEmpty(row.getCell(1).toString())) {
                    plan.setBrand(row.getCell(1).toString());
                }
                // 设置型号
                if (!StringUtils.isEmpty(row.getCell(2).toString())) {
                    plan.setModel(row.getCell(2).toString());
                }
                // 设置规格
                if (!StringUtils.isEmpty(row.getCell(3).toString())) {
                    plan.setSpec(row.getCell(3).toString());
                }
                // 设置数量
                if (!StringUtils.isEmpty(row.getCell(4).toString())) {
                    BigDecimal decimal = new BigDecimal(row.getCell(4).toString());
                    decimal=decimal.setScale(3, BigDecimal.ROUND_HALF_UP);
                    plan.setQuantity(decimal);
                }

                // 设置单位
                if (!StringUtils.isEmpty(row.getCell(5).toString())) {
                    plan.setUnit(row.getCell(5).toString());
                }
                // 设置需求人
                if (!StringUtils.isEmpty(row.getCell(6).toString())) {
                    plan.setDemander(row.getCell(6).toString());
                }
                // 设置需求说明
                if (!StringUtils.isEmpty(row.getCell(7).toString())) {
                    plan.setContent(row.getCell(7).toString());
                }
                // 设置备注
                if (!StringUtils.isEmpty(row.getCell(8).toString())) {
                    plan.setRemark(row.getCell(8).toString());
                }
                plan.setCreateTime(new Date());
                int agendaInsert = planMapper.insertSelective(plan);
                if (agendaInsert != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "导入失败");
                }
            }
        }
        return new ResponseMessage(Code.CODE_OK, "导入成功");
    }

    /**
     *TODO------- Excel导入（EasyPoi）
     * @param list
     * @return
     */
   /* @Override
    public ResponseMessage insertExcelByEasyPoi(List<PurchaseList> list,String loginId) throws Exception{

        for (PurchaseList plan : list) {

            String id = String.valueOf(IDUtils.genItemId());


            *//*Project project = new Project();
            project.setId(String.valueOf(IDUtils.genItemId()));
            project.setProjectName(plan.getProjectName());
            project.setCreator(loginId);
            project.setCreateTime(new Date());
            project.setSchedule("1");
            project.setProjectType(plan.getProjectType());
            int i1 = projectMapper.insertSelective(project);
            if(i1!=1){
                return new ResponseMessage(Code.CODE_ERROR, "导入失败");
            }*//*

            plan.setId(String.valueOf(IDUtils.genItemId()));
            plan.setCreateTime(new Date());
            plan.setProjectId(id);
            int i = planMapper.insertSelective(plan);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR, "导入失败");
            }
            updateUtil.projectMethod(id,null,plan.getProjectName(),
                    plan.getProjectType(),"A",loginId,plan.getOrganization(),
                    plan.getAmount().toString(),"Aa1",plan.getInvestor());
        }
        return new ResponseMessage(Code.CODE_OK, "导入成功");
    }*/
    // 根据不同类型的文件 创建不同的处理对象
    public Workbook read(InputStream inputStream, boolean isExcel2003) throws IOException {
        /** 根据版本选择创建Workbook的方式 */
        Workbook wb;
        if (isExcel2003) {
            wb = new HSSFWorkbook(inputStream);
        } else {
            wb = new XSSFWorkbook(inputStream);
        }
        return wb;
    }

}
