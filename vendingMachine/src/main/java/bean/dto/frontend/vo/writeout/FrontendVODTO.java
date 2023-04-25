package bean.dto.frontend.vo.writeout;

public class FrontendVODTO {

	private MsgVODTO msg;
	private ShoppingCartVODTO shoppingCart;
	private WelcomePartVODTO welcomePart;
	private GoodsTablePageVODTO goodsTablePage;
	private FilterFormVODTO filterForm;
	
	
	public FrontendVODTO() {
	}
	public FrontendVODTO(MsgVODTO msg, ShoppingCartVODTO shoppingCart, WelcomePartVODTO welcomePart, 
			GoodsTablePageVODTO goodsTablePage, FilterFormVODTO filterForm) {

		this.msg = msg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
	}
	
	
	
	public MsgVODTO getMsg() {
		return msg;
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

	
	public void setMsg(MsgVODTO msg) {
		this.msg = msg;
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
