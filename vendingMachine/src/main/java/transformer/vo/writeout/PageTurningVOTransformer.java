package transformer.vo.writeout;

import bean.dto.vo.writeout.PageTurningVODTO;
import bean.vo.writeout.PageTurningVO;
import enumeration.Has;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PageTurningVOTransformer extends VOWriteOutTransformerTemplate<PageTurningVODTO, PageTurningVO> {

	private static final PageTurningVOTransformer INSTANCE = new PageTurningVOTransformer();
	
	private PageTurningVOTransformer() {
	}
	
	public static PageTurningVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected PageTurningVO dtoToVoTransform(PageTurningVODTO dto) {

		PageTurningVO vo = new PageTurningVO();
		
		Has existence = dto.getExistence();
		vo.setExistence(existence==null ? Has.FALSE.getDescription() : existence.getDescription());
		vo.setUrl(dto.getUrl());
		
		return vo;
	}
}
