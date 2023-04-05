package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FrontendWOVODTO;
import bean.vo.frontend.writeout.FrontendWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class FrontendWOVOTransformer extends VOWriteOutTransformerTemplate<FrontendWOVODTO, FrontendWOVO> {

	private FWelcomeMsgWOVOTransformer fWelcomeMsgWOVOTransformer;
	private FReceiptWOVOTransformer fReceiptWOVOTransformer;
	private FGoodsTableWOVOTransformer fGoodsTableWOVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final FrontendWOVOTransformer INSTANCE = new FrontendWOVOTransformer();
	
	private FrontendWOVOTransformer() {
		
		fWelcomeMsgWOVOTransformer = FWelcomeMsgWOVOTransformer.getInstance();
		fReceiptWOVOTransformer = FReceiptWOVOTransformer.getInstance();
		fGoodsTableWOVOTransformer = FGoodsTableWOVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static FrontendWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FrontendWOVO dtoToVo(FrontendWOVODTO dto) {

		FrontendWOVO vo = new FrontendWOVO();
		
		vo.setWelcomeMsg(fWelcomeMsgWOVOTransformer.dtoToVo(dto.getWelcomeMsg()));
		vo.setReceipt(fReceiptWOVOTransformer.dtoToVo(dto.getReceipt()));
		vo.setGoodsTable(fGoodsTableWOVOTransformer.dtoToVo(dto.getGoodsTable()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
