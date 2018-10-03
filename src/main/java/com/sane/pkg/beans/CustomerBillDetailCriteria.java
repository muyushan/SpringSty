package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.List;

public class CustomerBillDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CustomerBillDetailCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andBillDetailIdIsNull() {
            addCriterion("BillDetailId is null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIsNotNull() {
            addCriterion("BillDetailId is not null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdEqualTo(Integer value) {
            addCriterion("BillDetailId =", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotEqualTo(Integer value) {
            addCriterion("BillDetailId <>", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThan(Integer value) {
            addCriterion("BillDetailId >", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BillDetailId >=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThan(Integer value) {
            addCriterion("BillDetailId <", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("BillDetailId <=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIn(List<Integer> values) {
            addCriterion("BillDetailId in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotIn(List<Integer> values) {
            addCriterion("BillDetailId not in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("BillDetailId between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BillDetailId not between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIsNull() {
            addCriterion("StorageProductBillCode is null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIsNotNull() {
            addCriterion("StorageProductBillCode is not null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeEqualTo(String value) {
            addCriterion("StorageProductBillCode =", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotEqualTo(String value) {
            addCriterion("StorageProductBillCode <>", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeGreaterThan(String value) {
            addCriterion("StorageProductBillCode >", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("StorageProductBillCode >=", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLessThan(String value) {
            addCriterion("StorageProductBillCode <", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLessThanOrEqualTo(String value) {
            addCriterion("StorageProductBillCode <=", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLike(String value) {
            addCriterion("StorageProductBillCode like", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotLike(String value) {
            addCriterion("StorageProductBillCode not like", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIn(List<String> values) {
            addCriterion("StorageProductBillCode in", values, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotIn(List<String> values) {
            addCriterion("StorageProductBillCode not in", values, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeBetween(String value1, String value2) {
            addCriterion("StorageProductBillCode between", value1, value2, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotBetween(String value1, String value2) {
            addCriterion("StorageProductBillCode not between", value1, value2, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("ProductCode is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("ProductCode is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("ProductCode =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("ProductCode <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("ProductCode >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ProductCode >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("ProductCode <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("ProductCode <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("ProductCode like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("ProductCode not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("ProductCode in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("ProductCode not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("ProductCode between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("ProductCode not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("Quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("Quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Double value) {
            addCriterion("Quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Double value) {
            addCriterion("Quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Double value) {
            addCriterion("Quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("Quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Double value) {
            addCriterion("Quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Double value) {
            addCriterion("Quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Double> values) {
            addCriterion("Quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Double> values) {
            addCriterion("Quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Double value1, Double value2) {
            addCriterion("Quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Double value1, Double value2) {
            addCriterion("Quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNull() {
            addCriterion("OutQuantity is null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNotNull() {
            addCriterion("OutQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityEqualTo(Double value) {
            addCriterion("OutQuantity =", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotEqualTo(Double value) {
            addCriterion("OutQuantity <>", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThan(Double value) {
            addCriterion("OutQuantity >", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("OutQuantity >=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThan(Double value) {
            addCriterion("OutQuantity <", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThanOrEqualTo(Double value) {
            addCriterion("OutQuantity <=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIn(List<Double> values) {
            addCriterion("OutQuantity in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotIn(List<Double> values) {
            addCriterion("OutQuantity not in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityBetween(Double value1, Double value2) {
            addCriterion("OutQuantity between", value1, value2, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotBetween(Double value1, Double value2) {
            addCriterion("OutQuantity not between", value1, value2, "outQuantity");
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