package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BackendGoodsUpdateVODTO;
import bean.vo.backend.goodsUpdate.writeout.BackendGoodsUpdateVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsUpdateVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsUpdateVODTO, BackendGoodsUpdateVO> {

	private UpdateFormVOTransformer updateFormVOTransformer;
	
	private static final BackendGoodsUpdateVOTransformer INSTANCE = new BackendGoodsUpdateVOTransformer();
	
	private BackendGoodsUpdateVOTransformer() {
		
		updateFormVOTransformer = UpdateFormVOTransformer.getInstance();
	}
	
	public static BackendGoodsUpdateVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BackendGoodsUpdateVO dtoToVoTransform(BackendGoodsUpdateVODTO dto) {

		BackendGoodsUpdateVO vo = new BackendGoodsUpdateVO();
		
		vo.setUpdateForm(updateFormVOTransformer.dtoToVo(dto.getUpdateForm()));
		
		return vo;
	}
}
