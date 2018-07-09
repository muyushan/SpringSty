package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseListItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BaseListItemCriteria() {
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

        public Criteria andListidIsNull() {
            addCriterion("ListID is null");
            return (Criteria) this;
        }

        public Criteria andListidIsNotNull() {
            addCriterion("ListID is not null");
            return (Criteria) this;
        }

        public Criteria andListidEqualTo(Integer value) {
            addCriterion("ListID =", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotEqualTo(Integer value) {
            addCriterion("ListID <>", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidGreaterThan(Integer value) {
            addCriterion("ListID >", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ListID >=", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidLessThan(Integer value) {
            addCriterion("ListID <", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidLessThanOrEqualTo(Integer value) {
            addCriterion("ListID <=", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidIn(List<Integer> values) {
            addCriterion("ListID in", values, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotIn(List<Integer> values) {
            addCriterion("ListID not in", values, "listid");
            return (Criteria) this;
        }

        public Criteria andListidBetween(Integer value1, Integer value2) {
            addCriterion("ListID between", value1, value2, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotBetween(Integer value1, Integer value2) {
            addCriterion("ListID not between", value1, value2, "listid");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("TypeID is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("TypeID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Short value) {
            addCriterion("TypeID =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Short value) {
            addCriterion("TypeID <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Short value) {
            addCriterion("TypeID >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("TypeID >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Short value) {
            addCriterion("TypeID <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Short value) {
            addCriterion("TypeID <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Short> values) {
            addCriterion("TypeID in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Short> values) {
            addCriterion("TypeID not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Short value1, Short value2) {
            addCriterion("TypeID between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Short value1, Short value2) {
            addCriterion("TypeID not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andListvalueIsNull() {
            addCriterion("ListValue is null");
            return (Criteria) this;
        }

        public Criteria andListvalueIsNotNull() {
            addCriterion("ListValue is not null");
            return (Criteria) this;
        }

        public Criteria andListvalueEqualTo(Short value) {
            addCriterion("ListValue =", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueNotEqualTo(Short value) {
            addCriterion("ListValue <>", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueGreaterThan(Short value) {
            addCriterion("ListValue >", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueGreaterThanOrEqualTo(Short value) {
            addCriterion("ListValue >=", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueLessThan(Short value) {
            addCriterion("ListValue <", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueLessThanOrEqualTo(Short value) {
            addCriterion("ListValue <=", value, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueIn(List<Short> values) {
            addCriterion("ListValue in", values, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueNotIn(List<Short> values) {
            addCriterion("ListValue not in", values, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueBetween(Short value1, Short value2) {
            addCriterion("ListValue between", value1, value2, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListvalueNotBetween(Short value1, Short value2) {
            addCriterion("ListValue not between", value1, value2, "listvalue");
            return (Criteria) this;
        }

        public Criteria andListnameIsNull() {
            addCriterion("ListName is null");
            return (Criteria) this;
        }

        public Criteria andListnameIsNotNull() {
            addCriterion("ListName is not null");
            return (Criteria) this;
        }

        public Criteria andListnameEqualTo(String value) {
            addCriterion("ListName =", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameNotEqualTo(String value) {
            addCriterion("ListName <>", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameGreaterThan(String value) {
            addCriterion("ListName >", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameGreaterThanOrEqualTo(String value) {
            addCriterion("ListName >=", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameLessThan(String value) {
            addCriterion("ListName <", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameLessThanOrEqualTo(String value) {
            addCriterion("ListName <=", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameLike(String value) {
            addCriterion("ListName like", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameNotLike(String value) {
            addCriterion("ListName not like", value, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameIn(List<String> values) {
            addCriterion("ListName in", values, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameNotIn(List<String> values) {
            addCriterion("ListName not in", values, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameBetween(String value1, String value2) {
            addCriterion("ListName between", value1, value2, "listname");
            return (Criteria) this;
        }

        public Criteria andListnameNotBetween(String value1, String value2) {
            addCriterion("ListName not between", value1, value2, "listname");
            return (Criteria) this;
        }

        public Criteria andListsortIsNull() {
            addCriterion("ListSort is null");
            return (Criteria) this;
        }

        public Criteria andListsortIsNotNull() {
            addCriterion("ListSort is not null");
            return (Criteria) this;
        }

        public Criteria andListsortEqualTo(Short value) {
            addCriterion("ListSort =", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortNotEqualTo(Short value) {
            addCriterion("ListSort <>", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortGreaterThan(Short value) {
            addCriterion("ListSort >", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortGreaterThanOrEqualTo(Short value) {
            addCriterion("ListSort >=", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortLessThan(Short value) {
            addCriterion("ListSort <", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortLessThanOrEqualTo(Short value) {
            addCriterion("ListSort <=", value, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortIn(List<Short> values) {
            addCriterion("ListSort in", values, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortNotIn(List<Short> values) {
            addCriterion("ListSort not in", values, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortBetween(Short value1, Short value2) {
            addCriterion("ListSort between", value1, value2, "listsort");
            return (Criteria) this;
        }

        public Criteria andListsortNotBetween(Short value1, Short value2) {
            addCriterion("ListSort not between", value1, value2, "listsort");
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

        public Criteria andCreatdateIsNull() {
            addCriterion("CreatDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNotNull() {
            addCriterion("CreatDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatdateEqualTo(Date value) {
            addCriterion("CreatDate =", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotEqualTo(Date value) {
            addCriterion("CreatDate <>", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThan(Date value) {
            addCriterion("CreatDate >", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreatDate >=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThan(Date value) {
            addCriterion("CreatDate <", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThanOrEqualTo(Date value) {
            addCriterion("CreatDate <=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIn(List<Date> values) {
            addCriterion("CreatDate in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotIn(List<Date> values) {
            addCriterion("CreatDate not in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateBetween(Date value1, Date value2) {
            addCriterion("CreatDate between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotBetween(Date value1, Date value2) {
            addCriterion("CreatDate not between", value1, value2, "creatdate");
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

        public Criteria andModifydateIsNull() {
            addCriterion("ModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("ModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterion("ModifyDate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterion("ModifyDate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterion("ModifyDate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyDate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterion("ModifyDate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterion("ModifyDate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterion("ModifyDate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterion("ModifyDate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterion("ModifyDate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterion("ModifyDate not between", value1, value2, "modifydate");
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