package com.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.utils.digest.MessageDigestUtils;
import com.utils.format.NumberFormatUtil;

public class TicketDigestUtil {

	public static String encodeForOrder(
			String carrier,// 承运人代码
			String flightNo,// 航班号
			String classCode,// 舱位代码
			Date departureTime,// 起飞时间(日期、时间)
			Date arrivalTime,// 到达时间(日期、时间)
			String boardPoint,// 起飞城市编码
			String offPoint,// 目的城市编码
			String boardPointAt,// 起飞航站楼编码
			String offPointAt,// 到达航站楼编码
			Integer mileages,// 航班里程
			String aircraft, // 机型
			String direction, //去反程
			int passengerCountLimit,// 最大可订乘客数限制
			BigDecimal standardPrice,// 标准价
			BigDecimal adultPrice,// 成人价
			BigDecimal airportPriceTax,// 机场建设费
			BigDecimal adultFuelsurPriceTax,// 成人燃油附加税
			BigDecimal childFuelsurPriceTax,// 儿童燃油附加税
		    String boardCityCode,
			String offCityCode
	) {
		return MessageDigestUtils.md5Hex("[carrier=" + carrier + ", flightNo=" + flightNo + ", classCode=" + classCode
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", boardPoint=" + boardPoint
				+ ", offPoint=" + offPoint + ", boardPointAt=" + boardPointAt + ", offPointAt=" + offPointAt + ", mileages="
				+ mileages + ", aircraft=" + aircraft + ", direction=" + direction + ", passengerCountLimit="
				+ passengerCountLimit + ", standardPrice=" + formatHalfUpBigDecimal(standardPrice) + ", adultPrice=" + formatHalfUpBigDecimal(adultPrice)
				+ ", airportPriceTax=" + formatHalfUpBigDecimal(airportPriceTax) + ", adultFuelsurPriceTax=" + formatHalfUpBigDecimal(adultFuelsurPriceTax)
				+ ", childFuelsurPriceTax=" + formatHalfUpBigDecimal(childFuelsurPriceTax) + ", boardCityCode=" + boardCityCode +", offCityCode=" + offCityCode +"]");
	}

	private static BigDecimal formatHalfUpBigDecimal(BigDecimal standardPrice) {
		return standardPrice==null?null:NumberFormatUtil.formatHalfUpBigDecimal(standardPrice);
	}

}
