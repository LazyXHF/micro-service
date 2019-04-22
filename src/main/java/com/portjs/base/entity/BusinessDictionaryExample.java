package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.List;

public class BusinessDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessDictionaryExample() {
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

        public Criteria andProjectNodeNameIsNull() {
            addCriterion("project_node_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameIsNotNull() {
            addCriterion("project_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameEqualTo(String value) {
            addCriterion("project_node_name =", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameNotEqualTo(String value) {
            addCriterion("project_node_name <>", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameGreaterThan(String value) {
            addCriterion("project_node_name >", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_node_name >=", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameLessThan(String value) {
            addCriterion("project_node_name <", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameLessThanOrEqualTo(String value) {
            addCriterion("project_node_name <=", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameLike(String value) {
            addCriterion("project_node_name like", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameNotLike(String value) {
            addCriterion("project_node_name not like", value, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameIn(List<String> values) {
            addCriterion("project_node_name in", values, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameNotIn(List<String> values) {
            addCriterion("project_node_name not in", values, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameBetween(String value1, String value2) {
            addCriterion("project_node_name between", value1, value2, "projectNodeName");
            return (Criteria) this;
        }

        public Criteria andProjectNodeNameNotBetween(String value1, String value2) {
            addCriterion("project_node_name not between", value1, value2, "projectNodeName");
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

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andAlternate1IsNull() {
            addCriterion("alternate1 is null");
            return (Criteria) this;
        }

        public Criteria andAlternate1IsNotNull() {
            addCriterion("alternate1 is not null");
            return (Criteria) this;
        }

        public Criteria andAlternate1EqualTo(String value) {
            addCriterion("alternate1 =", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1NotEqualTo(String value) {
            addCriterion("alternate1 <>", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1GreaterThan(String value) {
            addCriterion("alternate1 >", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1GreaterThanOrEqualTo(String value) {
            addCriterion("alternate1 >=", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1LessThan(String value) {
            addCriterion("alternate1 <", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1LessThanOrEqualTo(String value) {
            addCriterion("alternate1 <=", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1Like(String value) {
            addCriterion("alternate1 like", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1NotLike(String value) {
            addCriterion("alternate1 not like", value, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1In(List<String> values) {
            addCriterion("alternate1 in", values, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1NotIn(List<String> values) {
            addCriterion("alternate1 not in", values, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1Between(String value1, String value2) {
            addCriterion("alternate1 between", value1, value2, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate1NotBetween(String value1, String value2) {
            addCriterion("alternate1 not between", value1, value2, "alternate1");
            return (Criteria) this;
        }

        public Criteria andAlternate2IsNull() {
            addCriterion("alternate2 is null");
            return (Criteria) this;
        }

        public Criteria andAlternate2IsNotNull() {
            addCriterion("alternate2 is not null");
            return (Criteria) this;
        }

        public Criteria andAlternate2EqualTo(String value) {
            addCriterion("alternate2 =", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2NotEqualTo(String value) {
            addCriterion("alternate2 <>", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2GreaterThan(String value) {
            addCriterion("alternate2 >", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2GreaterThanOrEqualTo(String value) {
            addCriterion("alternate2 >=", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2LessThan(String value) {
            addCriterion("alternate2 <", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2LessThanOrEqualTo(String value) {
            addCriterion("alternate2 <=", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2Like(String value) {
            addCriterion("alternate2 like", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2NotLike(String value) {
            addCriterion("alternate2 not like", value, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2In(List<String> values) {
            addCriterion("alternate2 in", values, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2NotIn(List<String> values) {
            addCriterion("alternate2 not in", values, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2Between(String value1, String value2) {
            addCriterion("alternate2 between", value1, value2, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate2NotBetween(String value1, String value2) {
            addCriterion("alternate2 not between", value1, value2, "alternate2");
            return (Criteria) this;
        }

        public Criteria andAlternate3IsNull() {
            addCriterion("alternate3 is null");
            return (Criteria) this;
        }

        public Criteria andAlternate3IsNotNull() {
            addCriterion("alternate3 is not null");
            return (Criteria) this;
        }

        public Criteria andAlternate3EqualTo(String value) {
            addCriterion("alternate3 =", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3NotEqualTo(String value) {
            addCriterion("alternate3 <>", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3GreaterThan(String value) {
            addCriterion("alternate3 >", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3GreaterThanOrEqualTo(String value) {
            addCriterion("alternate3 >=", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3LessThan(String value) {
            addCriterion("alternate3 <", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3LessThanOrEqualTo(String value) {
            addCriterion("alternate3 <=", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3Like(String value) {
            addCriterion("alternate3 like", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3NotLike(String value) {
            addCriterion("alternate3 not like", value, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3In(List<String> values) {
            addCriterion("alternate3 in", values, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3NotIn(List<String> values) {
            addCriterion("alternate3 not in", values, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3Between(String value1, String value2) {
            addCriterion("alternate3 between", value1, value2, "alternate3");
            return (Criteria) this;
        }

        public Criteria andAlternate3NotBetween(String value1, String value2) {
            addCriterion("alternate3 not between", value1, value2, "alternate3");
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