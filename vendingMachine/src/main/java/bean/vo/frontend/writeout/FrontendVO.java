package bean.vo.frontend.writeout;

public class FrontendVO {

	private AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg;
	private AddShoppingCartMsgVO addShoppingCartMsg;
	private ClearShoppingCartMsgVO clearShoppingCartMsg;
	private UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg;
	private UpdateShoppingCartMsgVO updateShoppingCartMsg;
	private CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg;
	private ShoppingCartVO shoppingCart;
	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;
	private ReceiptVO receipt;
	
	
	public FrontendVO() {
	}
	public FrontendVO(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg, AddShoppingCartMsgVO addShoppingCartMsg, ClearShoppingCartMsgVO clearShoppingCartMsg, 
			UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg, UpdateShoppingCartMsgVO updateShoppingCartMsg, CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg, 
			ShoppingCartVO shoppingCart, WelcomePartVO welcomePart, GoodsTablePageVO goodsTablePage, FilterFormVO filterForm, ReceiptVO receipt) {

		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
		this.addShoppingCartMsg = addShoppingCartMsg;
		this.clearShoppingCartMsg = clearShoppingCartMsg;
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
		this.updateShoppingCartMsg = updateShoppingCartMsg;
		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
		this.shoppingCart = shoppingCart;
		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.receipt = receipt;
	}
	
	
	public AddShoppingCartIllegalMsgVO getAddShoppingCartIllegalMsg() {
		return addShoppingCartIllegalMsg;
	}
	public AddShoppingCartMsgVO getAddShoppingCartMsg() {
		return addShoppingCartMsg;
	}
	public ClearShoppingCartMsgVO getClearShoppingCartMsg() {
		return clearShoppingCartMsg;
	}
	public UpdateShoppingCartIllegalMsgVO getUpdateShoppingCartIllegalMsg() {
		return updateShoppingCartIllegalMsg;
	}
	public UpdateShoppingCartMsgVO getUpdateShoppingCartMsg() {
		return updateShoppingCartMsg;
	}
	public CheckoutMoneyIllegalMsgVO getCheckoutMoneyIllegalMsg() {
		return checkoutMoneyIllegalMsg;
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
	public ReceiptVO getReceipt() {
		return receipt;
	}

	
	
	public void setAddShoppingCartIllegalMsg(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg) {
		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
	}
	public void setAddShoppingCartMsg(AddShoppingCartMsgVO addShoppingCartMsg) {
		this.addShoppingCartMsg = addShoppingCartMsg;
	}
	public void setClearShoppingCartMsg(ClearShoppingCartMsgVO clearShoppingCartMsg) {
		this.clearShoppingCartMsg = clearShoppingCartMsg;
	}
	public void setUpdateShoppingCartIllegalMsg(UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg) {
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
	}
	public void setUpdateShoppingCartMsg(UpdateShoppingCartMsgVO updateShoppingCartMsg) {
		this.updateShoppingCartMsg = updateShoppingCartMsg;
	}
	public void setCheckoutMoneyIllegalMsg(CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg) {
		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
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
	public void setReceipt(ReceiptVO receipt) {
		this.receipt = receipt;
	}
}
