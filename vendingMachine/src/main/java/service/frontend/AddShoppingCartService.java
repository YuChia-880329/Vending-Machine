package service.frontend;

import bean.dto.frontend.vo.readin.ShoppingCartVODTO;

public class AddShoppingCartService {

	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public void add(ShoppingCartVODTO shoppingCartVODTO) {
		
		
	}
}
