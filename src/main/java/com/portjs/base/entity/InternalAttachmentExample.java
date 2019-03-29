package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InternalAttachmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InternalAttachmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNull() {
            addCriterion("uploader is null");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNotNull() {
            addCriterion("uploader is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderEqualTo(String value) {
            addCriterion("uploader =", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotEqualTo(String value) {
            addCriterion("uploader <>", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThan(String value) {
            addCriterion("uploader >", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThanOrEqualTo(String value) {
            addCriterion("uploader >=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThan(String value) {
            addCriterion("uploader <", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThanOrEqualTo(String value) {
            addCriterion("uploader <=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLike(String value) {
            addCriterion("uploader like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotLike(String value) {
            addCriterion("uploader not like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderIn(List<String> values) {
            addCriterion("uploader in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotIn(List<String> values) {
            addCriterion("uploader not in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderBetween(String value1, String value2) {
            addCriterion("uploader between", value1, value2, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotBetween(String value1, String value2) {
            addCriterion("uploader not between", value1, value2, "uploader");
            return (Criteria) this;
        }

        public Criteria andModiferIsNull() {
            addCriterion("modifer is null");
            return (Criteria) this;
        }

        public Criteria andModiferIsNotNull() {
            addCriterion("modifer is not null");
            return (Criteria) this;
        }

        public Criteria andModiferEqualTo(String value) {
            addCriterion("modifer =", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferNotEqualTo(String value) {
            addCriterion("modifer <>", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferGreaterThan(String value) {
            addCriterion("modifer >", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferGreaterThanOrEqualTo(String value) {
            addCriterion("modifer >=", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferLessThan(String value) {
            addCriterion("modifer <", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferLessThanOrEqualTo(String value) {
            addCriterion("modifer <=", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferLike(String value) {
            addCriterion("modifer like", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferNotLike(String value) {
            addCriterion("modifer not like", value, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferIn(List<String> values) {
            addCriterion("modifer in", values, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferNotIn(List<String> values) {
            addCriterion("modifer not in", values, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferBetween(String value1, String value2) {
            addCriterion("modifer between", value1, value2, "modifer");
            return (Criteria) this;
        }

        public Criteria andModiferNotBetween(String value1, String value2) {
            addCriterion("modifer not between", value1, value2, "modifer");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIsNull() {
            addCriterion("relateddomain is null");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIsNotNull() {
            addCriterion("relateddomain is not null");
            return (Criteria) this;
        }

        public Criteria andRelateddomainEqualTo(String value) {
            addCriterion("relateddomain =", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainNotEqualTo(String value) {
            addCriterion("relateddomain <>", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainGreaterThan(String value) {
            addCriterion("relateddomain >", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainGreaterThanOrEqualTo(String value) {
            addCriterion("relateddomain >=", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainLessThan(String value) {
            addCriterion("relateddomain <", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainLessThanOrEqualTo(String value) {
            addCriterion("relateddomain <=", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainLike(String value) {
            addCriterion("relateddomain like", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainNotLike(String value) {
            addCriterion("relateddomain not like", value, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIn(List<String> values) {
            addCriterion("relateddomain in", values, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainNotIn(List<String> values) {
            addCriterion("relateddomain not in", values, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainBetween(String value1, String value2) {
            addCriterion("relateddomain between", value1, value2, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andRelateddomainNotBetween(String value1, String value2) {
            addCriterion("relateddomain not between", value1, value2, "relateddomain");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileModuleIsNull() {
            addCriterion("file_module is null");
            return (Criteria) this;
        }

        public Criteria andFileModuleIsNotNull() {
            addCriterion("file_module is not null");
            return (Criteria) this;
        }

        public Criteria andFileModuleEqualTo(String value) {
            addCriterion("file_module =", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleNotEqualTo(String value) {
            addCriterion("file_module <>", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleGreaterThan(String value) {
            addCriterion("file_module >", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleGreaterThanOrEqualTo(String value) {
            addCriterion("file_module >=", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleLessThan(String value) {
            addCriterion("file_module <", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleLessThanOrEqualTo(String value) {
            addCriterion("file_module <=", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleLike(String value) {
            addCriterion("file_module like", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleNotLike(String value) {
            addCriterion("file_module not like", value, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleIn(List<String> values) {
            addCriterion("file_module in", values, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleNotIn(List<String> values) {
            addCriterion("file_module not in", values, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleBetween(String value1, String value2) {
            addCriterion("file_module between", value1, value2, "fileModule");
            return (Criteria) this;
        }

        public Criteria andFileModuleNotBetween(String value1, String value2) {
            addCriterion("file_module not between", value1, value2, "fileModule");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdIsNull() {
            addCriterion("relateddomain_id is null");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdIsNotNull() {
            addCriterion("relateddomain_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdEqualTo(String value) {
            addCriterion("relateddomain_id =", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdNotEqualTo(String value) {
            addCriterion("relateddomain_id <>", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdGreaterThan(String value) {
            addCriterion("relateddomain_id >", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdGreaterThanOrEqualTo(String value) {
            addCriterion("relateddomain_id >=", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdLessThan(String value) {
            addCriterion("relateddomain_id <", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdLessThanOrEqualTo(String value) {
            addCriterion("relateddomain_id <=", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdLike(String value) {
            addCriterion("relateddomain_id like", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdNotLike(String value) {
            addCriterion("relateddomain_id not like", value, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdIn(List<String> values) {
            addCriterion("relateddomain_id in", values, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdNotIn(List<String> values) {
            addCriterion("relateddomain_id not in", values, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdBetween(String value1, String value2) {
            addCriterion("relateddomain_id between", value1, value2, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andRelateddomainIdNotBetween(String value1, String value2) {
            addCriterion("relateddomain_id not between", value1, value2, "relateddomainId");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Double value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Double value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Double value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Double value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Double value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Double> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Double> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Double value1, Double value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Double value1, Double value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(String value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(String value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(String value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(String value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(String value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(String value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(String value) {
            addCriterion("enable like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(String value) {
            addCriterion("enable not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<String> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<String> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(String value1, String value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(String value1, String value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andBackUp1IsNull() {
            addCriterion("back_up1 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp1IsNotNull() {
            addCriterion("back_up1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp1EqualTo(String value) {
            addCriterion("back_up1 =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotEqualTo(String value) {
            addCriterion("back_up1 <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThan(String value) {
            addCriterion("back_up1 >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThanOrEqualTo(String value) {
            addCriterion("back_up1 >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThan(String value) {
            addCriterion("back_up1 <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThanOrEqualTo(String value) {
            addCriterion("back_up1 <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1Like(String value) {
            addCriterion("back_up1 like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotLike(String value) {
            addCriterion("back_up1 not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1In(List<String> values) {
            addCriterion("back_up1 in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotIn(List<String> values) {
            addCriterion("back_up1 not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1Between(String value1, String value2) {
            addCriterion("back_up1 between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotBetween(String value1, String value2) {
            addCriterion("back_up1 not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andBackUp2IsNull() {
            addCriterion("back_up2 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp2IsNotNull() {
            addCriterion("back_up2 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp2EqualTo(String value) {
            addCriterion("back_up2 =", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotEqualTo(String value) {
            addCriterion("back_up2 <>", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2GreaterThan(String value) {
            addCriterion("back_up2 >", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2GreaterThanOrEqualTo(String value) {
            addCriterion("back_up2 >=", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2LessThan(String value) {
            addCriterion("back_up2 <", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2LessThanOrEqualTo(String value) {
            addCriterion("back_up2 <=", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2Like(String value) {
            addCriterion("back_up2 like", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotLike(String value) {
            addCriterion("back_up2 not like", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2In(List<String> values) {
            addCriterion("back_up2 in", values, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotIn(List<String> values) {
            addCriterion("back_up2 not in", values, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2Between(String value1, String value2) {
            addCriterion("back_up2 between", value1, value2, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotBetween(String value1, String value2) {
            addCriterion("back_up2 not between", value1, value2, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp3IsNull() {
            addCriterion("back_up3 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp3IsNotNull() {
            addCriterion("back_up3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp3EqualTo(String value) {
            addCriterion("back_up3 =", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotEqualTo(String value) {
            addCriterion("back_up3 <>", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3GreaterThan(String value) {
            addCriterion("back_up3 >", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3GreaterThanOrEqualTo(String value) {
            addCriterion("back_up3 >=", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3LessThan(String value) {
            addCriterion("back_up3 <", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3LessThanOrEqualTo(String value) {
            addCriterion("back_up3 <=", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3Like(String value) {
            addCriterion("back_up3 like", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotLike(String value) {
            addCriterion("back_up3 not like", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3In(List<String> values) {
            addCriterion("back_up3 in", values, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotIn(List<String> values) {
            addCriterion("back_up3 not in", values, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3Between(String value1, String value2) {
            addCriterion("back_up3 between", value1, value2, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotBetween(String value1, String value2) {
            addCriterion("back_up3 not between", value1, value2, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp4IsNull() {
            addCriterion("back_up4 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp4IsNotNull() {
            addCriterion("back_up4 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp4EqualTo(String value) {
            addCriterion("back_up4 =", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotEqualTo(String value) {
            addCriterion("back_up4 <>", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4GreaterThan(String value) {
            addCriterion("back_up4 >", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4GreaterThanOrEqualTo(String value) {
            addCriterion("back_up4 >=", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4LessThan(String value) {
            addCriterion("back_up4 <", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4LessThanOrEqualTo(String value) {
            addCriterion("back_up4 <=", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4Like(String value) {
            addCriterion("back_up4 like", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotLike(String value) {
            addCriterion("back_up4 not like", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4In(List<String> values) {
            addCriterion("back_up4 in", values, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotIn(List<String> values) {
            addCriterion("back_up4 not in", values, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4Between(String value1, String value2) {
            addCriterion("back_up4 between", value1, value2, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotBetween(String value1, String value2) {
            addCriterion("back_up4 not between", value1, value2, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp5IsNull() {
            addCriterion("back_up5 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp5IsNotNull() {
            addCriterion("back_up5 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp5EqualTo(String value) {
            addCriterion("back_up5 =", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotEqualTo(String value) {
            addCriterion("back_up5 <>", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5GreaterThan(String value) {
            addCriterion("back_up5 >", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5GreaterThanOrEqualTo(String value) {
            addCriterion("back_up5 >=", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5LessThan(String value) {
            addCriterion("back_up5 <", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5LessThanOrEqualTo(String value) {
            addCriterion("back_up5 <=", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5Like(String value) {
            addCriterion("back_up5 like", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotLike(String value) {
            addCriterion("back_up5 not like", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5In(List<String> values) {
            addCriterion("back_up5 in", values, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotIn(List<String> values) {
            addCriterion("back_up5 not in", values, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5Between(String value1, String value2) {
            addCriterion("back_up5 between", value1, value2, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotBetween(String value1, String value2) {
            addCriterion("back_up5 not between", value1, value2, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp6IsNull() {
            addCriterion("back_up6 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp6IsNotNull() {
            addCriterion("back_up6 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp6EqualTo(String value) {
            addCriterion("back_up6 =", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6NotEqualTo(String value) {
            addCriterion("back_up6 <>", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6GreaterThan(String value) {
            addCriterion("back_up6 >", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6GreaterThanOrEqualTo(String value) {
            addCriterion("back_up6 >=", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6LessThan(String value) {
            addCriterion("back_up6 <", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6LessThanOrEqualTo(String value) {
            addCriterion("back_up6 <=", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6Like(String value) {
            addCriterion("back_up6 like", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6NotLike(String value) {
            addCriterion("back_up6 not like", value, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6In(List<String> values) {
            addCriterion("back_up6 in", values, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6NotIn(List<String> values) {
            addCriterion("back_up6 not in", values, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6Between(String value1, String value2) {
            addCriterion("back_up6 between", value1, value2, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp6NotBetween(String value1, String value2) {
            addCriterion("back_up6 not between", value1, value2, "backUp6");
            return (Criteria) this;
        }

        public Criteria andBackUp7IsNull() {
            addCriterion("back_up7 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp7IsNotNull() {
            addCriterion("back_up7 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp7EqualTo(String value) {
            addCriterion("back_up7 =", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7NotEqualTo(String value) {
            addCriterion("back_up7 <>", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7GreaterThan(String value) {
            addCriterion("back_up7 >", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7GreaterThanOrEqualTo(String value) {
            addCriterion("back_up7 >=", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7LessThan(String value) {
            addCriterion("back_up7 <", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7LessThanOrEqualTo(String value) {
            addCriterion("back_up7 <=", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7Like(String value) {
            addCriterion("back_up7 like", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7NotLike(String value) {
            addCriterion("back_up7 not like", value, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7In(List<String> values) {
            addCriterion("back_up7 in", values, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7NotIn(List<String> values) {
            addCriterion("back_up7 not in", values, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7Between(String value1, String value2) {
            addCriterion("back_up7 between", value1, value2, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp7NotBetween(String value1, String value2) {
            addCriterion("back_up7 not between", value1, value2, "backUp7");
            return (Criteria) this;
        }

        public Criteria andBackUp8IsNull() {
            addCriterion("back_up8 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp8IsNotNull() {
            addCriterion("back_up8 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp8EqualTo(String value) {
            addCriterion("back_up8 =", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8NotEqualTo(String value) {
            addCriterion("back_up8 <>", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8GreaterThan(String value) {
            addCriterion("back_up8 >", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8GreaterThanOrEqualTo(String value) {
            addCriterion("back_up8 >=", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8LessThan(String value) {
            addCriterion("back_up8 <", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8LessThanOrEqualTo(String value) {
            addCriterion("back_up8 <=", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8Like(String value) {
            addCriterion("back_up8 like", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8NotLike(String value) {
            addCriterion("back_up8 not like", value, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8In(List<String> values) {
            addCriterion("back_up8 in", values, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8NotIn(List<String> values) {
            addCriterion("back_up8 not in", values, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8Between(String value1, String value2) {
            addCriterion("back_up8 between", value1, value2, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp8NotBetween(String value1, String value2) {
            addCriterion("back_up8 not between", value1, value2, "backUp8");
            return (Criteria) this;
        }

        public Criteria andBackUp9IsNull() {
            addCriterion("back_up9 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp9IsNotNull() {
            addCriterion("back_up9 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp9EqualTo(String value) {
            addCriterion("back_up9 =", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9NotEqualTo(String value) {
            addCriterion("back_up9 <>", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9GreaterThan(String value) {
            addCriterion("back_up9 >", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9GreaterThanOrEqualTo(String value) {
            addCriterion("back_up9 >=", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9LessThan(String value) {
            addCriterion("back_up9 <", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9LessThanOrEqualTo(String value) {
            addCriterion("back_up9 <=", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9Like(String value) {
            addCriterion("back_up9 like", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9NotLike(String value) {
            addCriterion("back_up9 not like", value, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9In(List<String> values) {
            addCriterion("back_up9 in", values, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9NotIn(List<String> values) {
            addCriterion("back_up9 not in", values, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9Between(String value1, String value2) {
            addCriterion("back_up9 between", value1, value2, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp9NotBetween(String value1, String value2) {
            addCriterion("back_up9 not between", value1, value2, "backUp9");
            return (Criteria) this;
        }

        public Criteria andBackUp10IsNull() {
            addCriterion("back_up10 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp10IsNotNull() {
            addCriterion("back_up10 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp10EqualTo(String value) {
            addCriterion("back_up10 =", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10NotEqualTo(String value) {
            addCriterion("back_up10 <>", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10GreaterThan(String value) {
            addCriterion("back_up10 >", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10GreaterThanOrEqualTo(String value) {
            addCriterion("back_up10 >=", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10LessThan(String value) {
            addCriterion("back_up10 <", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10LessThanOrEqualTo(String value) {
            addCriterion("back_up10 <=", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10Like(String value) {
            addCriterion("back_up10 like", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10NotLike(String value) {
            addCriterion("back_up10 not like", value, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10In(List<String> values) {
            addCriterion("back_up10 in", values, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10NotIn(List<String> values) {
            addCriterion("back_up10 not in", values, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10Between(String value1, String value2) {
            addCriterion("back_up10 between", value1, value2, "backUp10");
            return (Criteria) this;
        }

        public Criteria andBackUp10NotBetween(String value1, String value2) {
            addCriterion("back_up10 not between", value1, value2, "backUp10");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}