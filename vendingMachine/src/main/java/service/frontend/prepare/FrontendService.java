package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.dto.model.MemberModelDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;

public class FrontendService {

	private AddShoppingCartIllegalMsgService addShoppingCartIllegalMsgService;
	private ClearShoppingCartMsgService clearShoppingCartMsgService;
	private ShoppingCartService shoppingCartService;
	private WelcomePartService welcomePartService;
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;
	
	
	private static final FrontendService INSTANCE = new FrontendService();
	
	private FrontendService() {
		
		addShoppingCartIllegalMsgService = AddShoppingCartIllegalMsgService.getInstance();
		clearShoppingCartMsgService = ClearShoppingCartMsgService.getInstance();
		shoppingCartService = ShoppingCartService.getInstance();
		welcomePartService = WelcomePartService.getInstance();
		goodsTablePageService = GoodsTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
	}
	
	public static FrontendService getInstance() {
		
		return INSTANCE;
	}
	
	
	public FrontendVODTO prepare(PageParameterVODTO pageParameterVODTO, 
			String imagesDirectorySymbolicLinkName, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, 
			MemberModelDTO memberModelDTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, AddShoppingCartIllegalMsgCacheDAO addShoppingCartIllegalMsgCacheDAO, 
			ClearShoppingCartMsgCacheDAO clearShoppingCartMsgCacheDAO) {
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		FrontendVODTO frontendVODTO = new FrontendVODTO();
		
		frontendVODTO.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgService.prepare(addShoppingCartIllegalMsgCacheDAO));
		frontendVODTO.setClearShoppingCartMsg(clearShoppingCartMsgService.prepare(clearShoppingCartMsgCacheDAO));
		frontendVODTO.setShoppingCart(shoppingCartService.prepare(shoppingCartMemoryDbDAO));
		frontendVODTO.setWelcomePart(welcomePartService.prepare(imagesDirectorySymbolicLinkName, memberModelDTO));
		frontendVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, 
				shoppingCartMemoryDbDAO, imagesDirectorySymbolicLinkName));
		frontendVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		
		return frontendVODTO;
	}
}
