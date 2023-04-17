package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FrontendShoppingCartWOVODTO;
import bean.vo.frontend.writeout.FrontendShoppingCartWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FrontendShoppingCartWOVOTransformer extends VOWriteOutTransformerTemplate<FrontendShoppingCartWOVODTO, FrontendShoppingCartWOVO> {

	private FSCGoodsWOVOTransformer fscGoodsWOVOTransformer;
	
	
	private static final FrontendShoppingCartWOVOTransformer INSTANCE = new FrontendShoppingCartWOVOTransformer();
	
	private FrontendShoppingCartWOVOTransformer() {
		
		fscGoodsWOVOTransformer = FSCGoodsWOVOTransformer.getInstance();
	}
	
	public static FrontendShoppingCartWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FrontendShoppingCartWOVO dtoToVoTransform(FrontendShoppingCartWOVODTO dto) {

		FrontendShoppingCartWOVO vo = new FrontendShoppingCartWOVO();
		
		vo.setGoods(fscGoodsWOVOTransformer.dtoListToVoList(dto.getGoods()));
		
		return vo;
	}
}
