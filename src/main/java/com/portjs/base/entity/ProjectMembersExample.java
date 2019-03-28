package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectMembersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectMembersExample() {
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(String value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(String value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(String value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(String value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(String value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(String value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLike(String value) {
            addCriterion("application_id like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotLike(String value) {
            addCriterion("application_id not like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<String> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<String> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(String value1, String value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(String value1, String value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
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