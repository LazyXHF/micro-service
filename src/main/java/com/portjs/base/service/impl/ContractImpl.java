package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ContractMapper;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.PurchaseReviewMapper;
import com.portjs.base.dao.TenderApplicationMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.ContractService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.vo.ContractVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dengshuangzhen on 2019\4\10 0010
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContractImpl implements ContractService {
    @Autowired
    private PurchaseReviewMapper reviewMapper;
    @Autowired
    private TenderApplicationMapper applicationMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 查询合同来源
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage selectContractSource(String responseBody) {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String method = jsonObject.getString("method");//采购方式
        String projectCode = jsonObject.getString("projectCode");//项目id
        String projectName = jsonObject.getString("projectName");//项目名称
        Integer pageNum = jsonObject.getInteger("pageNum");//当前页数
        Integer pageCount = jsonObject.getInteger("pageCount");//每页显示记录数
        //首先判断采购方式
        if(method.equals("1")||method.equals("2")){
            //查询招标申请单
            //查询总数
            int count = applicationMapper.selectByMethodCount(method,projectCode,projectName);
            Page page = new Page();
            page.init(count,pageNum,pageCount);
            //查询每页数据
            List<ContractVo> contractVoList= applicationMapper.selectByPage(method,projectCode,projectName,page.getRowNum(),page.getPageCount());
            if (!CollectionUtils.isEmpty(contractVoList)) {
                for (ContractVo vo : contractVoList) {
                  vo.setSource("招标申请单");
                }
            }

            page.setList(contractVoList);
            return new ResponseMessage(Code.CODE_OK,"查询成功",page);
        }
        if(method.equals("3")||method.equals("4")||method.equals("5")||method.equals("6")){
            //查询采购评审单
            //查询总数
            int count = reviewMapper.selectByMethodCount(method,projectCode,projectName);
            Page page = new Page();
            page.init(count,pageNum,pageCount);
            //查询每页数据
            List<ContractVo> contractVoList= reviewMapper.selectByPage(method,projectCode,projectName,page.getRowNum(),page.getPageCount());
            if(!CollectionUtils.isEmpty(contractVoList)){
                for (ContractVo vo : contractVoList) {
                    vo.setSource("采购申请单");
                }
            }
            page.setList(contractVoList);
            return new ResponseMessage(Code.CODE_OK,"查询成功",page);
        }

        return new ResponseMessage(Code.CODE_ERROR,"查询失败");
    }

    /**
     * 新增合同
     * @param contract
     * @return
     */
    @Override
    public ResponseMessage insertContract(Contract contract) {
        contract.setId(String.valueOf(IDUtils.genItemId()));
        contract.setCreateTime(new Date());
        int i = contractMapper.insertSelective(contract);
        if(i!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"新增失败");
        }
        return  new ResponseMessage(Code.CODE_OK,"新增成功");
    }

    /**
     * 合同查询
     * @param contract
     * @return
     */
    @Override
    public ResponseMessage selectContract(ContractVo contract) {
        /*JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String projectCode = jsonObject.getString("projectCode");//项目编号
        String projectName = jsonObject.getString("projectName");//项目名称
        String supplier = jsonObject.getString("supplier");//合作单位
        String inCharge = jsonObject.getString("inCharge");//负责人
        String amount = jsonObject.getString("amount");//合同金额
        Date validDate = jsonObject.getDate("validDate");//合同有效期
        int pageNum = jsonObject.getInteger("pageNum");//当前页数
        int pageCount = jsonObject.getInteger("pageCount");//每页显示记录数*/
        int count = contractMapper.selectCount(contract);
        Page page = new Page();
        page.init(count,contract.getPageNum(),contract.getPageCount());
        contract.setRowNum(page.getRowNum());
        List<ContractVo> contractVoList= contractMapper.selectBypage(contract);

        page.setList(contractVoList);
        return  new ResponseMessage(Code.CODE_OK,"查询成功",page);
    }


    /**
     * 合同详情查询
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectContractDetails(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        if(contract==null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败");
        }
        ContractVo vo = new ContractVo();
        vo.setPurchaseDept(contract.getPurchaseDept());
        vo.setSupplier(contract.getSupplier());
        vo.setAmount(contract.getAmount().toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        vo.setSignDate(format.format(contract.getSignDate()));
        vo.setValidDate(format.format(contract.getValidDate()));
        vo.setFileUrl(contract.getFileUrl());
        vo.setContractNum(contract.getContractNum());
        Project project = projectMapper.selectByPrimaryKey(contract.getProjectId());
        vo.setProjectName(project.getProjectName());

        if(contract.getSource().equals("采购申请单")){
            PurchaseReview review = reviewMapper.selectByPrimaryKey(contract.getSourceId());
            vo.setTenderNum(review.getReviewNum());
        }else if(contract.getSource().equals("招标申请单")) {
            TenderApplication tender = applicationMapper.selectByPrimaryKey(contract.getSourceId());
            vo.setTenderNum(tender.getTenderNum());
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功",vo);


    }
}
