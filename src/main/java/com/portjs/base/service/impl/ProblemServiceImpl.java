package com.portjs.base.service.impl;

import com.portjs.base.dao.ProblemMapper;
import com.portjs.base.entity.Problem;
import com.portjs.base.service.ProblemService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class ProblemServiceImpl   implements ProblemService {
    private String message = "";
    private Integer code;
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  problemMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Problem record) {
        int count = 0;
        try {
            count =  problemMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(Problem construction) {
        //组装bean
        if(StringUtils.isEmpty(construction.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目问题,projectId未传");
        }
        construction.setId(UUID.randomUUID().toString());
        construction.setCreater(UserUtils.getCurrentUser().getId());

        int  count =  problemMapper.insertSelective(construction);
        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Problem record) {
        List<Problem> design = null;
        try {
            design  =  problemMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Problem record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目问题,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  problemMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Problem record) {
        int count = 0;
        try {
            count =  problemMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
