package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.vo.frontend.writeout.FrontendVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FrontendVOTransformer extends VOWriteOutTransformerTemplate<FrontendVODTO, FrontendVO> {

	private ShoppingCartVOTransformer shoppingCartVOTransformer;
	private WelcomePartVOTransformer welcomePartVOTransformer;
	private GoodsTablePageVOTransformer goodsTablePageVOTransformer;
	private FilterFormVOTransformer filterFormVOTransformer;
	private ReceiptVOTransformer receiptVOTransformer;
	
	
	private static final FrontendVOTransformer INSTANCE = new FrontendVOTransformer();
	
	private FrontendVOTransformer() {
		
		shoppingCartVOTransformer = ShoppingCartVOTransformer.getInstance();
		welcomePartVOTransformer = WelcomePartVOTransformer.getInstance();
		goodsTablePageVOTransformer = GoodsTablePageVOTransformer.getInstance();
		filterFormVOTransformer = FilterFormVOTransformer.getInstance();
		receiptVOTransformer = ReceiptVOTransformer.getInstance();
	}
	
	public static FrontendVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FrontendVO dtoToVoTransform(FrontendVODTO dto) {

		FrontendVO vo = new FrontendVO();

		vo.setShoppingCart(shoppingCartVOTransformer.dtoToVo(dto.getShoppingCart()));
		vo.setWelcomePart(welcomePartVOTransformer.dtoToVo(dto.getWelcomePart()));
		vo.setGoodsTablePage(goodsTablePageVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		vo.setFilterForm(filterFormVOTransformer.dtoToVo(dto.getFilterForm()));
		vo.setReceipt(receiptVOTransformer.dtoToVo(dto.getReceipt()));
		
		return vo;
	}
}
