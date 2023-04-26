package bean.vo.frontend.writeout;

public class FrontendVO {

	private AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg;
	private ClearShoppingCartMsgVO clearShoppingCartMsg;
	private ShoppingCartVO shoppingCart;
	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;
	
	
	public FrontendVO() {
	}
	public FrontendVO(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg, ClearShoppingCartMsgVO clearShoppingCartMsg, 
			ShoppingCartVO shoppingCart, WelcomePartVO welcomePart, GoodsTablePageVO goodsTablePage, FilterFormVO filterForm) {

		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
		this.clearShoppingCartMsg = clearShoppingCartMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
	}
	
	
	public AddShoppingCartIllegalMsgVO getAddShoppingCartIllegalMsg() {
		return addShoppingCartIllegalMsg;
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

	
	public void setAddShoppingCartIllegalMsg(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg) {
		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
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
