package transformer.vo.backend.goodsUpdate.writeout;

import bean.dto.vo.backend.goodsUpdate.writeout.BackendGoodsUpdateWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BackendGoodsUpdateWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsUpdateWOVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsUpdateWOVODTO, BackendGoodsUpdateWOVO> {

	private BGUUpdateMsgWOVOTransformer bguUpdateMsgWOVOTransformer;
	private BGUUpdateFormWOVOTransformer bguUpdateFormWOVOTransformer;
	
	private static final BackendGoodsUpdateWOVOTransformer INSTANCE = new BackendGoodsUpdateWOVOTransformer();
	
	private BackendGoodsUpdateWOVOTransformer() {
		
		bguUpdateMsgWOVOTransformer = BGUUpdateMsgWOVOTransformer.getInstance();
		bguUpdateFormWOVOTransformer = BGUUpdateFormWOVOTransformer.getInstance();
	}
	
	public static BackendGoodsUpdateWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendGoodsUpdateWOVO dtoToVo(BackendGoodsUpdateWOVODTO dto) {

		BackendGoodsUpdateWOVO vo = new BackendGoodsUpdateWOVO();
		
		vo.setUpdateMsg(bguUpdateMsgWOVOTransformer.dtoToVo(dto.getUpdateMsg()));
		vo.setUpdateForm(bguUpdateFormWOVOTransformer.dtoToVo(dto.getUpdateForm()));
		
		return vo;
	}
}
