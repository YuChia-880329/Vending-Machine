package memory.repository.backend.orderList;

import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePagesOBJ;
import template.memory.repository.RepositoryTemplate;

public class OrderTablePagesRepository extends RepositoryTemplate<OrderTablePagesInputOBJ, OrderTablePagesOBJ> {

	private boolean updateRequired;
	
	
	@Override
	protected void init() {
		
		updateRequired = false;
	}

	@Override
	protected OrderTablePagesInputOBJ initialInput() {
		
		OrderTablePagesInputOBJ orderTablePagesInputOBJ = new OrderTablePagesInputOBJ();
		
		orderTablePagesInputOBJ.setCurrentPage(1);
		orderTablePagesInputOBJ.setCustomerName(null);
		orderTablePagesInputOBJ.setStartDate(null);
		orderTablePagesInputOBJ.setEndDate(null);
		orderTablePagesInputOBJ.setGoodsName(null);
		orderTablePagesInputOBJ.setGoodsPriceMin(null);
		orderTablePagesInputOBJ.setGoodsPriceMax(null);
		orderTablePagesInputOBJ.setBuyQuantityMin(null);
		orderTablePagesInputOBJ.setBuyQuantityMax(null);
		orderTablePagesInputOBJ.setTotalPriceMin(null);
		orderTablePagesInputOBJ.setTotalPriceMax(null);
		
		return orderTablePagesInputOBJ;
	}

	@Override
	protected boolean isNeedUpdate(OrderTablePagesInputOBJ i) {
		
		return false;
	}

	@Override
	protected OrderTablePagesOBJ update(OrderTablePagesInputOBJ i) {
		// TODO Auto-generated method stub
		return null;
	}
}
