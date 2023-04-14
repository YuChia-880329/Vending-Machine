package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BGUUFGoodsWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateFormGoodsVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUFGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUFGoodsWOVODTO, UpdateFormGoodsVO> {

	private static final BGUUFGoodsWOVOTransformer INSTANCE = new BGUUFGoodsWOVOTransformer();
	
	private BGUUFGoodsWOVOTransformer() {
	}
	
	public static BGUUFGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public UpdateFormGoodsVO dtoToVo(BGUUFGoodsWOVODTO dto) {
		
		UpdateFormGoodsVO vo = new UpdateFormGoodsVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setStatus(dto.getStatus().getDescription());
		
		return vo;
	}
}
