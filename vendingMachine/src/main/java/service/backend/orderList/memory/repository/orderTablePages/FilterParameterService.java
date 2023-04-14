package service.backend.orderList.memory.repository.orderTablePages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.obj.backend.orderList.repository.orderTablePages.writein.FilterParameterOBJ;
import service.model.OrderJoinModelService;
import template.model.QueryObj;
import util.DateTimeUtil;

public class FilterParameterService {

	private static final FilterParameterService INSTANCE = new FilterParameterService();
	
	private FilterParameterService() {
	}
	
	public static FilterParameterService getInstance() {
		
		return INSTANCE;
	}
	
	public QueryObj[] getQueryObjs(FilterParameterOBJ filterParameter) {
		
		List<QueryObj> list = new ArrayList<>();
		
		QueryObj customerNameQueryObj = getCustomerNameQueryObj(filterParameter.getCustomerName());
		if(customerNameQueryObj != null)
			list.add(customerNameQueryObj);
		
		QueryObj dateQueryObj = getDateQueryObj(filterParameter.getStartDate(), filterParameter.getEndDate());
		if(dateQueryObj != null)
			list.add(dateQueryObj);
		
		QueryObj goodsNameQueryObj = getGoodsNameQueryObj(filterParameter.getGoodsName());
		if(goodsNameQueryObj != null)
			list.add(goodsNameQueryObj);
		
		QueryObj goodsPriceQueryObj = getGoodsPriceQueryObj(filterParameter.getGoodsPriceMin(), filterParameter.getGoodsPriceMax());
		if(goodsPriceQueryObj != null)
			list.add(goodsPriceQueryObj);
		
		QueryObj buyQuantityQueryObj = getBuyQuantityQueryObj(filterParameter.getBuyQuantityMin(), filterParameter.getBuyQuantityMax());
		if(buyQuantityQueryObj != null)
			list.add(buyQuantityQueryObj);
		
		QueryObj totalPriceQueryObj = getTotalPriceQueryObj(filterParameter.getTotalPriceMin(), filterParameter.getTotalPriceMax());
		if(totalPriceQueryObj != null)
			list.add(totalPriceQueryObj);
		
		return list.toArray(new QueryObj[list.size()]);
	}
	
	public boolean equals(FilterParameterOBJ filterParameter1, FilterParameterOBJ filterParameter2) {
		
		return customerNameEquals(filterParameter1.getCustomerName(), filterParameter2.getCustomerName())
				&& startDateEquals(filterParameter1.getStartDate(), filterParameter2.getStartDate())
				&& endDateEquals(filterParameter1.getEndDate(), filterParameter2.getEndDate())
				&& goodsNameEquals(filterParameter1.getGoodsName(), filterParameter2.getGoodsName())
				&& goodsPriceMinEquals(filterParameter1.getGoodsPriceMin(), filterParameter2.getGoodsPriceMin())
				&& goodsPriceMaxEquals(filterParameter1.getGoodsPriceMax(), filterParameter2.getGoodsPriceMax())
				&& buyQuantityMinEquals(filterParameter1.getBuyQuantityMin(), filterParameter2.getBuyQuantityMin())
				&& buyQuantityMaxEquals(filterParameter1.getBuyQuantityMax(), filterParameter2.getBuyQuantityMax())
				&& totalPriceMinEquals(filterParameter1.getTotalPriceMin(), filterParameter2.getTotalPriceMin())
				&& totalPriceMaxEquals(filterParameter1.getTotalPriceMax(), filterParameter2.getTotalPriceMax());
	}
	
