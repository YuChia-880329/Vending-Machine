package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BackendGoodsUpdateWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BackendGoodsUpdateVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsUpdateWOVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsUpdateWOVODTO, BackendGoodsUpdateVO> {

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
	public BackendGoodsUpdateVO dtoToVo(BackendGoodsUpdateWOVODTO dto) {

		BackendGoodsUpdateVO vo = new BackendGoodsUpdateVO();
		
		vo.setUpdateMsg(bguUpdateMsgWOVOTransformer.dtoToVo(dto.getUpdateMsg()));
		vo.setUpdateForm(bguUpdateFormWOVOTransformer.dtoToVo(dto.getUpdateForm()));
		
		return vo;
	}
}
