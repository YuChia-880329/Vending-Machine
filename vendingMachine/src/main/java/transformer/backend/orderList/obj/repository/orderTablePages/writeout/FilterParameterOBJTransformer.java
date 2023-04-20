package transformer.backend.orderList.obj.repository.orderTablePages.writeout;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.FilterParameterOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.FilterParameterOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class FilterParameterOBJTransformer extends RepositoryObjTransformerTemplate<FilterParameterOBJ, FilterParameterOBJDTO> {
	
	private static final FilterParameterOBJTransformer INSTANCE = new FilterParameterOBJTransformer();
	
	private FilterParameterOBJTransformer() {
	}
	
	public static FilterParameterOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected FilterParameterOBJDTO objToDtoTransform(FilterParameterOBJ obj) {
		
		FilterParameterOBJDTO dto = new FilterParameterOBJDTO();
		
		dto.setCustomerName(obj.getCustomerName());
		dto.setStartDate(obj.getStartDate());
		dto.setEndDate(obj.getEndDate());
		dto.setGoodsName(obj.getGoodsName());
		dto.setGoodsPriceMin(obj.getGoodsPriceMin());
		dto.setGoodsPriceMax(obj.getGoodsPriceMax());
		dto.setBuyQuantityMin(obj.getBuyQuantityMin());
		dto.setBuyQuantityMax(obj.getBuyQuantityMax());
		dto.setTotalPriceMin(obj.getTotalPriceMin());
		dto.setTotalPriceMax(obj.getTotalPriceMax());
		
		return dto;
	}
}
