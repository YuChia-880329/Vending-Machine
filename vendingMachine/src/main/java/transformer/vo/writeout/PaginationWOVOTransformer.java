package transformer.vo.writeout;

import bean.dto.vo.writeout.PaginationVODTO;
import bean.vo.writeout.PageVO;
import bean.vo.writeout.PaginationVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PaginationWOVOTransformer extends VOWriteOutTransformerTemplate<PaginationVODTO, PaginationVO> {

	private PageTurningVOTransformer pageTurningVOTransformer;
	private PageVOTransformer pageVOTransformer;
	
	
	private static final PaginationWOVOTransformer INSTANCE = new PaginationWOVOTransformer();
	
	private PaginationWOVOTransformer() {
		
		pageTurningVOTransformer = PageTurningVOTransformer.getInstance();
		pageVOTransformer = PageVOTransformer.getInstance();
	}
	
	public static PaginationWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected PaginationVO dtoToVoTransform(PaginationVODTO dto) {

		PaginationVO vo = new PaginationVO();
		
		vo.setPreviousPage(pageTurningVOTransformer.dtoToVo(dto.getPreviousPage()));
		vo.setPages(pageVOTransformer.dtoListToVoArray(dto.getPages(), size -> new PageVO[size]));
		vo.setNextPage(pageTurningVOTransformer.dtoToVo(dto.getNextPage()));
		
		return vo;
	}
}
