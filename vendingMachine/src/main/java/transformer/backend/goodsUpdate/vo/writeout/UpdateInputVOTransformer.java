package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateInputVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateInputVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateInputVOTransformer extends VOWriteOutTransformerTemplate<UpdateInputVODTO, UpdateInputVO> {

	private UpdateFormGoodsVOTransformer updateFormGoodsVOTransformer;
	
	
	private static final UpdateInputVOTransformer INSTANCE = new UpdateInputVOTransformer();
	
	private UpdateInputVOTransformer() {
		
		updateFormGoodsVOTransformer = UpdateFormGoodsVOTransformer.getInstance();
	}
	
	public static UpdateInputVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public UpdateInputVO dtoToVo(UpdateInputVODTO dto) {

		UpdateInputVO vo = new UpdateInputVO();
		
		vo.setUpdateFormGoods(updateFormGoodsVOTransformer.dtoToVo(dto.getUpdateFormGoods()));
		
		return vo;
	}

}
