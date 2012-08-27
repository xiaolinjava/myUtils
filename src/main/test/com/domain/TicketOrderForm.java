package com.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TicketOrderForm {

	String carrier;// 承运人代码
	String flightNo;// 航班号
	String classCode;// 舱位代码
	Date departureTime;// 起飞时间(日期、时间)
	Date arrivalTime;// 到达时间(日期、时间)
	String boardPoint;// 起飞城市编码
	String offPoint;// 目的城市编码
	String boardPointAt;// 起飞航站楼编码
	String offPointAt;// 到达航站楼编码
	Integer mileages;// 航班里程
	String aircraft; // 机型
	String direction; // 去反程
	int passengerCountLimit;// 最大可订乘客数限制
	BigDecimal standardPrice;// 标准价
	BigDecimal adultPrice;// 成人价
	BigDecimal airportPriceTax;// 机场建设费
	BigDecimal adultFuelsurPriceTax;// 成人燃油附加税
	BigDecimal childFuelsurPriceTax;// 儿童燃油附加税
	String boardCityCode;
	String offCityCode;

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getBoardPoint() {
		return boardPoint;
	}

	public void setBoardPoint(String boardPoint) {
		this.boardPoint = boardPoint;
	}

	public String getOffPoint() {
		return offPoint;
	}

	public void setOffPoint(String offPoint) {
		this.offPoint = offPoint;
	}

	public String getBoardPointAt() {
		return boardPointAt;
	}

	public void setBoardPointAt(String boardPointAt) {
		this.boardPointAt = boardPointAt;
	}

	public String getOffPointAt() {
		return offPointAt;
	}

	public void setOffPointAt(String offPointAt) {
		this.offPointAt = offPointAt;
	}

	public Integer getMileages() {
		return mileages;
	}

	public void setMileages(Integer mileages) {
		this.mileages = mileages;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPassengerCountLimit() {
		return passengerCountLimit;
	}

	public void setPassengerCountLimit(int passengerCountLimit) {
		this.passengerCountLimit = passengerCountLimit;
	}

	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	public BigDecimal getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(BigDecimal adultPrice) {
		this.adultPrice = adultPrice;
	}

	public BigDecimal getAirportPriceTax() {
		return airportPriceTax;
	}

	public void setAirportPriceTax(BigDecimal airportPriceTax) {
		this.airportPriceTax = airportPriceTax;
	}

	public BigDecimal getAdultFuelsurPriceTax() {
		return adultFuelsurPriceTax;
	}

	public void setAdultFuelsurPriceTax(BigDecimal adultFuelsurPriceTax) {
		this.adultFuelsurPriceTax = adultFuelsurPriceTax;
	}

	public BigDecimal getChildFuelsurPriceTax() {
		return childFuelsurPriceTax;
	}

	public void setChildFuelsurPriceTax(BigDecimal childFuelsurPriceTax) {
		this.childFuelsurPriceTax = childFuelsurPriceTax;
	}

	public String getBoardCityCode() {
		return boardCityCode;
	}

	public void setBoardCityCode(String boardCityCode) {
		this.boardCityCode = boardCityCode;
	}

	public String getOffCityCode() {
		return offCityCode;
	}

	public void setOffCityCode(String offCityCode) {
		this.offCityCode = offCityCode;
	}

}
