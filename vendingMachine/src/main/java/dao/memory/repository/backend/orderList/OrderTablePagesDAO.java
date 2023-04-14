package dao.memory.repository.backend.orderList;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePagesOBJ;
import memory.repository.backend.orderList.OrderTablePagesRepository;
import template.memory.repository.RepositoryDAOTemplate;
import transformer.backend.orderList.obj.orderTablePages.readin.OrderTablePagesInputOBJTransformer;
import transformer.backend.orderList.obj.orderTablePages.writeout.OrderTablePagesOBJTransformer;

public class OrderTablePagesDAO extends RepositoryDAOTemplate<OrderTablePagesInputOBJ, 
			OrderTablePagesOBJ, OrderTablePagesInputOBJDTO, OrderTablePagesOBJDTO, 
			OrderTablePagesRepository, OrderTablePagesInputOBJTransformer, OrderTablePagesOBJTransformer> {

	public OrderTablePagesDAO(OrderTablePagesRepository repository) {
		
		super(repository);
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
