package bean.dto.frontend.vo.writeout;

public class FrontendVODTO {

	private ShoppingCartVODTO shoppingCart;
	private WelcomePartVODTO welcomePart;
	private GoodsTablePageVODTO goodsTablePage;
	private FilterFormVODTO filterForm;
	private ReceiptVODTO receipt;
	
	
	public FrontendVODTO() {
	}
	public FrontendVODTO(ShoppingCartVODTO shoppingCart, WelcomePartVODTO welcomePart, 
			GoodsTablePageVODTO goodsTablePage, FilterFormVODTO filterForm, ReceiptVODTO receipt) {

		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
		this.receipt = receipt;
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
	public ReceiptVODTO getReceipt() {
		return receipt;
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
	public void setReceipt(ReceiptVODTO receipt) {
		this.receipt = receipt;
	}
}
