package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.dto.model.MemberModelDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;

public class FrontendService {

	private AddShoppingCartIllegalMsgService addShoppingCartIllegalMsgService;
	private AddShoppingCartMsgService addShoppingCartMsgService;
	private ClearShoppingCartMsgService clearShoppingCartMsgService;
	private UpdateShoppingCartIllegalMsgService updateShoppingCartIllegalMsgService;
	private UpdateShoppingCartMsgService updateShoppingCartMsgService;
	private ShoppingCartService shoppingCartService;
	private WelcomePartService welcomePartService;
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;
	private ReceiptService receiptService;
	
	
	private static final FrontendService INSTANCE = new FrontendService();
	
	private FrontendService() {
		
		addShoppingCartIllegalMsgService = AddShoppingCartIllegalMsgService.getInstance();
		addShoppingCartMsgService = AddShoppingCartMsgService.getInstance();
		clearShoppingCartMsgService = ClearShoppingCartMsgService.getInstance();
		updateShoppingCartIllegalMsgService = UpdateShoppingCartIllegalMsgService.getInstance();
		updateShoppingCartMsgService = UpdateShoppingCartMsgService.getInstance();
		shoppingCartService = ShoppingCartService.getInstance();
		welcomePartService = WelcomePartService.getInstance();
		goodsTablePageService = GoodsTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
		receiptService = ReceiptService.getInstance();
	}
	
	public static FrontendService getInstance() {
		
		return INSTANCE;
	}
	
	
	public FrontendVODTO prepare(PageParameterVODTO pageParameterVODTO, 
			MemberModelDTO memberModelDTO, 
			String imagesDirectorySymbolicLinkName, 
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO, 
			AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO,
			ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO,
			UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO,
			UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO,
			ReceiptContentCacheDAO receiptContentCacheDAO) {
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		FrontendVODTO frontendVODTO = new FrontendVODTO();
		
		frontendVODTO.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgService.prepare(addShoppingCartIllegalMsgLineCacheDAO));
		frontendVODTO.setAddShoppingCartMsg(addShoppingCartMsgService.prepare(addShoppingCartMsgLineCacheDAO));
		frontendVODTO.setClearShoppingCartMsg(clearShoppingCartMsgService.prepare(clearShoppingCartMsgLineCacheDAO));
		frontendVODTO.setUpdateShoppingCartIllegalMsg(updateShoppingCartIllegalMsgService.prepare(updateShoppingCartIllegalMsgLineCacheDAO));
		frontendVODTO.setUpdateShoppingCartMsg(updateShoppingCartMsgService.prepare(updateShoppingCartMsgLineCacheDAO));
		frontendVODTO.setShoppingCart(shoppingCartService.prepare(shoppingCartMemoryDbDAO));
		frontendVODTO.setWelcomePart(welcomePartService.prepare(imagesDirectorySymbolicLinkName, memberModelDTO));
		frontendVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, 
				shoppingCartMemoryDbDAO, imagesDirectorySymbolicLinkName));
		frontendVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		frontendVODTO.setReceipt(receiptService.prepare(receiptContentCacheDAO));
		
		return frontendVODTO;
	}
}
