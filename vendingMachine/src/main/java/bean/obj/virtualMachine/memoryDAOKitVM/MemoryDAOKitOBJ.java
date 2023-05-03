package bean.obj.virtualMachine.memoryDAOKitVM;

import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;
import dao.memory.statusCache.login.CurrentMemberStatusCacheDAO;

public class MemoryDAOKitOBJ {

	private AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO;
	private AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO;
	private ReceiptContentCacheDAO receiptContentCacheDAO;
	private UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO;
	private UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO;
	private ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO;
	private GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO;
	private OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO;
	private dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO;
	private CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO;
	private ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO;
	private CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO;
	
	
	public MemoryDAOKitOBJ() {
	}
	public MemoryDAOKitOBJ(AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO,
			AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO,
			ReceiptContentCacheDAO receiptContentCacheDAO,
			UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO,
			UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO,
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO,
			OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO,
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO,
			CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO,
			ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO,
			CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO) {
	
		this.addShoppingCartIllegalMsgLineCacheDAO = addShoppingCartIllegalMsgLineCacheDAO;
		this.addShoppingCartMsgLineCacheDAO = addShoppingCartMsgLineCacheDAO;
		this.receiptContentCacheDAO = receiptContentCacheDAO;
		this.updateShoppingCartIllegalMsgLineCacheDAO = updateShoppingCartIllegalMsgLineCacheDAO;
		this.updateShoppingCartMsgLineCacheDAO = updateShoppingCartMsgLineCacheDAO;
		this.shoppingCartMemoryDbDAO = shoppingCartMemoryDbDAO;
		this.goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAO;
		this.orderTablePagesRepositoryDAO = orderTablePagesRepositoryDAO;
		this.frontendGoodsTablePagesRepositoryDAO = frontendGoodsTablePagesRepositoryDAO;
		this.checkoutMoneyIllegalMsgStatusCacheDAO = checkoutMoneyIllegalMsgStatusCacheDAO;
		this.clearShoppingCartMsgStatusCacheDAO = clearShoppingCartMsgStatusCacheDAO;
		this.currentMemberStatusCacheDAO = currentMemberStatusCacheDAO;
	}


	public AddShoppingCartIllegalMsgLineCacheDAO getAddShoppingCartIllegalMsgLineCacheDAO() {
		return addShoppingCartIllegalMsgLineCacheDAO;
	}
	public AddShoppingCartMsgLineCacheDAO getAddShoppingCartMsgLineCacheDAO() {
		return addShoppingCartMsgLineCacheDAO;
	}
	public ReceiptContentCacheDAO getReceiptContentCacheDAO() {
		return receiptContentCacheDAO;
	}
	public UpdateShoppingCartIllegalMsgLineCacheDAO getUpdateShoppingCartIllegalMsgLineCacheDAO() {
		return updateShoppingCartIllegalMsgLineCacheDAO;
	}
	public UpdateShoppingCartMsgLineCacheDAO getUpdateShoppingCartMsgLineCacheDAO() {
		return updateShoppingCartMsgLineCacheDAO;
	}
	public ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO() {
		return shoppingCartMemoryDbDAO;
	}
	public GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO() {
		return goodsTablePagesRepositoryDAO;
	}
	public OrderTablePagesRepositoryDAO getOrderTablePagesRepositoryDAO() {
		return orderTablePagesRepositoryDAO;
	}
	public dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO() {
		return frontendGoodsTablePagesRepositoryDAO;
	}
	public CheckoutMoneyIllegalMsgStatusCacheDAO getCheckoutMoneyIllegalMsgStatusCacheDAO() {
		return checkoutMoneyIllegalMsgStatusCacheDAO;
	}
	public ClearShoppingCartMsgStatusCacheDAO getClearShoppingCartMsgStatusCacheDAO() {
		return clearShoppingCartMsgStatusCacheDAO;
	}
	public CurrentMemberStatusCacheDAO getCurrentMemberStatusCacheDAO() {
		return currentMemberStatusCacheDAO;
	}




	public void setAddShoppingCartIllegalMsgLineCacheDAO(
			AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO) {
		this.addShoppingCartIllegalMsgLineCacheDAO = addShoppingCartIllegalMsgLineCacheDAO;
	}
	public void setAddShoppingCartMsgLineCacheDAO(AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO) {
		this.addShoppingCartMsgLineCacheDAO = addShoppingCartMsgLineCacheDAO;
	}
	public void setReceiptContentCacheDAO(ReceiptContentCacheDAO receiptContentCacheDAO) {
		this.receiptContentCacheDAO = receiptContentCacheDAO;
	}
	public void setUpdateShoppingCartIllegalMsgLineCacheDAO(
			UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO) {
		this.updateShoppingCartIllegalMsgLineCacheDAO = updateShoppingCartIllegalMsgLineCacheDAO;
	}
	public void setUpdateShoppingCartMsgLineCacheDAO(UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO) {
		this.updateShoppingCartMsgLineCacheDAO = updateShoppingCartMsgLineCacheDAO;
	}
	public void setShoppingCartMemoryDbDAO(ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		this.shoppingCartMemoryDbDAO = shoppingCartMemoryDbDAO;
	}
	public void setGoodsTablePagesRepositoryDAO(GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO) {
		this.goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAO;
	}
	public void setOrderTablePagesRepositoryDAO(OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO) {
		this.orderTablePagesRepositoryDAO = orderTablePagesRepositoryDAO;
	}
	public void setFrontendGoodsTablePagesRepositoryDAO(
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO) {
		this.frontendGoodsTablePagesRepositoryDAO = frontendGoodsTablePagesRepositoryDAO;
	}
	public void setCheckoutMoneyIllegalMsgStatusCacheDAO(
			CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO) {
		this.checkoutMoneyIllegalMsgStatusCacheDAO = checkoutMoneyIllegalMsgStatusCacheDAO;
	}
	public void setClearShoppingCartMsgStatusCacheDAO(
			ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO) {
		this.clearShoppingCartMsgStatusCacheDAO = clearShoppingCartMsgStatusCacheDAO;
	}
	public void setCurrentMemberStatusCacheDAO(CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO) {
		this.currentMemberStatusCacheDAO = currentMemberStatusCacheDAO;
	}
}
