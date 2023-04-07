package transformer.vo.writeout;

import bean.dto.vo.writeout.PPageWOVODTO;
import bean.vo.writeout.PPageWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PPageWOVOTransformer extends VOWriteOutTransformerTemplate<PPageWOVODTO, PPageWOVO> {

	private static final PPageWOVOTransformer INSTANCE = new PPageWOVOTransformer();
	
	private PPageWOVOTransformer() {
	}
	
	public static PPageWOVOTransformer getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public PPageWOVO dtoToVo(PPageWOVODTO dto) {

		PPageWOVO vo = new PPageWOVO();
		
		vo.setPage(String.valueOf(dto.getPage()));
		vo.setUrl(dto.getUrl());
		
		return vo;
	}

}
