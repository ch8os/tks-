package com.tks.db.common.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPatientInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPatientInfoExample() {
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

        public Criteria andOpenidIsNull() {
            addCriterion("OPENID is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("OPENID =", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("OPENID <>", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("OPENID >", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("OPENID >=", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("OPENID <", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("OPENID <=", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("OPENID like", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("OPENID not like", value, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("OPENID in", values, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("OPENID not in", values, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("OPENID between", value1, value2, "userinfo");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("OPENID not between", value1, value2, "userinfo");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("MOBILEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("MOBILEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(Integer value) {
            addCriterion("MOBILEPHONE =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(Integer value) {
            addCriterion("MOBILEPHONE <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(Integer value) {
            addCriterion("MOBILEPHONE >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("MOBILEPHONE >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(Integer value) {
            addCriterion("MOBILEPHONE <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(Integer value) {
            addCriterion("MOBILEPHONE <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<Integer> values) {
            addCriterion("MOBILEPHONE in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<Integer> values) {
            addCriterion("MOBILEPHONE not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(Integer value1, Integer value2) {
            addCriterion("MOBILEPHONE between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(Integer value1, Integer value2) {
            addCriterion("MOBILEPHONE not between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("IDCARD is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("IDCARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("IDCARD =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("IDCARD <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("IDCARD >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("IDCARD <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("IDCARD <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("IDCARD like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("IDCARD not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("IDCARD in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("IDCARD not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("IDCARD between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("IDCARD not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeIsNull() {
            addCriterion("DIABETES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeIsNotNull() {
            addCriterion("DIABETES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeEqualTo(String value) {
            addCriterion("DIABETES_TYPE =", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeNotEqualTo(String value) {
            addCriterion("DIABETES_TYPE <>", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeGreaterThan(String value) {
            addCriterion("DIABETES_TYPE >", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DIABETES_TYPE >=", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeLessThan(String value) {
            addCriterion("DIABETES_TYPE <", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeLessThanOrEqualTo(String value) {
            addCriterion("DIABETES_TYPE <=", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeLike(String value) {
            addCriterion("DIABETES_TYPE like", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeNotLike(String value) {
            addCriterion("DIABETES_TYPE not like", value, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeIn(List<String> values) {
            addCriterion("DIABETES_TYPE in", values, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeNotIn(List<String> values) {
            addCriterion("DIABETES_TYPE not in", values, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeBetween(String value1, String value2) {
            addCriterion("DIABETES_TYPE between", value1, value2, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiabetesTypeNotBetween(String value1, String value2) {
            addCriterion("DIABETES_TYPE not between", value1, value2, "diabetesType");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateIsNull() {
            addCriterion("DIAGNOSIS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateIsNotNull() {
            addCriterion("DIAGNOSIS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateEqualTo(Date value) {
            addCriterion("DIAGNOSIS_DATE =", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateNotEqualTo(Date value) {
            addCriterion("DIAGNOSIS_DATE <>", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateGreaterThan(Date value) {
            addCriterion("DIAGNOSIS_DATE >", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DIAGNOSIS_DATE >=", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateLessThan(Date value) {
            addCriterion("DIAGNOSIS_DATE <", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateLessThanOrEqualTo(Date value) {
            addCriterion("DIAGNOSIS_DATE <=", value, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateIn(List<Date> values) {
            addCriterion("DIAGNOSIS_DATE in", values, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateNotIn(List<Date> values) {
            addCriterion("DIAGNOSIS_DATE not in", values, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateBetween(Date value1, Date value2) {
            addCriterion("DIAGNOSIS_DATE between", value1, value2, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andDiagnosisDateNotBetween(Date value1, Date value2) {
            addCriterion("DIAGNOSIS_DATE not between", value1, value2, "diagnosisDate");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesIsNull() {
            addCriterion("OTHER_DISEASES is null");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesIsNotNull() {
            addCriterion("OTHER_DISEASES is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesEqualTo(String value) {
            addCriterion("OTHER_DISEASES =", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesNotEqualTo(String value) {
            addCriterion("OTHER_DISEASES <>", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesGreaterThan(String value) {
            addCriterion("OTHER_DISEASES >", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_DISEASES >=", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesLessThan(String value) {
            addCriterion("OTHER_DISEASES <", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesLessThanOrEqualTo(String value) {
            addCriterion("OTHER_DISEASES <=", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesLike(String value) {
            addCriterion("OTHER_DISEASES like", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesNotLike(String value) {
            addCriterion("OTHER_DISEASES not like", value, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesIn(List<String> values) {
            addCriterion("OTHER_DISEASES in", values, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesNotIn(List<String> values) {
            addCriterion("OTHER_DISEASES not in", values, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesBetween(String value1, String value2) {
            addCriterion("OTHER_DISEASES between", value1, value2, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andOtherDiseasesNotBetween(String value1, String value2) {
            addCriterion("OTHER_DISEASES not between", value1, value2, "otherDiseases");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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