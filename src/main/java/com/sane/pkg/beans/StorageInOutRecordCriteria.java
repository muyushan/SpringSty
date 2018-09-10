package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageInOutRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StorageInOutRecordCriteria() {
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

        public Criteria andInOutIDIsNull() {
            addCriterion("InOutID is null");
            return (Criteria) this;
        }

        public Criteria andInOutIDIsNotNull() {
            addCriterion("InOutID is not null");
            return (Criteria) this;
        }

        public Criteria andInOutIDEqualTo(Integer value) {
            addCriterion("InOutID =", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDNotEqualTo(Integer value) {
            addCriterion("InOutID <>", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDGreaterThan(Integer value) {
            addCriterion("InOutID >", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("InOutID >=", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDLessThan(Integer value) {
            addCriterion("InOutID <", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDLessThanOrEqualTo(Integer value) {
            addCriterion("InOutID <=", value, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDIn(List<Integer> values) {
            addCriterion("InOutID in", values, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDNotIn(List<Integer> values) {
            addCriterion("InOutID not in", values, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDBetween(Integer value1, Integer value2) {
            addCriterion("InOutID between", value1, value2, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutIDNotBetween(Integer value1, Integer value2) {
            addCriterion("InOutID not between", value1, value2, "inOutID");
            return (Criteria) this;
        }

        public Criteria andInOutCodeIsNull() {
            addCriterion("InOutCode is null");
            return (Criteria) this;
        }

        public Criteria andInOutCodeIsNotNull() {
            addCriterion("InOutCode is not null");
            return (Criteria) this;
        }

        public Criteria andInOutCodeEqualTo(String value) {
            addCriterion("InOutCode =", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeNotEqualTo(String value) {
            addCriterion("InOutCode <>", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeGreaterThan(String value) {
            addCriterion("InOutCode >", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeGreaterThanOrEqualTo(String value) {
            addCriterion("InOutCode >=", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeLessThan(String value) {
            addCriterion("InOutCode <", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeLessThanOrEqualTo(String value) {
            addCriterion("InOutCode <=", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeLike(String value) {
            addCriterion("InOutCode like", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeNotLike(String value) {
            addCriterion("InOutCode not like", value, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeIn(List<String> values) {
            addCriterion("InOutCode in", values, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeNotIn(List<String> values) {
            addCriterion("InOutCode not in", values, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeBetween(String value1, String value2) {
            addCriterion("InOutCode between", value1, value2, "inOutCode");
            return (Criteria) this;
        }

        public Criteria andInOutCodeNotBetween(String value1, String value2) {
            addCriterion("InOutCode not between", value1, value2, "inOutCode");
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

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("Quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("Quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("Quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("Quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("Quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("Quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("Quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("Quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("Quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("Quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityIsNull() {
            addCriterion("FormerQuantity is null");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityIsNotNull() {
            addCriterion("FormerQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityEqualTo(Integer value) {
            addCriterion("FormerQuantity =", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityNotEqualTo(Integer value) {
            addCriterion("FormerQuantity <>", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityGreaterThan(Integer value) {
            addCriterion("FormerQuantity >", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("FormerQuantity >=", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityLessThan(Integer value) {
            addCriterion("FormerQuantity <", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("FormerQuantity <=", value, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityIn(List<Integer> values) {
            addCriterion("FormerQuantity in", values, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityNotIn(List<Integer> values) {
            addCriterion("FormerQuantity not in", values, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityBetween(Integer value1, Integer value2) {
            addCriterion("FormerQuantity between", value1, value2, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andFormerQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("FormerQuantity not between", value1, value2, "formerQuantity");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNull() {
            addCriterion("StorageType is null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNotNull() {
            addCriterion("StorageType is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeEqualTo(String value) {
            addCriterion("StorageType =", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotEqualTo(String value) {
            addCriterion("StorageType <>", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThan(String value) {
            addCriterion("StorageType >", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("StorageType >=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThan(String value) {
            addCriterion("StorageType <", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThanOrEqualTo(String value) {
            addCriterion("StorageType <=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLike(String value) {
            addCriterion("StorageType like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotLike(String value) {
            addCriterion("StorageType not like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIn(List<String> values) {
            addCriterion("StorageType in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotIn(List<String> values) {
            addCriterion("StorageType not in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeBetween(String value1, String value2) {
            addCriterion("StorageType between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotBetween(String value1, String value2) {
            addCriterion("StorageType not between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIsNull() {
            addCriterion("InOutType is null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIsNotNull() {
            addCriterion("InOutType is not null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeEqualTo(String value) {
            addCriterion("InOutType =", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotEqualTo(String value) {
            addCriterion("InOutType <>", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeGreaterThan(String value) {
            addCriterion("InOutType >", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeGreaterThanOrEqualTo(String value) {
            addCriterion("InOutType >=", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeLessThan(String value) {
            addCriterion("InOutType <", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeLessThanOrEqualTo(String value) {
            addCriterion("InOutType <=", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeLike(String value) {
            addCriterion("InOutType like", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotLike(String value) {
            addCriterion("InOutType not like", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIn(List<String> values) {
            addCriterion("InOutType in", values, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotIn(List<String> values) {
            addCriterion("InOutType not in", values, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeBetween(String value1, String value2) {
            addCriterion("InOutType between", value1, value2, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotBetween(String value1, String value2) {
            addCriterion("InOutType not between", value1, value2, "inOutType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CreateDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
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