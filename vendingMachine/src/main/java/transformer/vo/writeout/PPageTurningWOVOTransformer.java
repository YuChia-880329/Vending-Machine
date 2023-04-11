package transformer.vo.writeout;

import bean.dto.vo.writeout.PageTurningVODTO;
import bean.vo.writeout.PageTurningVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PPageTurningWOVOTransformer extends VOWriteOutTransformerTemplate<PageTurningVODTO, PageTurningVO> {

	private static final PPageTurningWOVOTransformer INSTANCE = new PPageTurningWOVOTransformer();
	
	private PPageTurningWOVOTransformer() {
	}
	
	public static PPageTurningWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PageTurningVO dtoToVo(PageTurningVODTO dto) {

		PageTurningVO vo = new PageTurningVO();
		
		vo.setExistence(dto.getExistence().getDescription());
		vo.setUrl(dto.getUrl());
		
		return vo;
	}
}
