package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoFrontendService {

	private AddShoppingCartIllegalMsgService addShoppingCartIllegalMsgService;
	private AddShoppingCartMsgService addShoppingCartMsgService;
	private ClearShoppingCartMsgService clearShoppingCartMsgService;
	private UpdateShoppingCartIllegalMsgService updateShoppingCartIllegalMsgService;
	private UpdateShoppingCartMsgService updateShoppingCartMsgService;
	private CheckoutMoneyIllegalMsgService checkoutMoneyIllegalMsgService;
	private ShoppingCartService shoppingCartService;
	private WelcomePartService welcomePartService;
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;
	private ReceiptService receiptService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final GoFrontendService INSTANCE = new GoFrontendService();
	
	private GoFrontendService() {
		
		addShoppingCartIllegalMsgService = AddShoppingCartIllegalMsgService.getInstance();
		addShoppingCartMsgService = AddShoppingCartMsgService.getInstance();
		clearShoppingCartMsgService = ClearShoppingCartMsgService.getInstance();
		updateShoppingCartIllegalMsgService = UpdateShoppingCartIllegalMsgService.getInstance();
		updateShoppingCartMsgService = UpdateShoppingCartMsgService.getInstance();
		checkoutMoneyIllegalMsgService = CheckoutMoneyIllegalMsgService.getInstance();
		shoppingCartService = ShoppingCartService.getInstance();
		welcomePartService = WelcomePartService.getInstance();
		goodsTablePageService = GoodsTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
		receiptService = ReceiptService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoFrontendService getInstance() {
		
		return INSTANCE;
	}
	
	
	public FrontendVODTO prepare(PageParameterVODTO pageParameterVODTO, 
			String imagesDirectoryName, AccountOBJDTO accountOBJDTO) {
		
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartMsgLineCacheDAO(accountOBJDTO);
		ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO = memoryDAOKitVMDAO.getClearShoppingCartMsgStatusCacheDAO(accountOBJDTO);
		UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getUpdateShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO = memoryDAOKitVMDAO.getUpdateShoppingCartMsgLineCacheDAO(accountOBJDTO);
		CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO = memoryDAOKitVMDAO.getCheckoutMoneyIllegalMsgStatusCacheDAO(accountOBJDTO);
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = memoryDAOKitVMDAO.getFrontendGoodsTablePagesRepositoryDAO(accountOBJDTO);
		ReceiptContentCacheDAO receiptContentCacheDAO = memoryDAOKitVMDAO.getReceiptContentCacheDAO(accountOBJDTO);
		CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO = memoryDAOKitVMDAO.getCurrentMemberStatusCacheDAO(accountOBJDTO);
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		FrontendVODTO frontendVODTO = new FrontendVODTO();
		
		frontendVODTO.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgService.prepare(addShoppingCartIllegalMsgLineCacheDAO));
		frontendVODTO.setAddShoppingCartMsg(addShoppingCartMsgService.prepare(addShoppingCartMsgLineCacheDAO));
		frontendVODTO.setClearShoppingCartMsg(clearShoppingCartMsgService.prepare(clearShoppingCartMsgStatusCacheDAO));
		frontendVODTO.setUpdateShoppingCartIllegalMsg(updateShoppingCartIllegalMsgService.prepare(updateShoppingCartIllegalMsgLineCacheDAO));
		frontendVODTO.setUpdateShoppingCartMsg(updateShoppingCartMsgService.prepare(updateShoppingCartMsgLineCacheDAO));
		frontendVODTO.setCheckoutMoneyIllegalMsg(checkoutMoneyIllegalMsgService.prepare(checkoutMoneyIllegalMsgStatusCacheDAO));
		frontendVODTO.setShoppingCart(shoppingCartService.prepare(shoppingCartMemoryDbDAO));
		frontendVODTO.setWelcomePart(welcomePartService.prepare(imagesDirectoryName, currentMemberStatusCacheDAO));
		frontendVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, shoppingCartMemoryDbDAO, imagesDirectoryName));
		frontendVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		frontendVODTO.setReceipt(receiptService.prepare(receiptContentCacheDAO));
		
		return frontendVODTO;
	}
}
