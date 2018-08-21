package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ProductInfoCriteria() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("ProductId is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("ProductId is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("ProductId =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("ProductId <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("ProductId >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProductId >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("ProductId <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("ProductId <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("ProductId in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("ProductId not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("ProductId between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ProductId not between", value1, value2, "productId");
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

        public Criteria andProductNameIsNull() {
            addCriterion("ProductName is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("ProductName is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("ProductName =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("ProductName <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("ProductName >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("ProductName >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("ProductName <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("ProductName <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("ProductName like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("ProductName not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("ProductName in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("ProductName not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("ProductName between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("ProductName not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIsNull() {
            addCriterion("ProductCategory is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIsNotNull() {
            addCriterion("ProductCategory is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryEqualTo(Integer value) {
            addCriterion("ProductCategory =", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNotEqualTo(Integer value) {
            addCriterion("ProductCategory <>", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryGreaterThan(Integer value) {
            addCriterion("ProductCategory >", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProductCategory >=", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLessThan(Integer value) {
            addCriterion("ProductCategory <", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("ProductCategory <=", value, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIn(List<Integer> values) {
            addCriterion("ProductCategory in", values, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNotIn(List<Integer> values) {
            addCriterion("ProductCategory not in", values, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryBetween(Integer value1, Integer value2) {
            addCriterion("ProductCategory between", value1, value2, "productCategory");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("ProductCategory not between", value1, value2, "productCategory");
            return (Criteria) this;
        }

        public Criteria andFlavourIsNull() {
            addCriterion("Flavour is null");
            return (Criteria) this;
        }

        public Criteria andFlavourIsNotNull() {
            addCriterion("Flavour is not null");
            return (Criteria) this;
        }

        public Criteria andFlavourEqualTo(Integer value) {
            addCriterion("Flavour =", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourNotEqualTo(Integer value) {
            addCriterion("Flavour <>", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourGreaterThan(Integer value) {
            addCriterion("Flavour >", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourGreaterThanOrEqualTo(Integer value) {
            addCriterion("Flavour >=", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourLessThan(Integer value) {
            addCriterion("Flavour <", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourLessThanOrEqualTo(Integer value) {
            addCriterion("Flavour <=", value, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourIn(List<Integer> values) {
            addCriterion("Flavour in", values, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourNotIn(List<Integer> values) {
            addCriterion("Flavour not in", values, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourBetween(Integer value1, Integer value2) {
            addCriterion("Flavour between", value1, value2, "flavour");
            return (Criteria) this;
        }

        public Criteria andFlavourNotBetween(Integer value1, Integer value2) {
            addCriterion("Flavour not between", value1, value2, "flavour");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("Unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("Unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Integer value) {
            addCriterion("Unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Integer value) {
            addCriterion("Unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Integer value) {
            addCriterion("Unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("Unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Integer value) {
            addCriterion("Unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Integer value) {
            addCriterion("Unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Integer> values) {
            addCriterion("Unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Integer> values) {
            addCriterion("Unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Integer value1, Integer value2) {
            addCriterion("Unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("Unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitIsNull() {
            addCriterion("PackageUnit is null");
            return (Criteria) this;
        }

        public Criteria andPackageUnitIsNotNull() {
            addCriterion("PackageUnit is not null");
            return (Criteria) this;
        }

        public Criteria andPackageUnitEqualTo(Integer value) {
            addCriterion("PackageUnit =", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitNotEqualTo(Integer value) {
            addCriterion("PackageUnit <>", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitGreaterThan(Integer value) {
            addCriterion("PackageUnit >", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("PackageUnit >=", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitLessThan(Integer value) {
            addCriterion("PackageUnit <", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitLessThanOrEqualTo(Integer value) {
            addCriterion("PackageUnit <=", value, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitIn(List<Integer> values) {
            addCriterion("PackageUnit in", values, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitNotIn(List<Integer> values) {
            addCriterion("PackageUnit not in", values, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitBetween(Integer value1, Integer value2) {
            addCriterion("PackageUnit between", value1, value2, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andPackageUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("PackageUnit not between", value1, value2, "packageUnit");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("Weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("Weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Float value) {
            addCriterion("Weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Float value) {
            addCriterion("Weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Float value) {
            addCriterion("Weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Float value) {
            addCriterion("Weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Float value) {
            addCriterion("Weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Float value) {
            addCriterion("Weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Float> values) {
            addCriterion("Weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Float> values) {
            addCriterion("Weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Float value1, Float value2) {
            addCriterion("Weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Float value1, Float value2) {
            addCriterion("Weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("Volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("Volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Float value) {
            addCriterion("Volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Float value) {
            addCriterion("Volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Float value) {
            addCriterion("Volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Float value) {
            addCriterion("Volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Float value) {
            addCriterion("Volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Float value) {
            addCriterion("Volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Float> values) {
            addCriterion("Volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Float> values) {
            addCriterion("Volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Float value1, Float value2) {
            addCriterion("Volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Float value1, Float value2) {
            addCriterion("Volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeIsNull() {
            addCriterion("HasBarCode is null");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeIsNotNull() {
            addCriterion("HasBarCode is not null");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeEqualTo(Integer value) {
            addCriterion("HasBarCode =", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeNotEqualTo(Integer value) {
            addCriterion("HasBarCode <>", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeGreaterThan(Integer value) {
            addCriterion("HasBarCode >", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HasBarCode >=", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeLessThan(Integer value) {
            addCriterion("HasBarCode <", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeLessThanOrEqualTo(Integer value) {
            addCriterion("HasBarCode <=", value, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeIn(List<Integer> values) {
            addCriterion("HasBarCode in", values, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeNotIn(List<Integer> values) {
            addCriterion("HasBarCode not in", values, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeBetween(Integer value1, Integer value2) {
            addCriterion("HasBarCode between", value1, value2, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andHasBarCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("HasBarCode not between", value1, value2, "hasBarCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("BarCode is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("BarCode is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("BarCode =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("BarCode <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("BarCode >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BarCode >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("BarCode <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("BarCode <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("BarCode like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("BarCode not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("BarCode in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("BarCode not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("BarCode between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("BarCode not between", value1, value2, "barCode");
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