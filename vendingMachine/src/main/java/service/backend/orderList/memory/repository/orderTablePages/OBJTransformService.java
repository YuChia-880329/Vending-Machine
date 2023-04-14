package service.backend.orderList.memory.repository.orderTablePages;

import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.FilterParameterOBJ;

public class OBJTransformService {

	private static final OBJTransformService INSTANCE = new OBJTransformService();
	
	private OBJTransformService() {
	}
	
	public static OBJTransformService getInstance() {
		
		return INSTANCE;
	}
	
	public FilterParameterOBJ orderTablePagesInputToFilterParameter(OrderTablePagesInputOBJ orderTablePagesInputOBJ) {
		
		FilterParameterOBJ filterParameterOBJ = new FilterParameterOBJ();
		
		filterParameterOBJ.setCustomerName(orderTablePagesInputOBJ.getCustomerName());
		filterParameterOBJ.setStartDate(orderTablePagesInputOBJ.getStartDate());
		filterParameterOBJ.setEndDate(orderTablePagesInputOBJ.getEndDate());
		filterParameterOBJ.setGoodsName(orderTablePagesInputOBJ.getGoodsName());
		filterParameterOBJ.setGoodsPriceMin(orderTablePagesInputOBJ.getGoodsPriceMin());
		filterParameterOBJ.setGoodsPriceMax(orderTablePagesInputOBJ.getGoodsPriceMax());
		filterParameterOBJ.setBuyQuantityMin(orderTablePagesInputOBJ.getBuyQuantityMin());
		filterParameterOBJ.setBuyQuantityMax(orderTablePagesInputOBJ.getBuyQuantityMax());
		filterParameterOBJ.setTotalPriceMin(orderTablePagesInputOBJ.getTotalPriceMin());
		filterParameterOBJ.setTotalPriceMax(orderTablePagesInputOBJ.getTotalPriceMax());
		
		return filterParameterOBJ;
	}
}
