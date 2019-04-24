package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessConfigurationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessConfigurationExample() {
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

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNull() {
            addCriterion("schedule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNotNull() {
            addCriterion("schedule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleEqualTo(String value) {
            addCriterion("schedule =", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotEqualTo(String value) {
            addCriterion("schedule <>", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThan(String value) {
            addCriterion("schedule >", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("schedule >=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThan(String value) {
            addCriterion("schedule <", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThanOrEqualTo(String value) {
            addCriterion("schedule <=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLike(String value) {
            addCriterion("schedule like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotLike(String value) {
            addCriterion("schedule not like", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleIn(List<String> values) {
            addCriterion("schedule in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotIn(List<String> values) {
            addCriterion("schedule not in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleBetween(String value1, String value2) {
            addCriterion("schedule between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotBetween(String value1, String value2) {
            addCriterion("schedule not between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andNodeIsNull() {
            addCriterion("node is null");
            return (Criteria) this;
        }

        public Criteria andNodeIsNotNull() {
            addCriterion("node is not null");
            return (Criteria) this;
        }

        public Criteria andNodeEqualTo(String value) {
            addCriterion("node =", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeNotEqualTo(String value) {
            addCriterion("node <>", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeGreaterThan(String value) {
            addCriterion("node >", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeGreaterThanOrEqualTo(String value) {
            addCriterion("node >=", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeLessThan(String value) {
            addCriterion("node <", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeLessThanOrEqualTo(String value) {
            addCriterion("node <=", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeLike(String value) {
            addCriterion("node like", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeNotLike(String value) {
            addCriterion("node not like", value, "node");
            return (Criteria) this;
        }

        public Criteria andNodeIn(List<String> values) {
            addCriterion("node in", values, "node");
            return (Criteria) this;
        }

        public Criteria andNodeNotIn(List<String> values) {
            addCriterion("node not in", values, "node");
            return (Criteria) this;
        }

        public Criteria andNodeBetween(String value1, String value2) {
            addCriterion("node between", value1, value2, "node");
            return (Criteria) this;
        }

        public Criteria andNodeNotBetween(String value1, String value2) {
            addCriterion("node not between", value1, value2, "node");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("Modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("Modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("Modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("Modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("Modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("Modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("Modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("Modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("Modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("Modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("Modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("Modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("Modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("Modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleIsNull() {
            addCriterion("project_schedule is null");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleIsNotNull() {
            addCriterion("project_schedule is not null");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleEqualTo(String value) {
            addCriterion("project_schedule =", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleNotEqualTo(String value) {
            addCriterion("project_schedule <>", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleGreaterThan(String value) {
            addCriterion("project_schedule >", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("project_schedule >=", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleLessThan(String value) {
            addCriterion("project_schedule <", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleLessThanOrEqualTo(String value) {
            addCriterion("project_schedule <=", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleLike(String value) {
            addCriterion("project_schedule like", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleNotLike(String value) {
            addCriterion("project_schedule not like", value, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleIn(List<String> values) {
            addCriterion("project_schedule in", values, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleNotIn(List<String> values) {
            addCriterion("project_schedule not in", values, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleBetween(String value1, String value2) {
            addCriterion("project_schedule between", value1, value2, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectScheduleNotBetween(String value1, String value2) {
            addCriterion("project_schedule not between", value1, value2, "projectSchedule");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNodeIsNull() {
            addCriterion("project_node is null");
            return (Criteria) this;
        }

        public Criteria andProjectNodeIsNotNull() {
            addCriterion("project_node is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNodeEqualTo(String value) {
            addCriterion("project_node =", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNotEqualTo(String value) {
            addCriterion("project_node <>", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeGreaterThan(String value) {
            addCriterion("project_node >", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_node >=", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeLessThan(String value) {
            addCriterion("project_node <", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeLessThanOrEqualTo(String value) {
            addCriterion("project_node <=", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeLike(String value) {
            addCriterion("project_node like", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNotLike(String value) {
            addCriterion("project_node not like", value, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeIn(List<String> values) {
            addCriterion("project_node in", values, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNotIn(List<String> values) {
            addCriterion("project_node not in", values, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeBetween(String value1, String value2) {
            addCriterion("project_node between", value1, value2, "projectNode");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNotBetween(String value1, String value2) {
            addCriterion("project_node not between", value1, value2, "projectNode");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeIsNull() {
            addCriterion("predict_startTime is null");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeIsNotNull() {
            addCriterion("predict_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeEqualTo(Date value) {
            addCriterion("predict_startTime =", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeNotEqualTo(Date value) {
            addCriterion("predict_startTime <>", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeGreaterThan(Date value) {
            addCriterion("predict_startTime >", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("predict_startTime >=", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeLessThan(Date value) {
            addCriterion("predict_startTime <", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("predict_startTime <=", value, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeIn(List<Date> values) {
            addCriterion("predict_startTime in", values, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeNotIn(List<Date> values) {
            addCriterion("predict_startTime not in", values, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeBetween(Date value1, Date value2) {
            addCriterion("predict_startTime between", value1, value2, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPredictStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("predict_startTime not between", value1, value2, "predictStarttime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeIsNull() {
            addCriterion("pridect_endTime is null");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeIsNotNull() {
            addCriterion("pridect_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeEqualTo(Date value) {
            addCriterion("pridect_endTime =", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeNotEqualTo(Date value) {
            addCriterion("pridect_endTime <>", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeGreaterThan(Date value) {
            addCriterion("pridect_endTime >", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pridect_endTime >=", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeLessThan(Date value) {
            addCriterion("pridect_endTime <", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("pridect_endTime <=", value, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeIn(List<Date> values) {
            addCriterion("pridect_endTime in", values, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeNotIn(List<Date> values) {
            addCriterion("pridect_endTime not in", values, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeBetween(Date value1, Date value2) {
            addCriterion("pridect_endTime between", value1, value2, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andPridectEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("pridect_endTime not between", value1, value2, "pridectEndtime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeIsNull() {
            addCriterion("actual_startTime is null");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeIsNotNull() {
            addCriterion("actual_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeEqualTo(Date value) {
            addCriterion("actual_startTime =", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeNotEqualTo(Date value) {
            addCriterion("actual_startTime <>", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeGreaterThan(Date value) {
            addCriterion("actual_startTime >", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_startTime >=", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeLessThan(Date value) {
            addCriterion("actual_startTime <", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_startTime <=", value, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeIn(List<Date> values) {
            addCriterion("actual_startTime in", values, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeNotIn(List<Date> values) {
            addCriterion("actual_startTime not in", values, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeBetween(Date value1, Date value2) {
            addCriterion("actual_startTime between", value1, value2, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_startTime not between", value1, value2, "actualStarttime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeIsNull() {
            addCriterion("actual_endTime is null");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeIsNotNull() {
            addCriterion("actual_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeEqualTo(Date value) {
            addCriterion("actual_endTime =", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeNotEqualTo(Date value) {
            addCriterion("actual_endTime <>", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeGreaterThan(Date value) {
            addCriterion("actual_endTime >", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_endTime >=", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeLessThan(Date value) {
            addCriterion("actual_endTime <", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_endTime <=", value, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeIn(List<Date> values) {
            addCriterion("actual_endTime in", values, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeNotIn(List<Date> values) {
            addCriterion("actual_endTime not in", values, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeBetween(Date value1, Date value2) {
            addCriterion("actual_endTime between", value1, value2, "actualEndtime");
            return (Criteria) this;
        }

        public Criteria andActualEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_endTime not between", value1, value2, "actualEndtime");
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