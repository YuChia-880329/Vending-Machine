package bean.vo.frontend.writeout;

public class FrontendVO {

	private ShoppingCartVO shoppingCart;
	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;
	
	
	public FrontendVO() {
	}
	public FrontendVO(ShoppingCartVO shoppingCart, WelcomePartVO welcomePart, 
			GoodsTablePageVO goodsTablePage, FilterFormVO filterForm) {

		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
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
