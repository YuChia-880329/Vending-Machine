package bean.vo.frontend.writeout;

public class FrontendVO {

	private AddShoppingCartMsgVO addShoppingCartMsg;
	private ClearShoppingCartMsgVO clearShoppingCartMsg;
	private ShoppingCartVO shoppingCart;
	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;
	
	
	public FrontendVO() {
	}
	public FrontendVO(AddShoppingCartMsgVO addShoppingCartMsg, ClearShoppingCartMsgVO clearShoppingCartMsg, 
			ShoppingCartVO shoppingCart, WelcomePartVO welcomePart, GoodsTablePageVO goodsTablePage, FilterFormVO filterForm) {

		this.addShoppingCartMsg = addShoppingCartMsg;
		this.clearShoppingCartMsg = clearShoppingCartMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
	}
	
	
	public AddShoppingCartMsgVO getAddShoppingCartMsg() {
		return addShoppingCartMsg;
	}
	public ClearShoppingCartMsgVO getClearShoppingCartMsg() {
		return clearShoppingCartMsg;
	}
	public ShoppingCartVO getShoppingCart() {
		return shoppingCart;
	}
	public WelcomePartVO getWelcomePart() {
		return welcomePart;
	}
	public GoodsTablePageVO getGoodsTablePage() {
		return goodsTablePage;
	}
	public FilterFormVO getFilterForm() {
		return filterForm;
	}

	
	public void setAddShoppingCartMsg(AddShoppingCartMsgVO addShoppingCartMsg) {
		this.addShoppingCartMsg = addShoppingCartMsg;
	}
	public void setClearShoppingCartMsg(ClearShoppingCartMsgVO clearShoppingCartMsg) {
		this.clearShoppingCartMsg = clearShoppingCartMsg;
	}
	public void setShoppingCart(ShoppingCartVO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public void setWelcomePart(WelcomePartVO welcomePart) {
		this.welcomePart = welcomePart;
	}
	public void setGoodsTablePage(GoodsTablePageVO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setFilterForm(FilterFormVO filterForm) {
		this.filterForm = filterForm;
	}
}
