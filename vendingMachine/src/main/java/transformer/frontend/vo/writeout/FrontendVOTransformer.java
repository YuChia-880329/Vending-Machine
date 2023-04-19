package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.vo.frontend.writeout.FrontendVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class FrontendVOTransformer extends VOWriteOutTransformerTemplate<FrontendVODTO, FrontendVO> {

	private WelcomePartVOTransformer welcomePartVOTransformer;
	private GoodsTablePageVOTransformer goodsTablePageVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final FrontendVOTransformer INSTANCE = new FrontendVOTransformer();
	
	private FrontendVOTransformer() {
		
		welcomePartVOTransformer = WelcomePartVOTransformer.getInstance();
		goodsTablePageVOTransformer = GoodsTablePageVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static FrontendVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FrontendVO dtoToVoTransform(FrontendVODTO dto) {

		FrontendVO vo = new FrontendVO();
		
		vo.setWelcomePart(welcomePartVOTransformer.dtoToVo(dto.getWelcomePart()));
		vo.setGoodsTablePage(goodsTablePageVOTransformer.dtoToVo(dto.getGoodsTablePage()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
