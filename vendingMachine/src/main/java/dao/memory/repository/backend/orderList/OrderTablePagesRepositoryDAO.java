package dao.memory.repository.backend.orderList;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePagesOBJ;
import memory.repository.backend.orderList.OrderTablePagesRepository;
import template.memory.repository.RepositoryDAOTemplate;
import transformer.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJTransformer;
import transformer.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJTransformer;

public class OrderTablePagesRepositoryDAO extends RepositoryDAOTemplate<OrderTablePagesInputOBJ, 
			OrderTablePagesOBJ, OrderTablePagesInputOBJDTO, OrderTablePagesOBJDTO, 
			OrderTablePagesRepository, OrderTablePagesInputOBJTransformer, OrderTablePagesOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "orderTablePagesRepositoryDAO";
	
	
	public OrderTablePagesRepositoryDAO(OrderTablePagesRepository repository) {
		
		super(repository);
	}

	public void requireUpdate() {
		
		repository.requireUpdate();
	}
	
	
	@Override
	protected OrderTablePagesInputOBJTransformer getInputTransformer() {
		
		return OrderTablePagesInputOBJTransformer.getInstance();
	}
	@Override
	protected OrderTablePagesOBJTransformer getObjTransformer() {

		return OrderTablePagesOBJTransformer.getInstance();
	}
}
