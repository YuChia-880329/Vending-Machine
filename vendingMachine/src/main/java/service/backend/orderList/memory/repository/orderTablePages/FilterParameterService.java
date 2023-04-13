package service.backend.orderList.memory.repository.orderTablePages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bean.obj.backend.orderList.repository.orderTablePages.writein.FilterParameterOBJ;
import service.model.GoodsModelService;
import service.model.OrderModelService;
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
		
		QueryObj idQueryObj = getIdQueryObj(filterParameter.getIdMin(), filterParameter.getIdMax());
		if(idQueryObj != null)
			list.add(idQueryObj);
	}
	
	public boolean equals(FilterParameterOBJ filterParameter1, FilterParameterOBJ filterParameter2) {
		
		
	}
	
	private QueryObj getIdQueryObj(Integer idMin, Integer idMax) {
		
		if(idMin==null && idMax==null)
			return null;
		else if(idMin!=null && idMax!=null)
			return OrderModelService.getIdBetweenQueryObj(idMin, idMax);
		else if(idMin != null)
			return OrderModelService.getIdGreaterThanOrEqualToQueryObj(idMin);
		else
			return OrderModelService.getIdLessThanOrEqualToQueryObj(idMax);
	}
	private QueryObj getDateQueryObj(LocalDateTime startDate, LocalDateTime endDate) {
		
		if(startDate==null && endDate==null)
			return null;
		else if(startDate!=null && endDate!=null)
			return OrderModelService.getDateTimeBetweenQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(startDate), 
					DateTimeUtil.localDateTimeToTimestamp(endDate));
		else if(startDate != null)
			return OrderModelService.getDateTimeAfterQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(startDate));
		else
			return OrderModelService.getDateTimeBeforeQueryObj(
					DateTimeUtil.localDateTimeToTimestamp(endDate));
	}
	private QueryObj getCustomerIdQueryObj(String customerId) {
		
		if(customerId == null)
			return null;
		else
			return OrderModelService.getCustomerIdEqualToQueryObj(customerId);
	}
	
	private QueryObj getGoodsIdQueryObj(Integer goodsIdMin, Integer goodsIdMax) {
		
		if(goodsIdMin==null && goodsIdMax==null)
			return null;
		else if(goodsIdMin!=null && goodsIdMax!=null)
			return OrderModelService.getGoodsIdBetweenQueryObj(goodsIdMin, goodsIdMax);
		else if(goodsIdMin != null)
			return OrderModelService.getGoodsIdGreaterThanOrEqualToQueryObj(goodsIdMin);
		else
			return OrderModelService.getGoodsIdLessThanOrEqualToQueryObj(goodsIdMax);
	}
	private QueryObj getPriceQueryObj(Integer priceMin, Integer priceMax) {
		
		if(priceMin==null && priceMax==null)
			return null;
		else if(priceMin!=null && priceMax!=null)
			return OrderModelService.getPriceBetweenQueryObj(priceMin, priceMax);
		else if(priceMin != null)
			return OrderModelService.getPriceGreaterThanOrEqualToQueryObj(priceMin);
		else
			return OrderModelService.getPriceLessThanOrEqualToQueryObj(priceMax);
	}
	private QueryObj getBuyQuantityQueryObj(Integer buyQuantityMin, Integer buyQuantityMax) {
		
		if(buyQuantityMin==null && buyQuantityMax==null)
			return null;
		else if(buyQuantityMin!=null && buyQuantityMax!=null)
			return OrderModelService.getBuyQuantityBetweenQueryObj(buyQuantityMin, buyQuantityMax);
		else if(buyQuantityMin != null)
			return OrderModelService.getBuyQuantityGreaterThanOrEqualToQueryObj(buyQuantityMin);
		else
			return OrderModelService.getBuyQuantityLessThanOrEqualToQueryObj(buyQuantityMax);
	}
}
