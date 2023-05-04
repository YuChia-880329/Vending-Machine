package transformer.login.vo.writeout;

import bean.dto.login.vo.writeout.BackgroundVODTO;
import bean.vo.login.writeout.BackgroundVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackgroundVOTransformer extends VOWriteOutTransformerTemplate<BackgroundVODTO, BackgroundVO> {

	private static final BackgroundVOTransformer INSTANCE = new BackgroundVOTransformer();
	
	private BackgroundVOTransformer() {
	}
	
	public static BackgroundVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BackgroundVO dtoToVoTransform(BackgroundVODTO dto) {
		
		BackgroundVO vo = new BackgroundVO();
		
		vo.setImagePath(dto.getImagePath());
		
		return vo;
	}
}
