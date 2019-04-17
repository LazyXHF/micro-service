package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectBudgetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectBudgetExample() {
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

        public Criteria andLaborCostIsNull() {
            addCriterion("labor_cost is null");
            return (Criteria) this;
        }

        public Criteria andLaborCostIsNotNull() {
            addCriterion("labor_cost is not null");
            return (Criteria) this;
        }

        public Criteria andLaborCostEqualTo(BigDecimal value) {
            addCriterion("labor_cost =", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotEqualTo(BigDecimal value) {
            addCriterion("labor_cost <>", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostGreaterThan(BigDecimal value) {
            addCriterion("labor_cost >", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_cost >=", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostLessThan(BigDecimal value) {
            addCriterion("labor_cost <", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_cost <=", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostIn(List<BigDecimal> values) {
            addCriterion("labor_cost in", values, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotIn(List<BigDecimal> values) {
            addCriterion("labor_cost not in", values, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_cost between", value1, value2, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_cost not between", value1, value2, "laborCost");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andDirectInputIsNull() {
            addCriterion("direct_input is null");
            return (Criteria) this;
        }

        public Criteria andDirectInputIsNotNull() {
            addCriterion("direct_input is not null");
            return (Criteria) this;
        }

        public Criteria andDirectInputEqualTo(BigDecimal value) {
            addCriterion("direct_input =", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputNotEqualTo(BigDecimal value) {
            addCriterion("direct_input <>", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputGreaterThan(BigDecimal value) {
            addCriterion("direct_input >", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("direct_input >=", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputLessThan(BigDecimal value) {
            addCriterion("direct_input <", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputLessThanOrEqualTo(BigDecimal value) {
            addCriterion("direct_input <=", value, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputIn(List<BigDecimal> values) {
            addCriterion("direct_input in", values, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputNotIn(List<BigDecimal> values) {
            addCriterion("direct_input not in", values, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("direct_input between", value1, value2, "directInput");
            return (Criteria) this;
        }

        public Criteria andDirectInputNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("direct_input not between", value1, value2, "directInput");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostIsNull() {
            addCriterion("depreciation_cost is null");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostIsNotNull() {
            addCriterion("depreciation_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostEqualTo(BigDecimal value) {
            addCriterion("depreciation_cost =", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostNotEqualTo(BigDecimal value) {
            addCriterion("depreciation_cost <>", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostGreaterThan(BigDecimal value) {
            addCriterion("depreciation_cost >", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("depreciation_cost >=", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostLessThan(BigDecimal value) {
            addCriterion("depreciation_cost <", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("depreciation_cost <=", value, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostIn(List<BigDecimal> values) {
            addCriterion("depreciation_cost in", values, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostNotIn(List<BigDecimal> values) {
            addCriterion("depreciation_cost not in", values, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("depreciation_cost between", value1, value2, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andDepreciationCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("depreciation_cost not between", value1, value2, "depreciationCost");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeIsNull() {
            addCriterion("amortization_charge is null");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeIsNotNull() {
            addCriterion("amortization_charge is not null");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeEqualTo(BigDecimal value) {
            addCriterion("amortization_charge =", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeNotEqualTo(BigDecimal value) {
            addCriterion("amortization_charge <>", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeGreaterThan(BigDecimal value) {
            addCriterion("amortization_charge >", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amortization_charge >=", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeLessThan(BigDecimal value) {
            addCriterion("amortization_charge <", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amortization_charge <=", value, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeIn(List<BigDecimal> values) {
            addCriterion("amortization_charge in", values, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeNotIn(List<BigDecimal> values) {
            addCriterion("amortization_charge not in", values, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amortization_charge between", value1, value2, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andAmortizationChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amortization_charge not between", value1, value2, "amortizationCharge");
            return (Criteria) this;
        }

        public Criteria andRemark4IsNull() {
            addCriterion("remark4 is null");
            return (Criteria) this;
        }

        public Criteria andRemark4IsNotNull() {
            addCriterion("remark4 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark4EqualTo(String value) {
            addCriterion("remark4 =", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            addCriterion("remark4 <>", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            addCriterion("remark4 >", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            addCriterion("remark4 >=", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4LessThan(String value) {
            addCriterion("remark4 <", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            addCriterion("remark4 <=", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4Like(String value) {
            addCriterion("remark4 like", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotLike(String value) {
            addCriterion("remark4 not like", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4In(List<String> values) {
            addCriterion("remark4 in", values, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            addCriterion("remark4 not in", values, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria) this;
        }

        public Criteria andDesignFeeIsNull() {
            addCriterion("design_fee is null");
            return (Criteria) this;
        }

        public Criteria andDesignFeeIsNotNull() {
            addCriterion("design_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDesignFeeEqualTo(BigDecimal value) {
            addCriterion("design_fee =", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeNotEqualTo(BigDecimal value) {
            addCriterion("design_fee <>", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeGreaterThan(BigDecimal value) {
            addCriterion("design_fee >", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("design_fee >=", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeLessThan(BigDecimal value) {
            addCriterion("design_fee <", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("design_fee <=", value, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeIn(List<BigDecimal> values) {
            addCriterion("design_fee in", values, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeNotIn(List<BigDecimal> values) {
            addCriterion("design_fee not in", values, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("design_fee between", value1, value2, "designFee");
            return (Criteria) this;
        }

        public Criteria andDesignFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("design_fee not between", value1, value2, "designFee");
            return (Criteria) this;
        }

        public Criteria andRemark5IsNull() {
            addCriterion("remark5 is null");
            return (Criteria) this;
        }

        public Criteria andRemark5IsNotNull() {
            addCriterion("remark5 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark5EqualTo(String value) {
            addCriterion("remark5 =", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5NotEqualTo(String value) {
            addCriterion("remark5 <>", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5GreaterThan(String value) {
            addCriterion("remark5 >", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            addCriterion("remark5 >=", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5LessThan(String value) {
            addCriterion("remark5 <", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            addCriterion("remark5 <=", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5Like(String value) {
            addCriterion("remark5 like", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5NotLike(String value) {
            addCriterion("remark5 not like", value, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5In(List<String> values) {
            addCriterion("remark5 in", values, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5NotIn(List<String> values) {
            addCriterion("remark5 not in", values, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5Between(String value1, String value2) {
            addCriterion("remark5 between", value1, value2, "remark5");
            return (Criteria) this;
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            addCriterion("remark5 not between", value1, value2, "remark5");
            return (Criteria) this;
        }

        public Criteria andDebugFeeIsNull() {
            addCriterion("debug_fee is null");
            return (Criteria) this;
        }

        public Criteria andDebugFeeIsNotNull() {
            addCriterion("debug_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDebugFeeEqualTo(BigDecimal value) {
            addCriterion("debug_fee =", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeNotEqualTo(BigDecimal value) {
            addCriterion("debug_fee <>", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeGreaterThan(BigDecimal value) {
            addCriterion("debug_fee >", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("debug_fee >=", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeLessThan(BigDecimal value) {
            addCriterion("debug_fee <", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("debug_fee <=", value, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeIn(List<BigDecimal> values) {
            addCriterion("debug_fee in", values, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeNotIn(List<BigDecimal> values) {
            addCriterion("debug_fee not in", values, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("debug_fee between", value1, value2, "debugFee");
            return (Criteria) this;
        }

        public Criteria andDebugFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("debug_fee not between", value1, value2, "debugFee");
            return (Criteria) this;
        }

        public Criteria andRemark6IsNull() {
            addCriterion("remark6 is null");
            return (Criteria) this;
        }

        public Criteria andRemark6IsNotNull() {
            addCriterion("remark6 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark6EqualTo(String value) {
            addCriterion("remark6 =", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6NotEqualTo(String value) {
            addCriterion("remark6 <>", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6GreaterThan(String value) {
            addCriterion("remark6 >", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            addCriterion("remark6 >=", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6LessThan(String value) {
            addCriterion("remark6 <", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            addCriterion("remark6 <=", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6Like(String value) {
            addCriterion("remark6 like", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6NotLike(String value) {
            addCriterion("remark6 not like", value, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6In(List<String> values) {
            addCriterion("remark6 in", values, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6NotIn(List<String> values) {
            addCriterion("remark6 not in", values, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6Between(String value1, String value2) {
            addCriterion("remark6 between", value1, value2, "remark6");
            return (Criteria) this;
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            addCriterion("remark6 not between", value1, value2, "remark6");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostIsNull() {
            addCriterion("outsourcing_cost is null");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostIsNotNull() {
            addCriterion("outsourcing_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostEqualTo(BigDecimal value) {
            addCriterion("outsourcing_cost =", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostNotEqualTo(BigDecimal value) {
            addCriterion("outsourcing_cost <>", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostGreaterThan(BigDecimal value) {
            addCriterion("outsourcing_cost >", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("outsourcing_cost >=", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostLessThan(BigDecimal value) {
            addCriterion("outsourcing_cost <", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("outsourcing_cost <=", value, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostIn(List<BigDecimal> values) {
            addCriterion("outsourcing_cost in", values, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostNotIn(List<BigDecimal> values) {
            addCriterion("outsourcing_cost not in", values, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("outsourcing_cost between", value1, value2, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andOutsourcingCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("outsourcing_cost not between", value1, value2, "outsourcingCost");
            return (Criteria) this;
        }

        public Criteria andRemark7IsNull() {
            addCriterion("remark7 is null");
            return (Criteria) this;
        }

        public Criteria andRemark7IsNotNull() {
            addCriterion("remark7 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark7EqualTo(String value) {
            addCriterion("remark7 =", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7NotEqualTo(String value) {
            addCriterion("remark7 <>", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7GreaterThan(String value) {
            addCriterion("remark7 >", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            addCriterion("remark7 >=", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7LessThan(String value) {
            addCriterion("remark7 <", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            addCriterion("remark7 <=", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7Like(String value) {
            addCriterion("remark7 like", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7NotLike(String value) {
            addCriterion("remark7 not like", value, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7In(List<String> values) {
            addCriterion("remark7 in", values, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7NotIn(List<String> values) {
            addCriterion("remark7 not in", values, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7Between(String value1, String value2) {
            addCriterion("remark7 between", value1, value2, "remark7");
            return (Criteria) this;
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            addCriterion("remark7 not between", value1, value2, "remark7");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIsNull() {
            addCriterion("other_fee is null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIsNotNull() {
            addCriterion("other_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeEqualTo(BigDecimal value) {
            addCriterion("other_fee =", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotEqualTo(BigDecimal value) {
            addCriterion("other_fee <>", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThan(BigDecimal value) {
            addCriterion("other_fee >", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_fee >=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThan(BigDecimal value) {
            addCriterion("other_fee <", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_fee <=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIn(List<BigDecimal> values) {
            addCriterion("other_fee in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotIn(List<BigDecimal> values) {
            addCriterion("other_fee not in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_fee between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_fee not between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andRemark8IsNull() {
            addCriterion("remark8 is null");
            return (Criteria) this;
        }

        public Criteria andRemark8IsNotNull() {
            addCriterion("remark8 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark8EqualTo(String value) {
            addCriterion("remark8 =", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8NotEqualTo(String value) {
            addCriterion("remark8 <>", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8GreaterThan(String value) {
            addCriterion("remark8 >", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            addCriterion("remark8 >=", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8LessThan(String value) {
            addCriterion("remark8 <", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            addCriterion("remark8 <=", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8Like(String value) {
            addCriterion("remark8 like", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8NotLike(String value) {
            addCriterion("remark8 not like", value, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8In(List<String> values) {
            addCriterion("remark8 in", values, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8NotIn(List<String> values) {
            addCriterion("remark8 not in", values, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8Between(String value1, String value2) {
            addCriterion("remark8 between", value1, value2, "remark8");
            return (Criteria) this;
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            addCriterion("remark8 not between", value1, value2, "remark8");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total not between", value1, value2, "total");
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