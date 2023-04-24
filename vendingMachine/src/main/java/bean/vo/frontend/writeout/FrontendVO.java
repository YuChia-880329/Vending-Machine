package bean.vo.frontend.writeout;

public class FrontendVO {

	private IllegalMsgVO illegalMsg;
	private ShoppingCartVO shoppingCart;
	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;
	
	
	public FrontendVO() {
	}
	public FrontendVO(IllegalMsgVO illegalMsg, ShoppingCartVO shoppingCart, WelcomePartVO welcomePart, 
			GoodsTablePageVO goodsTablePage, FilterFormVO filterForm) {

		this.illegalMsg = illegalMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
	}
	
	
	
	
	public IllegalMsgVO getIllegalMsg() {
		return illegalMsg;
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

	
	public void setIllegalMsg(IllegalMsgVO illegalMsg) {
		this.illegalMsg = illegalMsg;
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