	private QueryObj getCustomerNameQueryObj(String customerName) {
		
		if(customerName==null)
			return null;
		else
			return OrderJoinModelService.getCustomerNameLikeQueryObj(customerName);
	}
	private QueryObj getDateQueryObj(LocalDate startDate, LocalDate endDate) {
		
		if(startDate==null && endDate==null)
			return null;
		else if(startDate!=null && endDate!=null)
			return OrderJoinModelService.getDateTimeBetweenQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(DateTimeUtil.localDateToLocalDateTimeStart(startDate)), 
					DateTimeUtil.localDateTimeToTimestamp(DateTimeUtil.localDateToLocalDateTimeEnd(endDate)));
		else if(startDate != null)
			return OrderJoinModelService.getDateTimeAfterQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(DateTimeUtil.localDateToLocalDateTimeStart(startDate)));
		else
			return OrderJoinModelService.getDateTimeBeforeQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(DateTimeUtil.localDateToLocalDateTimeEnd(endDate)));
	}
	private QueryObj getGoodsNameQueryObj(String goodsName) {
		
		if(goodsName==null)
			return null;
		else
			return OrderJoinModelService.getGoodsNameLikeQueryObj(goodsName);
	}
	private QueryObj getGoodsPriceQueryObj(Integer goodsPriceMin, Integer goodsPriceMax) {
		
		if(goodsPriceMin==null && goodsPriceMax==null)
			return null;
		else if(goodsPriceMin!=null && goodsPriceMax!=null)
			return OrderJoinModelService.getGoodsPriceBetweenQueryObj(goodsPriceMin, goodsPriceMax);
		else if(goodsPriceMin != null)
			return OrderJoinModelService.getGoodsPriceGreaterThanOrEqualToQueryObj(goodsPriceMin);
		else
			return OrderJoinModelService.getGoodsPriceLessThanOrEqualToQueryObj(goodsPriceMax);
	}
	private QueryObj getBuyQuantityQueryObj(Integer buyQuantityMin, Integer buyQuantityMax) {
		
		if(buyQuantityMin==null && buyQuantityMax==null)
			return null;
		else if(buyQuantityMin!=null && buyQuantityMax!=null)
			return OrderJoinModelService.getBuyQuantityBetweenQueryObj(buyQuantityMin, buyQuantityMax);
		else if(buyQuantityMin != null)
			return OrderJoinModelService.getBuyQuantityGreaterThanOrEqualToQueryObj(buyQuantityMin);
		else
			return OrderJoinModelService.getBuyQuantityLessThanOrEqualToQueryObj(buyQuantityMax);
	}
	private QueryObj getTotalPriceQueryObj(Integer totalPriceMin, Integer totalPriceMax) {
		
		if(totalPriceMin==null && totalPriceMax==null)
			return null;
		else if(totalPriceMin!=null && totalPriceMax!=null)
			return OrderJoinModelService.getTotalPriceBetweenQueryObj(totalPriceMin, totalPriceMax);
		else if(totalPriceMin != null)
			return OrderJoinModelService.getTotalPriceGreaterThanOrEqualToQueryObj(totalPriceMin);
		else
			return OrderJoinModelService.getTotalPriceLessThanOrEqualToQueryObj(totalPriceMax);
	}
	
	
	private boolean customerNameEquals(String customerName1, String customerName2) {
		
		if(customerName1==null && customerName2==null)
			return true;
		else if(customerName1==null || customerName2==null)
			return false;
		else
			return customerName1.equals(customerName2);
	}
	private boolean startDateEquals(LocalDate startDate1, LocalDate startDate2) {
		
		if(startDate1==null && startDate2==null)
			return true;
		else if(startDate1==null || startDate2==null)
			return false;
		else
			return startDate1.equals(startDate2);
	}
	private boolean endDateEquals(LocalDate endDate1, LocalDate endDate2) {
		
		if(endDate1==null && endDate2==null)
			return true;
		else if(endDate1==null || endDate2==null)
			return false;
		else
			return endDate1.equals(endDate2);
	}
	private boolean goodsNameEquals(String goodsName1, String goodsName2) {
		
		if(goodsName1==null && goodsName2==null)
			return true;
		else if(goodsName1==null || goodsName2==null)
			return false;
		else
			return goodsName1.equals(goodsName2);
	}
	private boolean goodsPriceMinEquals(Integer goodsPriceMin1, Integer goodsPriceMin2) {
		
		if(goodsPriceMin1==null && goodsPriceMin2==null)
			return true;
		else if(goodsPriceMin1==null || goodsPriceMin2==null)
			return false;
		else
			return goodsPriceMin1.intValue() == goodsPriceMin2.intValue();
	}
	private boolean goodsPriceMaxEquals(Integer goodsPriceMax1, Integer goodsPriceMax2) {
		
		if(goodsPriceMax1==null && goodsPriceMax2==null)
			return true;
		else if(goodsPriceMax1==null || goodsPriceMax2==null)
			return false;
		else
			return goodsPriceMax1.intValue() == goodsPriceMax2.intValue();
	}
	private boolean buyQuantityMinEquals(Integer buyQuantityMin1, Integer buyQuantityMin2) {
		
		if(buyQuantityMin1==null && buyQuantityMin2==null)
			return true;
		else if(buyQuantityMin1==null || buyQuantityMin2==null)
			return false;
		else
			return buyQuantityMin1.intValue() == buyQuantityMin2.intValue();
	}
	private boolean buyQuantityMaxEquals(Integer buyQuantityMax1, Integer buyQuantityMax2) {
		
		if(buyQuantityMax1==null && buyQuantityMax2==null)
			return true;
		else if(buyQuantityMax1==null || buyQuantityMax2==null)
			return false;
		else
			return buyQuantityMax1.intValue() == buyQuantityMax2.intValue();
	}
	private boolean totalPriceMinEquals(Integer totalPriceMin1, Integer totalPriceMin2) {
		
		if(totalPriceMin1==null && totalPriceMin2==null)
			return true;
		else if(totalPriceMin1==null || totalPriceMin2==null)
			return false;
		else
			return totalPriceMin1.intValue() == totalPriceMin2.intValue();
	}
	private boolean totalPriceMaxEquals(Integer totalPriceMax1, Integer totalPriceMax2) {
		
		if(totalPriceMax1==null && totalPriceMax2==null)
			return true;
		else if(totalPriceMax1==null || totalPriceMax2==null)
			return false;
		else
			return totalPriceMax1.intValue() == totalPriceMax2.intValue();
	}
}
