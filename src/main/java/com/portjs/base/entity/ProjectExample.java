package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andBackUp1IsNull() {
            addCriterion("back_up1 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp1IsNotNull() {
            addCriterion("back_up1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp1EqualTo(String value) {
            addCriterion("back_up1 =", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotEqualTo(String value) {
            addCriterion("back_up1 <>", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThan(String value) {
            addCriterion("back_up1 >", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThanOrEqualTo(String value) {
            addCriterion("back_up1 >=", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThan(String value) {
            addCriterion("back_up1 <", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThanOrEqualTo(String value) {
            addCriterion("back_up1 <=", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1Like(String value) {
            addCriterion("back_up1 like", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotLike(String value) {
            addCriterion("back_up1 not like", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1In(List<String> values) {
            addCriterion("back_up1 in", values, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotIn(List<String> values) {
            addCriterion("back_up1 not in", values, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1Between(String value1, String value2) {
            addCriterion("back_up1 between", value1, value2, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotBetween(String value1, String value2) {
            addCriterion("back_up1 not between", value1, value2, "backUp1");
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