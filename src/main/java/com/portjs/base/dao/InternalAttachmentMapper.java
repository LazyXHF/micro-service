package com.portjs.base.dao;

import com.portjs.base.entity.InternalAttachment;
import com.portjs.base.entity.InternalAttachmentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InternalAttachmentMapper {
    int countByExample(InternalAttachmentExample example);

    int deleteByExample(InternalAttachmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(InternalAttachment record);

    int insertSelective(InternalAttachment record);

    List<InternalAttachment> selectByExample(InternalAttachmentExample example);

    InternalAttachment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InternalAttachment record, @Param("example") InternalAttachmentExample example);

    int updateByExample(@Param("record") InternalAttachment record, @Param("example") InternalAttachmentExample example);

    int updateByPrimaryKeySelective(InternalAttachment record);

    int updateByPrimaryKey(InternalAttachment record);

    List<InternalAttachment> queryProjectFiles(@Param("id") String id);

    List<InternalAttachment> queryProjectRecords(String id);

    int updateByrelateddomainId(InternalAttachment internalAttachment);


    List<InternalAttachment> queryPucharseReviewFiles(@Param("id") String id);
}