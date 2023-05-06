package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoFrontendService {

	private ShoppingCartService shoppingCartService;
	private WelcomePartService welcomePartService;
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;
	private ReceiptService receiptService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final GoFrontendService INSTANCE = new GoFrontendService();
	
	private GoFrontendService() {
		
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
		
		frontendVODTO.setShoppingCart(shoppingCartService.prepare(shoppingCartMemoryDbDAO));
		frontendVODTO.setWelcomePart(welcomePartService.prepare(imagesDirectoryName, currentMemberStatusCacheDAO));
		frontendVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, shoppingCartMemoryDbDAO, imagesDirectoryName));
		frontendVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		frontendVODTO.setReceipt(receiptService.prepare(receiptContentCacheDAO));
		
		return frontendVODTO;
	}
}
