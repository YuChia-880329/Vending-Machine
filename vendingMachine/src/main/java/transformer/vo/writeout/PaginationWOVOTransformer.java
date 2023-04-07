package transformer.vo.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;
import bean.vo.writeout.PaginationWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PaginationWOVOTransformer extends VOWriteOutTransformerTemplate<PaginationWOVODTO, PaginationWOVO> {

	private PPageTurningWOVOTransformer pPageTurningWOVOTransformer;
	private PPageWOVOTransformer pPageWOVOTransformer;
	
	
	private static final PaginationWOVOTransformer INSTANCE = new PaginationWOVOTransformer();
	
	private PaginationWOVOTransformer() {
		
		pPageTurningWOVOTransformer = PPageTurningWOVOTransformer.getInstance();
		pPageWOVOTransformer = PPageWOVOTransformer.getInstance();
	}
	
	public static PaginationWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PaginationWOVO dtoToVo(PaginationWOVODTO dto) {

		PaginationWOVO vo = new PaginationWOVO();
		
		vo.setPreviousPage(pPageTurningWOVOTransformer.dtoToVo(dto.getPreviousPage()));
		vo.setPages(pPageWOVOTransformer.dtoListToVoList(dto.getPages()));
		vo.setNextPage(pPageTurningWOVOTransformer.dtoToVo(dto.getNextPage()));
		
		return vo;
	}
}
