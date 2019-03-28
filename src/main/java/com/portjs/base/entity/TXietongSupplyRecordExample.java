package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXietongSupplyRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXietongSupplyRecordExample() {
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

        public Criteria andSupplyIdIsNull() {
            addCriterion("supply_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplyIdIsNotNull() {
            addCriterion("supply_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyIdEqualTo(String value) {
            addCriterion("supply_id =", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdNotEqualTo(String value) {
            addCriterion("supply_id <>", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdGreaterThan(String value) {
            addCriterion("supply_id >", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("supply_id >=", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdLessThan(String value) {
            addCriterion("supply_id <", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdLessThanOrEqualTo(String value) {
            addCriterion("supply_id <=", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdLike(String value) {
            addCriterion("supply_id like", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdNotLike(String value) {
            addCriterion("supply_id not like", value, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdIn(List<String> values) {
            addCriterion("supply_id in", values, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdNotIn(List<String> values) {
            addCriterion("supply_id not in", values, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdBetween(String value1, String value2) {
            addCriterion("supply_id between", value1, value2, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyIdNotBetween(String value1, String value2) {
            addCriterion("supply_id not between", value1, value2, "supplyId");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIsNull() {
            addCriterion("supply_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIsNotNull() {
            addCriterion("supply_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyNameEqualTo(String value) {
            addCriterion("supply_name =", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotEqualTo(String value) {
            addCriterion("supply_name <>", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameGreaterThan(String value) {
            addCriterion("supply_name >", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("supply_name >=", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLessThan(String value) {
            addCriterion("supply_name <", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLessThanOrEqualTo(String value) {
            addCriterion("supply_name <=", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameLike(String value) {
            addCriterion("supply_name like", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotLike(String value) {
            addCriterion("supply_name not like", value, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameIn(List<String> values) {
            addCriterion("supply_name in", values, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotIn(List<String> values) {
            addCriterion("supply_name not in", values, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameBetween(String value1, String value2) {
            addCriterion("supply_name between", value1, value2, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyNameNotBetween(String value1, String value2) {
            addCriterion("supply_name not between", value1, value2, "supplyName");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeIsNull() {
            addCriterion("supply_type is null");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeIsNotNull() {
            addCriterion("supply_type is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeEqualTo(String value) {
            addCriterion("supply_type =", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeNotEqualTo(String value) {
            addCriterion("supply_type <>", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeGreaterThan(String value) {
            addCriterion("supply_type >", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("supply_type >=", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeLessThan(String value) {
            addCriterion("supply_type <", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeLessThanOrEqualTo(String value) {
            addCriterion("supply_type <=", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeLike(String value) {
            addCriterion("supply_type like", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeNotLike(String value) {
            addCriterion("supply_type not like", value, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeIn(List<String> values) {
            addCriterion("supply_type in", values, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeNotIn(List<String> values) {
            addCriterion("supply_type not in", values, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeBetween(String value1, String value2) {
            addCriterion("supply_type between", value1, value2, "supplyType");
            return (Criteria) this;
        }

        public Criteria andSupplyTypeNotBetween(String value1, String value2) {
            addCriterion("supply_type not between", value1, value2, "supplyType");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdIsNull() {
            addCriterion("receiptor_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdIsNotNull() {
            addCriterion("receiptor_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdEqualTo(String value) {
            addCriterion("receiptor_id =", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdNotEqualTo(String value) {
            addCriterion("receiptor_id <>", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdGreaterThan(String value) {
            addCriterion("receiptor_id >", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdGreaterThanOrEqualTo(String value) {
            addCriterion("receiptor_id >=", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdLessThan(String value) {
            addCriterion("receiptor_id <", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdLessThanOrEqualTo(String value) {
            addCriterion("receiptor_id <=", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdLike(String value) {
            addCriterion("receiptor_id like", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdNotLike(String value) {
            addCriterion("receiptor_id not like", value, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdIn(List<String> values) {
            addCriterion("receiptor_id in", values, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdNotIn(List<String> values) {
            addCriterion("receiptor_id not in", values, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdBetween(String value1, String value2) {
            addCriterion("receiptor_id between", value1, value2, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorIdNotBetween(String value1, String value2) {
            addCriterion("receiptor_id not between", value1, value2, "receiptorId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdIsNull() {
            addCriterion("receiptor_depart_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdIsNotNull() {
            addCriterion("receiptor_depart_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdEqualTo(String value) {
            addCriterion("receiptor_depart_id =", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdNotEqualTo(String value) {
            addCriterion("receiptor_depart_id <>", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdGreaterThan(String value) {
            addCriterion("receiptor_depart_id >", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdGreaterThanOrEqualTo(String value) {
            addCriterion("receiptor_depart_id >=", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdLessThan(String value) {
            addCriterion("receiptor_depart_id <", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdLessThanOrEqualTo(String value) {
            addCriterion("receiptor_depart_id <=", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdLike(String value) {
            addCriterion("receiptor_depart_id like", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdNotLike(String value) {
            addCriterion("receiptor_depart_id not like", value, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdIn(List<String> values) {
            addCriterion("receiptor_depart_id in", values, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdNotIn(List<String> values) {
            addCriterion("receiptor_depart_id not in", values, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdBetween(String value1, String value2) {
            addCriterion("receiptor_depart_id between", value1, value2, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartIdNotBetween(String value1, String value2) {
            addCriterion("receiptor_depart_id not between", value1, value2, "receiptorDepartId");
            return (Criteria) this;
        }

        public Criteria andReamarkIsNull() {
            addCriterion("reamark is null");
            return (Criteria) this;
        }

        public Criteria andReamarkIsNotNull() {
            addCriterion("reamark is not null");
            return (Criteria) this;
        }

        public Criteria andReamarkEqualTo(String value) {
            addCriterion("reamark =", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkNotEqualTo(String value) {
            addCriterion("reamark <>", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkGreaterThan(String value) {
            addCriterion("reamark >", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkGreaterThanOrEqualTo(String value) {
            addCriterion("reamark >=", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkLessThan(String value) {
            addCriterion("reamark <", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkLessThanOrEqualTo(String value) {
            addCriterion("reamark <=", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkLike(String value) {
            addCriterion("reamark like", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkNotLike(String value) {
            addCriterion("reamark not like", value, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkIn(List<String> values) {
            addCriterion("reamark in", values, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkNotIn(List<String> values) {
            addCriterion("reamark not in", values, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkBetween(String value1, String value2) {
            addCriterion("reamark between", value1, value2, "reamark");
            return (Criteria) this;
        }

        public Criteria andReamarkNotBetween(String value1, String value2) {
            addCriterion("reamark not between", value1, value2, "reamark");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameIsNull() {
            addCriterion("receiptor_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameIsNotNull() {
            addCriterion("receiptor_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameEqualTo(String value) {
            addCriterion("receiptor_name =", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameNotEqualTo(String value) {
            addCriterion("receiptor_name <>", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameGreaterThan(String value) {
            addCriterion("receiptor_name >", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiptor_name >=", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameLessThan(String value) {
            addCriterion("receiptor_name <", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameLessThanOrEqualTo(String value) {
            addCriterion("receiptor_name <=", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameLike(String value) {
            addCriterion("receiptor_name like", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameNotLike(String value) {
            addCriterion("receiptor_name not like", value, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameIn(List<String> values) {
            addCriterion("receiptor_name in", values, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameNotIn(List<String> values) {
            addCriterion("receiptor_name not in", values, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameBetween(String value1, String value2) {
            addCriterion("receiptor_name between", value1, value2, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorNameNotBetween(String value1, String value2) {
            addCriterion("receiptor_name not between", value1, value2, "receiptorName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameIsNull() {
            addCriterion("receiptor_depart_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameIsNotNull() {
            addCriterion("receiptor_depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameEqualTo(String value) {
            addCriterion("receiptor_depart_name =", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameNotEqualTo(String value) {
            addCriterion("receiptor_depart_name <>", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameGreaterThan(String value) {
            addCriterion("receiptor_depart_name >", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiptor_depart_name >=", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameLessThan(String value) {
            addCriterion("receiptor_depart_name <", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameLessThanOrEqualTo(String value) {
            addCriterion("receiptor_depart_name <=", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameLike(String value) {
            addCriterion("receiptor_depart_name like", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameNotLike(String value) {
            addCriterion("receiptor_depart_name not like", value, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameIn(List<String> values) {
            addCriterion("receiptor_depart_name in", values, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameNotIn(List<String> values) {
            addCriterion("receiptor_depart_name not in", values, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameBetween(String value1, String value2) {
            addCriterion("receiptor_depart_name between", value1, value2, "receiptorDepartName");
            return (Criteria) this;
        }

        public Criteria andReceiptorDepartNameNotBetween(String value1, String value2) {
            addCriterion("receiptor_depart_name not between", value1, value2, "receiptorDepartName");
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