package transformer.vo.backend.goodsCreate.writeout;

import bean.dto.vo.backend.goodsCreate.writeout.BackendGoodsCreateWOVODTO;
import bean.vo.backend.goodsCreate.writeout.BackendGoodsCreateWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendGoodsCreateWOVOTransformer extends VOWriteOutTransformerTemplate<BackendGoodsCreateWOVODTO, BackendGoodsCreateWOVO> {

	private BGCCreateMsgWOVOTransformer bgcCreateMsgWOVOTransformer;
	
	
	private static final BackendGoodsCreateWOVOTransformer INSTANCE = new BackendGoodsCreateWOVOTransformer();
	
	private BackendGoodsCreateWOVOTransformer() {
		
		bgcCreateMsgWOVOTransformer = BGCCreateMsgWOVOTransformer.getInstance();
	}
	
	public static BackendGoodsCreateWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendGoodsCreateWOVO dtoToVo(BackendGoodsCreateWOVODTO dto) {

		BackendGoodsCreateWOVO vo = new BackendGoodsCreateWOVO();
		
		vo.setCreateMsg(bgcCreateMsgWOVOTransformer.dtoToVo(dto.getCreateMsg()));
		
		return vo;
	}
}
