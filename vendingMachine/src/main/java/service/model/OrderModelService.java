package service.model;

import bean.dto.model.OrderModelDTO;
import bean.model.OrderModel;
import dao.model.OrderModelDAO;
import template.model.ModelServiceTemplate;
import transformer.model.OrderModelTransformer;

public class OrderModelService extends ModelServiceTemplate<OrderModel, Integer, OrderModelDTO, OrderModelDAO, OrderModelTransformer> {

	private static final OrderModelService INSTANCE = new OrderModelService();
	
	private OrderModelService() {
	}
	
	public static OrderModelService getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected OrderModelDAO getModelDAO() {

		return OrderModelDAO.getInstance();
	}
	@Override
	protected OrderModelTransformer getModelTransformer() {

		return OrderModelTransformer.getInstance();
	}
}
