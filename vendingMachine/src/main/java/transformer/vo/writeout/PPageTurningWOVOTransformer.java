package transformer.vo.writeout;

import bean.dto.vo.writeout.PPageTurningWOVODTO;
import bean.vo.writeout.PPageTurningWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PPageTurningWOVOTransformer extends VOWriteOutTransformerTemplate<PPageTurningWOVODTO, PPageTurningWOVO> {

	private static final PPageTurningWOVOTransformer INSTANCE = new PPageTurningWOVOTransformer();
	
	private PPageTurningWOVOTransformer() {
	}
	
	public static PPageTurningWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PPageTurningWOVO dtoToVo(PPageTurningWOVODTO dto) {

		PPageTurningWOVO vo = new PPageTurningWOVO();
		
		vo.setExistence(dto.getExistence().getDescription());
		vo.setUrl(dto.getUrl());
		
		return vo;
	}
}
