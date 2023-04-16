package service.backend.orderList.prepare;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.FilterFormVODTO;

public class FilterFormService {

	private static final FilterFormService INSTANCE = new FilterFormService();
	
	private FilterFormService() {
	}
	
	public static FilterFormService getInstance() {
		
		return INSTANCE;
	}
	
	public FilterFormVODTO prepare(PageParameterVODTO pageParameterVODTO) {
		
		FilterFormVODTO filterFormVODTO = new FilterFormVODTO();
		
		filterFormVODTO.setCustomerName(pageParameterVODTO.getCustomerName());
		filterFormVODTO.setStartDate(pageParameterVODTO.getStartDate());
		filterFormVODTO.setEndDate(pageParameterVODTO.getEndDate());
		filterFormVODTO.setGoodsName(pageParameterVODTO.getGoodsName());
		filterFormVODTO.setGoodsPriceMin(pageParameterVODTO.getGoodsPriceMin());
		filterFormVODTO.setGoodsPriceMax(pageParameterVODTO.getGoodsPriceMax());
		filterFormVODTO.setBuyQuantityMin(pageParameterVODTO.getBuyQuantityMin());
		filterFormVODTO.setBuyQuantityMax(pageParameterVODTO.getBuyQuantityMax());
		filterFormVODTO.setTotalPriceMin(pageParameterVODTO.getTotalPriceMin());
		filterFormVODTO.setTotalPriceMax(pageParameterVODTO.getTotalPriceMax());
		
		return filterFormVODTO;
	}
}
