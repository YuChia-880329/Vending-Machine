package transformer.vo.writeout;

import bean.dto.vo.writeout.PaginationVODTO;
import bean.vo.writeout.PaginationVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PaginationWOVOTransformer extends VOWriteOutTransformerTemplate<PaginationVODTO, PaginationVO> {

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
	public PaginationVO dtoToVo(PaginationVODTO dto) {

		PaginationVO vo = new PaginationVO();
		
		vo.setPreviousPage(pPageTurningWOVOTransformer.dtoToVo(dto.getPreviousPage()));
		vo.setPages(pPageWOVOTransformer.dtoListToVoList(dto.getPages()));
		vo.setNextPage(pPageTurningWOVOTransformer.dtoToVo(dto.getNextPage()));
		
		return vo;
	}
}
