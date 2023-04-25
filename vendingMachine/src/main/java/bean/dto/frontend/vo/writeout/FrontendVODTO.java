package bean.dto.frontend.vo.writeout;

public class FrontendVODTO {

	private AddShoppingCartMsgVODTO addShoppingCartMsg;
	private ShoppingCartVODTO shoppingCart;
	private WelcomePartVODTO welcomePart;
	private GoodsTablePageVODTO goodsTablePage;
	private FilterFormVODTO filterForm;
	
	
	public FrontendVODTO() {
	}
	public FrontendVODTO(AddShoppingCartMsgVODTO addShoppingCartMsg, ShoppingCartVODTO shoppingCart, WelcomePartVODTO welcomePart, 
			GoodsTablePageVODTO goodsTablePage, FilterFormVODTO filterForm) {

		this.addShoppingCartMsg = addShoppingCartMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
	}
	
	
	
	public AddShoppingCartMsgVODTO getAddShoppingCartMsg() {
		return addShoppingCartMsg;
	}
	public ShoppingCartVODTO getShoppingCart() {
		return shoppingCart;
	}
	public WelcomePartVODTO getWelcomePart() {
		return welcomePart;
	}
	public GoodsTablePageVODTO getGoodsTablePage() {
		return goodsTablePage;
	}
	public FilterFormVODTO getFilterForm() {
		return filterForm;
	}

	
	public void setAddShoppingCartMsg(AddShoppingCartMsgVODTO addShoppingCartMsg) {
		this.addShoppingCartMsg = addShoppingCartMsg;
	}
	public void setShoppingCart(ShoppingCartVODTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public void setWelcomePart(WelcomePartVODTO welcomePart) {
		this.welcomePart = welcomePart;
	}
	public void setGoodsTablePage(GoodsTablePageVODTO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setFilterForm(FilterFormVODTO filterForm) {
		this.filterForm = filterForm;
	}
}
