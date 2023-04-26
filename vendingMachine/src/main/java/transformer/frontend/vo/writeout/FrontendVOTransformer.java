package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.vo.frontend.writeout.FrontendVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FrontendVOTransformer extends VOWriteOutTransformerTemplate<FrontendVODTO, FrontendVO> {

	private AddShoppingCartIllegalMsgVOTransformer addShoppingCartIllegalMsgVOTransformer;
	private AddShoppingCartMsgVOTransformer addShoppingCartMsgVOTransformer;
	private ClearShoppingCartMsgVOTransformer clearShoppingCartMsgVOTransformer;
	private ShoppingCartVOTransformer shoppingCartVOTransformer;
	private WelcomePartVOTransformer welcomePartVOTransformer;
	private GoodsTablePageVOTransformer goodsTablePageVOTransformer;
	private FilterFormVOTransformer filterFormVOTransformer;
	
	
	private static final FrontendVOTransformer INSTANCE = new FrontendVOTransformer();
	
	private FrontendVOTransformer() {
		
		addShoppingCartIllegalMsgVOTransformer = AddShoppingCartIllegalMsgVOTransformer.getInstance();
		addShoppingCartMsgVOTransformer = AddShoppingCartMsgVOTransformer.getInstance();
		clearShoppingCartMsgVOTransformer = ClearShoppingCartMsgVOTransformer.getInstance();
		shoppingCartVOTransformer = ShoppingCartVOTransformer.getInstance();
		welcomePartVOTransformer = WelcomePartVOTransformer.getInstance();
		goodsTablePageVOTransformer = GoodsTablePageVOTransformer.getInstance();
		filterFormVOTransformer = FilterFormVOTransformer.getInstance();
	}
	
	public static FrontendVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FrontendVO dtoToVoTransform(FrontendVODTO dto) {

		FrontendVO vo = new FrontendVO();
		
		vo.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgVOTransformer.dtoToVo(dto.getAddShoppingCartIllegalMsg()));
		vo.setAddShoppingCartMsg(addShoppingCartMsgVOTransformer.dtoToVo(dto.getAddShoppingCartMsg()));
		vo.setClearShoppingCartMsg(clearShoppingCartMsgVOTransformer.dtoToVo(dto.getClearShoppingCartMsg()));
		vo.setShoppingCart(shoppingCartVOTransformer.dtoToVo(dto.getShoppingCart()));
		vo.setWelcomePart(welcomePartVOTransformer.dtoToVo(dto.getWelcomePart()));
		vo.setGoodsTablePage(goodsTablePageVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		vo.setFilterForm(filterFormVOTransformer.dtoToVo(dto.getFilterForm()));
		
		return vo;
	}
}
