package transformer.vo.writeout;

import bean.dto.vo.writeout.PageVODTO;
import bean.vo.writeout.PageVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PPageWOVOTransformer extends VOWriteOutTransformerTemplate<PageVODTO, PageVO> {

	private static final PPageWOVOTransformer INSTANCE = new PPageWOVOTransformer();
	
	private PPageWOVOTransformer() {
	}
	
	public static PPageWOVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public PageVO dtoToVo(PageVODTO dto) {

		PageVO vo = new PageVO();
		
		vo.setPage(String.valueOf(dto.getPage()));
		vo.setUrl(dto.getUrl());
		
		return vo;
	}

}
