package bean.dto.frontend.vo.writeout;

public class FrontendVODTO {

	private AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg;
	private AddShoppingCartMsgVODTO addShoppingCartMsg;
	private ClearShoppingCartMsgVODTO clearShoppingCartMsg;
	private UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg;
	private UpdateShoppingCartMsgVODTO updateShoppingCartMsg;
	private ShoppingCartVODTO shoppingCart;
	private WelcomePartVODTO welcomePart;
	private GoodsTablePageVODTO goodsTablePage;
	private FilterFormVODTO filterForm;
	private ReceiptVODTO receipt;
	
	
	public FrontendVODTO() {
	}
	public FrontendVODTO(AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg, AddShoppingCartMsgVODTO addShoppingCartMsg, ClearShoppingCartMsgVODTO clearShoppingCartMsg, 
			UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg, UpdateShoppingCartMsgVODTO updateShoppingCartMsg, ShoppingCartVODTO shoppingCart, WelcomePartVODTO welcomePart, 
			GoodsTablePageVODTO goodsTablePage, FilterFormVODTO filterForm, ReceiptVODTO receipt) {

		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
		this.addShoppingCartMsg = addShoppingCartMsg;
		this.clearShoppingCartMsg = clearShoppingCartMsg;
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
		this.updateShoppingCartMsg = updateShoppingCartMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
		this.receipt = receipt;
	}
	
	
	
	public AddShoppingCartIllegalMsgVODTO getAddShoppingCartIllegalMsg() {
		return addShoppingCartIllegalMsg;
	}
	public AddShoppingCartMsgVODTO getAddShoppingCartMsg() {
		return addShoppingCartMsg;
	}
	public ClearShoppingCartMsgVODTO getClearShoppingCartMsg() {
		return clearShoppingCartMsg;
	}
	public UpdateShoppingCartIllegalMsgVODTO getUpdateShoppingCartIllegalMsg() {
		return updateShoppingCartIllegalMsg;
	}
	public UpdateShoppingCartMsgVODTO getUpdateShoppingCartMsg() {
		return updateShoppingCartMsg;
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

	
	public void setAddShoppingCartIllegalMsg(AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg) {
		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
	}
	public void setAddShoppingCartMsg(AddShoppingCartMsgVODTO addShoppingCartMsg) {
		this.addShoppingCartMsg = addShoppingCartMsg;
	}
	public void setClearShoppingCartMsg(ClearShoppingCartMsgVODTO clearShoppingCartMsg) {
		this.clearShoppingCartMsg = clearShoppingCartMsg;
	}
	public void setUpdateShoppingCartIllegalMsg(UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg) {
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
	}
	public void setUpdateShoppingCartMsg(UpdateShoppingCartMsgVODTO updateShoppingCartMsg) {
		this.updateShoppingCartMsg = updateShoppingCartMsg;
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
