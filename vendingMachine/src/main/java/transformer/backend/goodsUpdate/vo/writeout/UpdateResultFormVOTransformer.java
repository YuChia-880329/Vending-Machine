package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultFormVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateResultFormVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateResultFormVOTransformer extends VOWriteOutTransformerTemplate<UpdateResultFormVODTO, UpdateResultFormVO> {

	private static final UpdateResultFormVOTransformer INSTANCE = new UpdateResultFormVOTransformer();
	
	private UpdateResultFormVOTransformer() {
	}
	
	public static UpdateResultFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateResultFormVO dtoToVoTransform(UpdateResultFormVODTO dto) {
		
		UpdateResultFormVO vo = new UpdateResultFormVO();
		
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		
		return vo;
	}
}
