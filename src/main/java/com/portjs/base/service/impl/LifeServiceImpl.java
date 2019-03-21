package com.portjs.base.service.impl;

import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.LifeService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class LifeServiceImpl implements LifeService {
    private String message = "";
    private Integer code;
    @Autowired
    private LifeMapper lifeMapper;
    @Autowired
    private ApprovalMapper approvalMapper;
    @Autowired
    private InternalPactMapper internalPactMapper;
    @Autowired
    private DesignMapper designMapper;
    @Autowired
    private ConstructionMapper constructionMapper;
    @Autowired
    private  PilotMapper pilotMapper;
    @Autowired
    private AcceptanceMapper acceptanceMapper;

    @Override
    public ResponseMessage insertSelective(List<Life> record) {
        int count = 0;
        for(int i =0;i<record.size();i++){
            Life f = record.get(i);
            if(StringUtils.isEmpty(f.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "projectId未传");
            }
            //节点1.立项2.合同签订3.需求设计4.开发测试5.试运行6验收
            switch (f.getNode()){
                case"1":
                    //检查立项中是否存在数据
                    Approval approval = new Approval();
                    approval.setProjectId(f.getProjectId());
                    List<Approval> approvals = approvalMapper.selectByPrimaryKey(approval);
                    if(CollectionUtils.isEmpty(approvals)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写项目立项后进行审核");
                    }
                    break;
                case"2":
                    //检查合同中是否存在数据
                    InternalPact internalPact = new InternalPact();
                    internalPact.setProjectId(f.getProjectId());
                    List<InternalPact> internalPacts = internalPactMapper.selectByPrimaryKey(internalPact);
                    if(CollectionUtils.isEmpty(internalPacts)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写项目合同后进行审核");
                    }
                    break;
                case"3":
                    //检查需求设计中是否存在数据
                    Design design = new Design();
                    design.setProjectId(f.getProjectId());
                    List<Design> designs = designMapper.selectByPrimaryKey(design);
                    if(CollectionUtils.isEmpty(designs)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写项目设计后进行审核");
                    }
                    break;
                case"4":
                    //检查开发测试中是否存在数据
                    Construction construction = new Construction();
                    construction.setProjectId(f.getProjectId());
                    List<Construction> constructions = constructionMapper.selectByPrimaryKey(construction);
                    if(CollectionUtils.isEmpty(constructions)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写项目开发后进行审核");
                    }
                    break;
                case"5":
                    //检查试运行是否存在数据
                    Pilot pilot = new Pilot();
                    pilot.setProjectId(f.getProjectId());
                    List<Pilot> pilots = pilotMapper.selectByPrimaryKey(pilot);
                    if(CollectionUtils.isEmpty(pilots)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写试点实施后进行审核");
                    }
                    break;
                case"6":
                    //检查验收中是否存在数据
                    Acceptance acceptance = new Acceptance();
                    acceptance.setProjectId(f.getProjectId());
                    List<Acceptance> acceptances = acceptanceMapper.selectByPrimaryKey(acceptance);
                    if(CollectionUtils.isEmpty(acceptances)){
                        return new ResponseMessage(Code.CODE_ERROR , "请填写项目验收后进行审核");
                    }
                    break;
            }
            //查询库中是否存在,存在更新,不存在插入
            Life life = new Life();
            life.setNode(f.getNode());
            life.setProjectId(f.getProjectId());
            List<Life> lifeList =lifeMapper.selectByPrimaryKey(life);
            if(!CollectionUtils.isEmpty(lifeList)){
                f.setId(lifeList.get(0).getId());
                count = lifeMapper.updateByPrimaryKeySelective(f);
            }else{
                f.setId(UUID.randomUUID().toString());
                f.setCreator(UserUtils.getCurrentUser().getId());
                count = lifeMapper.insertSelective(f);
            }
        }
        message = count > 0?"插入成功":"插入失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Life record) {
        List<Life> life = lifeMapper.selectByPrimaryKey(record);
        message = !CollectionUtils.isEmpty(life)?"查询成功":"查询失败";
        code = !CollectionUtils.isEmpty(life)? Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,life);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Life record) {
        int count = 0;
        count = lifeMapper.updateByPrimaryKeySelective(record);
        message = count > 0?"更新成功":"更新失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public int sumLine() {
        int count=0;
        List<Life> list = lifeMapper.sumLine();
        for(int i=0;i<list.size();i++){
            String projectId = list.get(i).getProjectId();
            Life life = new Life();
            life.setProjectId(projectId);
            life.setNode("6");
            life.setStatus("3");
            List<Life> lifeList =lifeMapper.selectByPrimaryKey(life);
            if(CollectionUtils.isEmpty(lifeList)){
                count++;
            }
        }
        return count;
    }

    @Override
    public BigDecimal sumMoney() {
        BigDecimal count = new BigDecimal(0);
        List<Life> list = lifeMapper.sumLine();
        for(int i=0;i<list.size();i++){
            String projectId = list.get(i).getProjectId();
            Life life = new Life();
            life.setProjectId(projectId);
            life.setNode("6");
            life.setStatus("3");
            List<Life> lifeList =lifeMapper.selectByPrimaryKey(life);
            if(CollectionUtils.isEmpty(lifeList)){
                Approval approval = new Approval();
                approval.setProjectId(projectId);
                List<Approval> approvals = approvalMapper.selectByPrimaryKey(approval);
                if(!CollectionUtils.isEmpty(approvals)){
                    count = count.add(approvals.get(0).getAmount());
                }
            }
        }
        return count;
    }
}
