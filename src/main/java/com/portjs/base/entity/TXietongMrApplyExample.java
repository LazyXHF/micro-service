package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXietongMrApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXietongMrApplyExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andNextApproverIsNull() {
            addCriterion("next_approver is null");
            return (Criteria) this;
        }

        public Criteria andNextApproverIsNotNull() {
            addCriterion("next_approver is not null");
            return (Criteria) this;
        }

        public Criteria andNextApproverEqualTo(String value) {
            addCriterion("next_approver =", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverNotEqualTo(String value) {
            addCriterion("next_approver <>", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverGreaterThan(String value) {
            addCriterion("next_approver >", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverGreaterThanOrEqualTo(String value) {
            addCriterion("next_approver >=", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverLessThan(String value) {
            addCriterion("next_approver <", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverLessThanOrEqualTo(String value) {
            addCriterion("next_approver <=", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverLike(String value) {
            addCriterion("next_approver like", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverNotLike(String value) {
            addCriterion("next_approver not like", value, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverIn(List<String> values) {
            addCriterion("next_approver in", values, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverNotIn(List<String> values) {
            addCriterion("next_approver not in", values, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverBetween(String value1, String value2) {
            addCriterion("next_approver between", value1, value2, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverNotBetween(String value1, String value2) {
            addCriterion("next_approver not between", value1, value2, "nextApprover");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdIsNull() {
            addCriterion("next_approver_id is null");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdIsNotNull() {
            addCriterion("next_approver_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdEqualTo(String value) {
            addCriterion("next_approver_id =", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdNotEqualTo(String value) {
            addCriterion("next_approver_id <>", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdGreaterThan(String value) {
            addCriterion("next_approver_id >", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdGreaterThanOrEqualTo(String value) {
            addCriterion("next_approver_id >=", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdLessThan(String value) {
            addCriterion("next_approver_id <", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdLessThanOrEqualTo(String value) {
            addCriterion("next_approver_id <=", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdLike(String value) {
            addCriterion("next_approver_id like", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdNotLike(String value) {
            addCriterion("next_approver_id not like", value, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdIn(List<String> values) {
            addCriterion("next_approver_id in", values, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdNotIn(List<String> values) {
            addCriterion("next_approver_id not in", values, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdBetween(String value1, String value2) {
            addCriterion("next_approver_id between", value1, value2, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andNextApproverIdNotBetween(String value1, String value2) {
            addCriterion("next_approver_id not between", value1, value2, "nextApproverId");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsIsNull() {
            addCriterion("next_record_ids is null");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsIsNotNull() {
            addCriterion("next_record_ids is not null");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsEqualTo(String value) {
            addCriterion("next_record_ids =", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsNotEqualTo(String value) {
            addCriterion("next_record_ids <>", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsGreaterThan(String value) {
            addCriterion("next_record_ids >", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsGreaterThanOrEqualTo(String value) {
            addCriterion("next_record_ids >=", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsLessThan(String value) {
            addCriterion("next_record_ids <", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsLessThanOrEqualTo(String value) {
            addCriterion("next_record_ids <=", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsLike(String value) {
            addCriterion("next_record_ids like", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsNotLike(String value) {
            addCriterion("next_record_ids not like", value, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsIn(List<String> values) {
            addCriterion("next_record_ids in", values, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsNotIn(List<String> values) {
            addCriterion("next_record_ids not in", values, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsBetween(String value1, String value2) {
            addCriterion("next_record_ids between", value1, value2, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andNextRecordIdsNotBetween(String value1, String value2) {
            addCriterion("next_record_ids not between", value1, value2, "nextRecordIds");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNameEqualTo(String value) {
            addCriterion("apply_name =", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThan(String value) {
            addCriterion("apply_name >", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThan(String value) {
            addCriterion("apply_name <", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLike(String value) {
            addCriterion("apply_name like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotLike(String value) {
            addCriterion("apply_name not like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameIn(List<String> values) {
            addCriterion("apply_name in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdIsNull() {
            addCriterion("apply_dep_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdIsNotNull() {
            addCriterion("apply_dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdEqualTo(String value) {
            addCriterion("apply_dep_id =", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdNotEqualTo(String value) {
            addCriterion("apply_dep_id <>", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdGreaterThan(String value) {
            addCriterion("apply_dep_id >", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_dep_id >=", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdLessThan(String value) {
            addCriterion("apply_dep_id <", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdLessThanOrEqualTo(String value) {
            addCriterion("apply_dep_id <=", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdLike(String value) {
            addCriterion("apply_dep_id like", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdNotLike(String value) {
            addCriterion("apply_dep_id not like", value, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdIn(List<String> values) {
            addCriterion("apply_dep_id in", values, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdNotIn(List<String> values) {
            addCriterion("apply_dep_id not in", values, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdBetween(String value1, String value2) {
            addCriterion("apply_dep_id between", value1, value2, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepIdNotBetween(String value1, String value2) {
            addCriterion("apply_dep_id not between", value1, value2, "applyDepId");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameIsNull() {
            addCriterion("apply_dep_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameIsNotNull() {
            addCriterion("apply_dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameEqualTo(String value) {
            addCriterion("apply_dep_name =", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameNotEqualTo(String value) {
            addCriterion("apply_dep_name <>", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameGreaterThan(String value) {
            addCriterion("apply_dep_name >", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_dep_name >=", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameLessThan(String value) {
            addCriterion("apply_dep_name <", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameLessThanOrEqualTo(String value) {
            addCriterion("apply_dep_name <=", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameLike(String value) {
            addCriterion("apply_dep_name like", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameNotLike(String value) {
            addCriterion("apply_dep_name not like", value, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameIn(List<String> values) {
            addCriterion("apply_dep_name in", values, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameNotIn(List<String> values) {
            addCriterion("apply_dep_name not in", values, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameBetween(String value1, String value2) {
            addCriterion("apply_dep_name between", value1, value2, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andApplyDepNameNotBetween(String value1, String value2) {
            addCriterion("apply_dep_name not between", value1, value2, "applyDepName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMrResIdIsNull() {
            addCriterion("mr_res_id is null");
            return (Criteria) this;
        }

        public Criteria andMrResIdIsNotNull() {
            addCriterion("mr_res_id is not null");
            return (Criteria) this;
        }

        public Criteria andMrResIdEqualTo(String value) {
            addCriterion("mr_res_id =", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdNotEqualTo(String value) {
            addCriterion("mr_res_id <>", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdGreaterThan(String value) {
            addCriterion("mr_res_id >", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdGreaterThanOrEqualTo(String value) {
            addCriterion("mr_res_id >=", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdLessThan(String value) {
            addCriterion("mr_res_id <", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdLessThanOrEqualTo(String value) {
            addCriterion("mr_res_id <=", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdLike(String value) {
            addCriterion("mr_res_id like", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdNotLike(String value) {
            addCriterion("mr_res_id not like", value, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdIn(List<String> values) {
            addCriterion("mr_res_id in", values, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdNotIn(List<String> values) {
            addCriterion("mr_res_id not in", values, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdBetween(String value1, String value2) {
            addCriterion("mr_res_id between", value1, value2, "mrResId");
            return (Criteria) this;
        }

        public Criteria andMrResIdNotBetween(String value1, String value2) {
            addCriterion("mr_res_id not between", value1, value2, "mrResId");
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