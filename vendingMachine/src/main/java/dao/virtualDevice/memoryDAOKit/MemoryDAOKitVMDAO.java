package dao.virtualDevice.memoryDAOKit;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.MemoryDAOKitOBJDTO;
import bean.obj.virtualMachine.memoryDAOKitVM.AccountOBJ;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;
import dao.memory.statusCache.login.NotLoginMsgStatusCacheDAO;
import transformer.virtualMachine.obj.memoryDAOKitVM.AccountOBJTransformer;
import transformer.virtualMachine.obj.memoryDAOKitVM.MemoryDAOKitOBJTransformer;
import virtualMachine.MemoryDAOKitVM;

public class MemoryDAOKitVMDAO {
	
	public static final String SESSION_ATTR_ACCOUNT = "account";
	public static final int REPOSITORY_UPDATE_TIME_INTERVAL_MINUTE = 15;
	
	private MemoryDAOKitVM memoryDAOKitVM;
	private AccountOBJTransformer accountOBJTransformer;
	private MemoryDAOKitOBJTransformer memoryDAOKitOBJTransformer;
	
	private static final MemoryDAOKitVMDAO INSTANCE = new MemoryDAOKitVMDAO();
	
	private MemoryDAOKitVMDAO() {
		
		memoryDAOKitVM = MemoryDAOKitVM.getInstance();
		accountOBJTransformer = AccountOBJTransformer.getInstance();
		memoryDAOKitOBJTransformer = MemoryDAOKitOBJTransformer.getInstance();
	}
	
	public static MemoryDAOKitVMDAO getInstance() {
		
		return INSTANCE;
	}
	

