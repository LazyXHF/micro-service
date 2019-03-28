package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TWorkflowstepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWorkflowstepExample() {
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

        public Criteria andPrestepIdIsNull() {
            addCriterion("prestep_id is null");
            return (Criteria) this;
        }

        public Criteria andPrestepIdIsNotNull() {
            addCriterion("prestep_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrestepIdEqualTo(String value) {
            addCriterion("prestep_id =", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdNotEqualTo(String value) {
            addCriterion("prestep_id <>", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdGreaterThan(String value) {
            addCriterion("prestep_id >", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdGreaterThanOrEqualTo(String value) {
            addCriterion("prestep_id >=", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdLessThan(String value) {
            addCriterion("prestep_id <", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdLessThanOrEqualTo(String value) {
            addCriterion("prestep_id <=", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdLike(String value) {
            addCriterion("prestep_id like", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdNotLike(String value) {
            addCriterion("prestep_id not like", value, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdIn(List<String> values) {
            addCriterion("prestep_id in", values, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdNotIn(List<String> values) {
            addCriterion("prestep_id not in", values, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdBetween(String value1, String value2) {
            addCriterion("prestep_id between", value1, value2, "prestepId");
            return (Criteria) this;
        }

        public Criteria andPrestepIdNotBetween(String value1, String value2) {
            addCriterion("prestep_id not between", value1, value2, "prestepId");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNull() {
            addCriterion("step_desc is null");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNotNull() {
            addCriterion("step_desc is not null");
            return (Criteria) this;
        }

        public Criteria andStepDescEqualTo(String value) {
            addCriterion("step_desc =", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotEqualTo(String value) {
            addCriterion("step_desc <>", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThan(String value) {
            addCriterion("step_desc >", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThanOrEqualTo(String value) {
            addCriterion("step_desc >=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThan(String value) {
            addCriterion("step_desc <", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThanOrEqualTo(String value) {
            addCriterion("step_desc <=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLike(String value) {
            addCriterion("step_desc like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotLike(String value) {
            addCriterion("step_desc not like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescIn(List<String> values) {
            addCriterion("step_desc in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotIn(List<String> values) {
            addCriterion("step_desc not in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescBetween(String value1, String value2) {
            addCriterion("step_desc between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotBetween(String value1, String value2) {
            addCriterion("step_desc not between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andActionuserIdIsNull() {
            addCriterion("actionuser_id is null");
            return (Criteria) this;
        }

        public Criteria andActionuserIdIsNotNull() {
            addCriterion("actionuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionuserIdEqualTo(String value) {
            addCriterion("actionuser_id =", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdNotEqualTo(String value) {
            addCriterion("actionuser_id <>", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdGreaterThan(String value) {
            addCriterion("actionuser_id >", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdGreaterThanOrEqualTo(String value) {
            addCriterion("actionuser_id >=", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdLessThan(String value) {
            addCriterion("actionuser_id <", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdLessThanOrEqualTo(String value) {
            addCriterion("actionuser_id <=", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdLike(String value) {
            addCriterion("actionuser_id like", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdNotLike(String value) {
            addCriterion("actionuser_id not like", value, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdIn(List<String> values) {
            addCriterion("actionuser_id in", values, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdNotIn(List<String> values) {
            addCriterion("actionuser_id not in", values, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdBetween(String value1, String value2) {
            addCriterion("actionuser_id between", value1, value2, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionuserIdNotBetween(String value1, String value2) {
            addCriterion("actionuser_id not between", value1, value2, "actionuserId");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNull() {
            addCriterion("action_time is null");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNotNull() {
            addCriterion("action_time is not null");
            return (Criteria) this;
        }

        public Criteria andActionTimeEqualTo(Date value) {
            addCriterion("action_time =", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotEqualTo(Date value) {
            addCriterion("action_time <>", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThan(Date value) {
            addCriterion("action_time >", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("action_time >=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThan(Date value) {
            addCriterion("action_time <", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThanOrEqualTo(Date value) {
            addCriterion("action_time <=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeIn(List<Date> values) {
            addCriterion("action_time in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotIn(List<Date> values) {
            addCriterion("action_time not in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeBetween(Date value1, Date value2) {
            addCriterion("action_time between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotBetween(Date value1, Date value2) {
            addCriterion("action_time not between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionResultIsNull() {
            addCriterion("action_result is null");
            return (Criteria) this;
        }

        public Criteria andActionResultIsNotNull() {
            addCriterion("action_result is not null");
            return (Criteria) this;
        }

        public Criteria andActionResultEqualTo(Integer value) {
            addCriterion("action_result =", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultNotEqualTo(Integer value) {
            addCriterion("action_result <>", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultGreaterThan(Integer value) {
            addCriterion("action_result >", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_result >=", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultLessThan(Integer value) {
            addCriterion("action_result <", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultLessThanOrEqualTo(Integer value) {
            addCriterion("action_result <=", value, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultIn(List<Integer> values) {
            addCriterion("action_result in", values, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultNotIn(List<Integer> values) {
            addCriterion("action_result not in", values, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultBetween(Integer value1, Integer value2) {
            addCriterion("action_result between", value1, value2, "actionResult");
            return (Criteria) this;
        }

        public Criteria andActionResultNotBetween(Integer value1, Integer value2) {
            addCriterion("action_result not between", value1, value2, "actionResult");
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

        public Criteria andActionCommentIsNull() {
            addCriterion("action_comment is null");
            return (Criteria) this;
        }

        public Criteria andActionCommentIsNotNull() {
            addCriterion("action_comment is not null");
            return (Criteria) this;
        }

        public Criteria andActionCommentEqualTo(String value) {
            addCriterion("action_comment =", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentNotEqualTo(String value) {
            addCriterion("action_comment <>", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentGreaterThan(String value) {
            addCriterion("action_comment >", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentGreaterThanOrEqualTo(String value) {
            addCriterion("action_comment >=", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentLessThan(String value) {
            addCriterion("action_comment <", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentLessThanOrEqualTo(String value) {
            addCriterion("action_comment <=", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentLike(String value) {
            addCriterion("action_comment like", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentNotLike(String value) {
            addCriterion("action_comment not like", value, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentIn(List<String> values) {
            addCriterion("action_comment in", values, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentNotIn(List<String> values) {
            addCriterion("action_comment not in", values, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentBetween(String value1, String value2) {
            addCriterion("action_comment between", value1, value2, "actionComment");
            return (Criteria) this;
        }

        public Criteria andActionCommentNotBetween(String value1, String value2) {
            addCriterion("action_comment not between", value1, value2, "actionComment");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBackup3IsNull() {
            addCriterion("backup_3 is null");
            return (Criteria) this;
        }

        public Criteria andBackup3IsNotNull() {
            addCriterion("backup_3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackup3EqualTo(String value) {
            addCriterion("backup_3 =", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotEqualTo(String value) {
            addCriterion("backup_3 <>", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThan(String value) {
            addCriterion("backup_3 >", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3GreaterThanOrEqualTo(String value) {
            addCriterion("backup_3 >=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThan(String value) {
            addCriterion("backup_3 <", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3LessThanOrEqualTo(String value) {
            addCriterion("backup_3 <=", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3Like(String value) {
            addCriterion("backup_3 like", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotLike(String value) {
            addCriterion("backup_3 not like", value, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3In(List<String> values) {
            addCriterion("backup_3 in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotIn(List<String> values) {
            addCriterion("backup_3 not in", values, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3Between(String value1, String value2) {
            addCriterion("backup_3 between", value1, value2, "backup3");
            return (Criteria) this;
        }

        public Criteria andBackup3NotBetween(String value1, String value2) {
            addCriterion("backup_3 not between", value1, value2, "backup3");
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