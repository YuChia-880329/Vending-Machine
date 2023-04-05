package transformer.vo.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;
import bean.vo.writeout.PaginationWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PaginationWOVOTransformer extends VOWriteOutTransformerTemplate<PaginationWOVODTO, PaginationWOVO> {

	private PPageWOVOTransformer pPageWOVOTransformer;
	
	private static final PaginationWOVOTransformer INSTANCE = new PaginationWOVOTransformer();
	
	private PaginationWOVOTransformer() {
		
		pPageWOVOTransformer = PPageWOVOTransformer.getInstance();
	}
	
	public static PaginationWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PaginationWOVO dtoToVo(PaginationWOVODTO dto) {

		PaginationWOVO vo = new PaginationWOVO();
		
		vo.setHasPreviousPage(dto.getHasPreviousPage().getDescription());
		vo.setPages(pPageWOVOTransformer.dtoListToVoList(dto.getPages()));
		vo.setHasNextPage(dto.getHasNextPage().getDescription());
		
		return vo;
	}
}
