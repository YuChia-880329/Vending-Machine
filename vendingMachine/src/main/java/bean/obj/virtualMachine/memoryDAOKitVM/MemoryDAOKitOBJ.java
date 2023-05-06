package bean.obj.virtualMachine.memoryDAOKitVM;

import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;
import dao.memory.statusCache.login.NotLoginMsgStatusCacheDAO;

public class MemoryDAOKitOBJ {

	private ReceiptContentCacheDAO receiptContentCacheDAO;
	private ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO;
	private GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO;
	private OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO;
	private dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO;
	private CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO;
	private NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO;
	private CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO;
	
	
	public MemoryDAOKitOBJ() {
	}
	public MemoryDAOKitOBJ(ReceiptContentCacheDAO receiptContentCacheDAO,
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO,
			OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO,
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO,
			CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO,
			NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO,
			CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO) {
	
		this.receiptContentCacheDAO = receiptContentCacheDAO;
		this.shoppingCartMemoryDbDAO = shoppingCartMemoryDbDAO;
		this.goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAO;
		this.orderTablePagesRepositoryDAO = orderTablePagesRepositoryDAO;
		this.frontendGoodsTablePagesRepositoryDAO = frontendGoodsTablePagesRepositoryDAO;
		this.currentMemberStatusCacheDAO = currentMemberStatusCacheDAO;
		this.notLoginMsgStatusCacheDAO = notLoginMsgStatusCacheDAO;
		this.checkoutMoneyIllegalMsgStatusCacheDAO = checkoutMoneyIllegalMsgStatusCacheDAO;
	}


	public ReceiptContentCacheDAO getReceiptContentCacheDAO() {
		return receiptContentCacheDAO;
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
	public CurrentMemberStatusCacheDAO getCurrentMemberStatusCacheDAO() {
		return currentMemberStatusCacheDAO;
	}
	public NotLoginMsgStatusCacheDAO getNotLoginMsgStatusCacheDAO() {
		return notLoginMsgStatusCacheDAO;
	}
	public CheckoutMoneyIllegalMsgStatusCacheDAO getCheckoutMoneyIllegalMsgStatusCacheDAO() {
		return checkoutMoneyIllegalMsgStatusCacheDAO;
	}
	
	
	

	public void setReceiptContentCacheDAO(ReceiptContentCacheDAO receiptContentCacheDAO) {
		this.receiptContentCacheDAO = receiptContentCacheDAO;
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
	public void setCurrentMemberStatusCacheDAO(CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO) {
		this.currentMemberStatusCacheDAO = currentMemberStatusCacheDAO;
	}
	public void setNotLoginMsgStatusCacheDAO(NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO) {
		this.notLoginMsgStatusCacheDAO = notLoginMsgStatusCacheDAO;
	}
	public void setCheckoutMoneyIllegalMsgStatusCacheDAO(
			CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO) {
		this.checkoutMoneyIllegalMsgStatusCacheDAO = checkoutMoneyIllegalMsgStatusCacheDAO;
	}
}
