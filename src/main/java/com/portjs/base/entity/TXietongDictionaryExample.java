package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.List;

public class TXietongDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXietongDictionaryExample() {
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

        public Criteria andTypeCodeIsNull() {
            addCriterion("TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("TYPE_CODE =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("TYPE_CODE <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("TYPE_CODE >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("TYPE_CODE <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("TYPE_CODE like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("TYPE_CODE not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("TYPE_CODE in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("TYPE_CODE not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("TYPE_CODE between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("TYPE_CODE not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNull() {
            addCriterion("TYPE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNotNull() {
            addCriterion("TYPE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescEqualTo(String value) {
            addCriterion("TYPE_DESC =", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotEqualTo(String value) {
            addCriterion("TYPE_DESC <>", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThan(String value) {
            addCriterion("TYPE_DESC >", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC >=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThan(String value) {
            addCriterion("TYPE_DESC <", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC <=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLike(String value) {
            addCriterion("TYPE_DESC like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotLike(String value) {
            addCriterion("TYPE_DESC not like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescIn(List<String> values) {
            addCriterion("TYPE_DESC in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotIn(List<String> values) {
            addCriterion("TYPE_DESC not in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescBetween(String value1, String value2) {
            addCriterion("TYPE_DESC between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotBetween(String value1, String value2) {
            addCriterion("TYPE_DESC not between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andMainValueIsNull() {
            addCriterion("MAIN_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMainValueIsNotNull() {
            addCriterion("MAIN_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMainValueEqualTo(String value) {
            addCriterion("MAIN_VALUE =", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueNotEqualTo(String value) {
            addCriterion("MAIN_VALUE <>", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueGreaterThan(String value) {
            addCriterion("MAIN_VALUE >", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_VALUE >=", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueLessThan(String value) {
            addCriterion("MAIN_VALUE <", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueLessThanOrEqualTo(String value) {
            addCriterion("MAIN_VALUE <=", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueLike(String value) {
            addCriterion("MAIN_VALUE like", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueNotLike(String value) {
            addCriterion("MAIN_VALUE not like", value, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueIn(List<String> values) {
            addCriterion("MAIN_VALUE in", values, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueNotIn(List<String> values) {
            addCriterion("MAIN_VALUE not in", values, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueBetween(String value1, String value2) {
            addCriterion("MAIN_VALUE between", value1, value2, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMainValueNotBetween(String value1, String value2) {
            addCriterion("MAIN_VALUE not between", value1, value2, "mainValue");
            return (Criteria) this;
        }

        public Criteria andMidValueIsNull() {
            addCriterion("MID_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMidValueIsNotNull() {
            addCriterion("MID_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMidValueEqualTo(String value) {
            addCriterion("MID_VALUE =", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueNotEqualTo(String value) {
            addCriterion("MID_VALUE <>", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueGreaterThan(String value) {
            addCriterion("MID_VALUE >", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueGreaterThanOrEqualTo(String value) {
            addCriterion("MID_VALUE >=", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueLessThan(String value) {
            addCriterion("MID_VALUE <", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueLessThanOrEqualTo(String value) {
            addCriterion("MID_VALUE <=", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueLike(String value) {
            addCriterion("MID_VALUE like", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueNotLike(String value) {
            addCriterion("MID_VALUE not like", value, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueIn(List<String> values) {
            addCriterion("MID_VALUE in", values, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueNotIn(List<String> values) {
            addCriterion("MID_VALUE not in", values, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueBetween(String value1, String value2) {
            addCriterion("MID_VALUE between", value1, value2, "midValue");
            return (Criteria) this;
        }

        public Criteria andMidValueNotBetween(String value1, String value2) {
            addCriterion("MID_VALUE not between", value1, value2, "midValue");
            return (Criteria) this;
        }

        public Criteria andSubValueIsNull() {
            addCriterion("SUB_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSubValueIsNotNull() {
            addCriterion("SUB_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSubValueEqualTo(String value) {
            addCriterion("SUB_VALUE =", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueNotEqualTo(String value) {
            addCriterion("SUB_VALUE <>", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueGreaterThan(String value) {
            addCriterion("SUB_VALUE >", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_VALUE >=", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueLessThan(String value) {
            addCriterion("SUB_VALUE <", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueLessThanOrEqualTo(String value) {
            addCriterion("SUB_VALUE <=", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueLike(String value) {
            addCriterion("SUB_VALUE like", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueNotLike(String value) {
            addCriterion("SUB_VALUE not like", value, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueIn(List<String> values) {
            addCriterion("SUB_VALUE in", values, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueNotIn(List<String> values) {
            addCriterion("SUB_VALUE not in", values, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueBetween(String value1, String value2) {
            addCriterion("SUB_VALUE between", value1, value2, "subValue");
            return (Criteria) this;
        }

        public Criteria andSubValueNotBetween(String value1, String value2) {
            addCriterion("SUB_VALUE not between", value1, value2, "subValue");
            return (Criteria) this;
        }

        public Criteria andValueSortIsNull() {
            addCriterion("VALUE_SORT is null");
            return (Criteria) this;
        }

        public Criteria andValueSortIsNotNull() {
            addCriterion("VALUE_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andValueSortEqualTo(String value) {
            addCriterion("VALUE_SORT =", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortNotEqualTo(String value) {
            addCriterion("VALUE_SORT <>", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortGreaterThan(String value) {
            addCriterion("VALUE_SORT >", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE_SORT >=", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortLessThan(String value) {
            addCriterion("VALUE_SORT <", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortLessThanOrEqualTo(String value) {
            addCriterion("VALUE_SORT <=", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortLike(String value) {
            addCriterion("VALUE_SORT like", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortNotLike(String value) {
            addCriterion("VALUE_SORT not like", value, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortIn(List<String> values) {
            addCriterion("VALUE_SORT in", values, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortNotIn(List<String> values) {
            addCriterion("VALUE_SORT not in", values, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortBetween(String value1, String value2) {
            addCriterion("VALUE_SORT between", value1, value2, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueSortNotBetween(String value1, String value2) {
            addCriterion("VALUE_SORT not between", value1, value2, "valueSort");
            return (Criteria) this;
        }

        public Criteria andValueDescIsNull() {
            addCriterion("VALUE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andValueDescIsNotNull() {
            addCriterion("VALUE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andValueDescEqualTo(String value) {
            addCriterion("VALUE_DESC =", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescNotEqualTo(String value) {
            addCriterion("VALUE_DESC <>", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescGreaterThan(String value) {
            addCriterion("VALUE_DESC >", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE_DESC >=", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescLessThan(String value) {
            addCriterion("VALUE_DESC <", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescLessThanOrEqualTo(String value) {
            addCriterion("VALUE_DESC <=", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescLike(String value) {
            addCriterion("VALUE_DESC like", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescNotLike(String value) {
            addCriterion("VALUE_DESC not like", value, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescIn(List<String> values) {
            addCriterion("VALUE_DESC in", values, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescNotIn(List<String> values) {
            addCriterion("VALUE_DESC not in", values, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescBetween(String value1, String value2) {
            addCriterion("VALUE_DESC between", value1, value2, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andValueDescNotBetween(String value1, String value2) {
            addCriterion("VALUE_DESC not between", value1, value2, "valueDesc");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("TYPE_ID =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("TYPE_ID <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("TYPE_ID >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_ID >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("TYPE_ID <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("TYPE_ID <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("TYPE_ID like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("TYPE_ID not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("TYPE_ID in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("TYPE_ID not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("TYPE_ID between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("TYPE_ID not between", value1, value2, "typeId");
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