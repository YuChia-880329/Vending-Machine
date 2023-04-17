package transformer.vo.writeout;

import bean.dto.vo.writeout.PageVODTO;
import bean.vo.writeout.PageVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PageVOTransformer extends VOWriteOutTransformerTemplate<PageVODTO, PageVO> {

	private static final PageVOTransformer INSTANCE = new PageVOTransformer();
	
	private PageVOTransformer() {
	}
	
	public static PageVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	protected PageVO dtoToVoTransform(PageVODTO dto) {

		PageVO vo = new PageVO();
		
		vo.setPage(String.valueOf(dto.getPage()));
		vo.setUrl(dto.getUrl());
		
		return vo;
	}

}
