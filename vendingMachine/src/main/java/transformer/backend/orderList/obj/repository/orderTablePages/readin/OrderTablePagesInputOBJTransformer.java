package transformer.backend.orderList.obj.repository.orderTablePages.readin;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import template.memory.repository.RepositoryInputTransformerTemplate;

public class OrderTablePagesInputOBJTransformer extends RepositoryInputTransformerTemplate<OrderTablePagesInputOBJDTO, OrderTablePagesInputOBJ> {

	private static final OrderTablePagesInputOBJTransformer INSTANCE = new OrderTablePagesInputOBJTransformer();
	
	private OrderTablePagesInputOBJTransformer() {
	}
	
	public static OrderTablePagesInputOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTablePagesInputOBJ dtoToInputTransform(OrderTablePagesInputOBJDTO dto) {
		
		OrderTablePagesInputOBJ obj = new OrderTablePagesInputOBJ();
		
		obj.setCurrentPage(dto.getCurrentPage());
		obj.setCustomerName(dto.getCustomerName());
		obj.setStartDate(dto.getStartDate());
		obj.setEndDate(dto.getEndDate());
		obj.setGoodsName(dto.getGoodsName());
		obj.setGoodsPriceMin(dto.getGoodsPriceMin());
		obj.setGoodsPriceMax(dto.getGoodsPriceMax());
		obj.setBuyQuantityMin(dto.getBuyQuantityMin());
		obj.setBuyQuantityMax(dto.getBuyQuantityMax());
		obj.setTotalPriceMin(dto.getTotalPriceMin());
		obj.setTotalPriceMax(dto.getTotalPriceMax());
		
		return obj;
	}
}