	public ReceiptContentCacheDAO getReceiptContentCacheDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getReceiptContentCacheDAO(), 
				getNewDAOSupReceiptContentCacheDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setReceiptContentCacheDAO(dao));
	}
	public ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getShoppingCartMemoryDbDAO(), 
				getNewDAOSupShoppingCartMemoryDbDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setShoppingCartMemoryDbDAO(dao));
	}
	public GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getGoodsTablePagesRepositoryDAO(), 
				getNewDAOSupGoodsTablePagesRepositoryDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setGoodsTablePagesRepositoryDAO(dao));
	}
	public OrderTablePagesRepositoryDAO getOrderTablePagesRepositoryDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getOrderTablePagesRepositoryDAO(), 
				getNewDAOSupOrderTablePagesRepositoryDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setOrderTablePagesRepositoryDAO(dao));
	}
	public dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getFrontendGoodsTablePagesRepositoryDAO(), 
				getNewDAOSupFrontendGoodsTablePagesRepositoryDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setFrontendGoodsTablePagesRepositoryDAO(dao));
	}
	public CurrentMemberStatusCacheDAO getCurrentMemberStatusCacheDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getCurrentMemberStatusCacheDAO(), 
				getNewDAOSupCurrentMemberStatusCacheDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setCurrentMemberStatusCacheDAO(dao));
	}
	public NotLoginMsgStatusCacheDAO getNotLoginMsgStatusCacheDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getNotLoginMsgStatusCacheDAO(), 
				getNewDAOSupNotLoginMsgStatusCacheDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setNotLoginMsgStatusCacheDAO(dao));
	}
	public CheckoutMoneyIllegalMsgStatusCacheDAO getCheckoutMoneyIllegalMsgStatusCacheDAO(AccountOBJDTO accountOBJDTO) {
		
		return getDAO(accountOBJDTO, 
				memoryDAOKitOBJDTO -> memoryDAOKitOBJDTO.getCheckoutMoneyIllegalMsgStatusCacheDAO(), 
				getNewDAOSupCheckoutMoneyIllegalMsgStatusCacheDAO(), 
				(memoryDAOKitOBJDTO, dao) -> memoryDAOKitOBJDTO.setCheckoutMoneyIllegalMsgStatusCacheDAO(dao));
	}
	
	
	
	public void requireUpdateGoodsTablePagesRepositoryDAO() {
		
		memoryDAOKitVM.requireUpdateGoodsTablePagesRepositoryDAO();
	}
	public void requireUpdateOrderTablePagesRepositoryDAO() {
		
		memoryDAOKitVM.requireUpdateOrderTablePagesRepositoryDAO();
	}
	public void requireUpdateFrontendGoodsTablePagesRepositoryDAO() {
		
		memoryDAOKitVM.requireUpdateFrontendGoodsTablePagesRepositoryDAO();
	}
	
	public static Runnable requireUpdateRunnable() {
		
		return () -> {
			
			MemoryDAOKitVMDAO memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
			while(true) {
				
				try {
					
					TimeUnit.MINUTES.sleep(REPOSITORY_UPDATE_TIME_INTERVAL_MINUTE);
					memoryDAOKitVMDAO.requireUpdateGoodsTablePagesRepositoryDAO();
					memoryDAOKitVMDAO.requireUpdateOrderTablePagesRepositoryDAO();
					memoryDAOKitVMDAO.requireUpdateFrontendGoodsTablePagesRepositoryDAO();
				} catch (InterruptedException ex) {
				}
			}
		};
	}
	
	
	private <D> D getDAO(AccountOBJDTO account, Function<MemoryDAOKitOBJDTO, D> daoGetter, Supplier<D> newDaoSup, BiConsumer<MemoryDAOKitOBJDTO, D> daoSetter) {
		
		AccountOBJ accountOBJ = accountOBJTransformer.dtoToObj(account);
		
		MemoryDAOKitOBJDTO memoryDAOKitOBJDTO = memoryDAOKitOBJTransformer.objToDto(memoryDAOKitVM.getMemoryDAOKit(accountOBJ));
		 
		if(memoryDAOKitOBJDTO == null)
			memoryDAOKitOBJDTO = new MemoryDAOKitOBJDTO();
		
		D dao = daoGetter.apply(memoryDAOKitOBJDTO);
		
		if(dao == null) {
			
			dao = newDaoSup.get();
			daoSetter.accept(memoryDAOKitOBJDTO, dao);
			memoryDAOKitVM.setMemoryDAOKit(accountOBJ, memoryDAOKitOBJTransformer.dtoToObj(memoryDAOKitOBJDTO));
		}
		
		return dao;
	}
	
	

	private Supplier<ReceiptContentCacheDAO> getNewDAOSupReceiptContentCacheDAO() {
		
		return () -> new ReceiptContentCacheDAO();
	}
	private Supplier<ShoppingCartMemoryDbDAO> getNewDAOSupShoppingCartMemoryDbDAO() {
		
		return () -> new ShoppingCartMemoryDbDAO();
	}
	private Supplier<GoodsTablePagesRepositoryDAO> getNewDAOSupGoodsTablePagesRepositoryDAO() {
		
		return () -> new GoodsTablePagesRepositoryDAO();
	}
	private Supplier<OrderTablePagesRepositoryDAO> getNewDAOSupOrderTablePagesRepositoryDAO() {
		
		return () -> new OrderTablePagesRepositoryDAO();
	}
	private Supplier<dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO> getNewDAOSupFrontendGoodsTablePagesRepositoryDAO() {
		
		return () -> new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO();
	}
	private Supplier<CurrentMemberStatusCacheDAO> getNewDAOSupCurrentMemberStatusCacheDAO() {
		
		return () -> new CurrentMemberStatusCacheDAO();
	}
	private Supplier<NotLoginMsgStatusCacheDAO> getNewDAOSupNotLoginMsgStatusCacheDAO() {
		
		return () -> new NotLoginMsgStatusCacheDAO();
	}
	private Supplier<CheckoutMoneyIllegalMsgStatusCacheDAO> getNewDAOSupCheckoutMoneyIllegalMsgStatusCacheDAO() {
		
		return () -> new CheckoutMoneyIllegalMsgStatusCacheDAO();
	}
}
