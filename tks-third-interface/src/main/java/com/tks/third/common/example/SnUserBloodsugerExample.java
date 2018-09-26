package com.tks.third.common.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SnUserBloodsugerExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SnUserBloodsugerExample() {
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

		public Criteria andCodeIsNull() {
			addCriterion("CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CODE not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andDevicesnIsNull() {
			addCriterion("DEVICESN is null");
			return (Criteria) this;
		}

		public Criteria andDevicesnIsNotNull() {
			addCriterion("DEVICESN is not null");
			return (Criteria) this;
		}

		public Criteria andDevicesnEqualTo(String value) {
			addCriterion("DEVICESN =", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnNotEqualTo(String value) {
			addCriterion("DEVICESN <>", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnGreaterThan(String value) {
			addCriterion("DEVICESN >", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICESN >=", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnLessThan(String value) {
			addCriterion("DEVICESN <", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnLessThanOrEqualTo(String value) {
			addCriterion("DEVICESN <=", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnLike(String value) {
			addCriterion("DEVICESN like", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnNotLike(String value) {
			addCriterion("DEVICESN not like", value, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnIn(List<String> values) {
			addCriterion("DEVICESN in", values, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnNotIn(List<String> values) {
			addCriterion("DEVICESN not in", values, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnBetween(String value1, String value2) {
			addCriterion("DEVICESN between", value1, value2, "devicesn");
			return (Criteria) this;
		}

		public Criteria andDevicesnNotBetween(String value1, String value2) {
			addCriterion("DEVICESN not between", value1, value2, "devicesn");
			return (Criteria) this;
		}

		public Criteria andUsercodeIsNull() {
			addCriterion("USERCODE is null");
			return (Criteria) this;
		}

		public Criteria andUsercodeIsNotNull() {
			addCriterion("USERCODE is not null");
			return (Criteria) this;
		}

		public Criteria andUsercodeEqualTo(String value) {
			addCriterion("USERCODE =", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeNotEqualTo(String value) {
			addCriterion("USERCODE <>", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeGreaterThan(String value) {
			addCriterion("USERCODE >", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
			addCriterion("USERCODE >=", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeLessThan(String value) {
			addCriterion("USERCODE <", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeLessThanOrEqualTo(String value) {
			addCriterion("USERCODE <=", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeLike(String value) {
			addCriterion("USERCODE like", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeNotLike(String value) {
			addCriterion("USERCODE not like", value, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeIn(List<String> values) {
			addCriterion("USERCODE in", values, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeNotIn(List<String> values) {
			addCriterion("USERCODE not in", values, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeBetween(String value1, String value2) {
			addCriterion("USERCODE between", value1, value2, "usercode");
			return (Criteria) this;
		}

		public Criteria andUsercodeNotBetween(String value1, String value2) {
			addCriterion("USERCODE not between", value1, value2, "usercode");
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

		public Criteria andResultIsNull() {
			addCriterion("RESULT is null");
			return (Criteria) this;
		}

		public Criteria andResultIsNotNull() {
			addCriterion("RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andResultEqualTo(BigDecimal value) {
			addCriterion("RESULT =", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotEqualTo(BigDecimal value) {
			addCriterion("RESULT <>", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThan(BigDecimal value) {
			addCriterion("RESULT >", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RESULT >=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThan(BigDecimal value) {
			addCriterion("RESULT <", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RESULT <=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultIn(List<BigDecimal> values) {
			addCriterion("RESULT in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotIn(List<BigDecimal> values) {
			addCriterion("RESULT not in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RESULT between", value1, value2, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RESULT not between", value1, value2, "result");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("UNIT is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("UNIT =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("UNIT <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("UNIT >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("UNIT >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("UNIT <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("UNIT <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("UNIT like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("UNIT not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("UNIT in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("UNIT not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("UNIT between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("UNIT not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andTesttimeIsNull() {
			addCriterion("TESTTIME is null");
			return (Criteria) this;
		}

		public Criteria andTesttimeIsNotNull() {
			addCriterion("TESTTIME is not null");
			return (Criteria) this;
		}

		public Criteria andTesttimeEqualTo(Date value) {
			addCriterion("TESTTIME =", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeNotEqualTo(Date value) {
			addCriterion("TESTTIME <>", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeGreaterThan(Date value) {
			addCriterion("TESTTIME >", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TESTTIME >=", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeLessThan(Date value) {
			addCriterion("TESTTIME <", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeLessThanOrEqualTo(Date value) {
			addCriterion("TESTTIME <=", value, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeIn(List<Date> values) {
			addCriterion("TESTTIME in", values, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeNotIn(List<Date> values) {
			addCriterion("TESTTIME not in", values, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeBetween(Date value1, Date value2) {
			addCriterion("TESTTIME between", value1, value2, "testtime");
			return (Criteria) this;
		}

		public Criteria andTesttimeNotBetween(Date value1, Date value2) {
			addCriterion("TESTTIME not between", value1, value2, "testtime");
			return (Criteria) this;
		}

		public Criteria andFoodstatusIsNull() {
			addCriterion("FOODSTATUS is null");
			return (Criteria) this;
		}

		public Criteria andFoodstatusIsNotNull() {
			addCriterion("FOODSTATUS is not null");
			return (Criteria) this;
		}

		public Criteria andFoodstatusEqualTo(String value) {
			addCriterion("FOODSTATUS =", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusNotEqualTo(String value) {
			addCriterion("FOODSTATUS <>", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusGreaterThan(String value) {
			addCriterion("FOODSTATUS >", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusGreaterThanOrEqualTo(String value) {
			addCriterion("FOODSTATUS >=", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusLessThan(String value) {
			addCriterion("FOODSTATUS <", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusLessThanOrEqualTo(String value) {
			addCriterion("FOODSTATUS <=", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusLike(String value) {
			addCriterion("FOODSTATUS like", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusNotLike(String value) {
			addCriterion("FOODSTATUS not like", value, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusIn(List<String> values) {
			addCriterion("FOODSTATUS in", values, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusNotIn(List<String> values) {
			addCriterion("FOODSTATUS not in", values, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusBetween(String value1, String value2) {
			addCriterion("FOODSTATUS between", value1, value2, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andFoodstatusNotBetween(String value1, String value2) {
			addCriterion("FOODSTATUS not between", value1, value2, "foodstatus");
			return (Criteria) this;
		}

		public Criteria andSourceIsNull() {
			addCriterion("SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(String value) {
			addCriterion("SOURCE =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(String value) {
			addCriterion("SOURCE <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(String value) {
			addCriterion("SOURCE >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(String value) {
			addCriterion("SOURCE >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(String value) {
			addCriterion("SOURCE <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(String value) {
			addCriterion("SOURCE <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLike(String value) {
			addCriterion("SOURCE like", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotLike(String value) {
			addCriterion("SOURCE not like", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<String> values) {
			addCriterion("SOURCE in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<String> values) {
			addCriterion("SOURCE not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(String value1, String value2) {
			addCriterion("SOURCE between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(String value1, String value2) {
			addCriterion("SOURCE not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("SEND_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("SEND_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterion("SEND_TIME =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterion("SEND_TIME <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterion("SEND_TIME >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SEND_TIME >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterion("SEND_TIME <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterion("SEND_TIME <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterion("SEND_TIME in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterion("SEND_TIME not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterion("SEND_TIME between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterion("SEND_TIME not between", value1, value2, "sendTime");
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