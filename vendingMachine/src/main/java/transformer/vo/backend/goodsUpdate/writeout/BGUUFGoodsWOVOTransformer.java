package transformer.vo.backend.goodsUpdate.writeout;

import bean.dto.vo.backend.goodsUpdate.writeout.BGUUFGoodsWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BGUUFGoodsWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUFGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUFGoodsWOVODTO, BGUUFGoodsWOVO> {

	private static final BGUUFGoodsWOVOTransformer INSTANCE = new BGUUFGoodsWOVOTransformer();
	
	private BGUUFGoodsWOVOTransformer() {
	}
	
	public static BGUUFGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUUFGoodsWOVO dtoToVo(BGUUFGoodsWOVODTO dto) {
		
		BGUUFGoodsWOVO vo = new BGUUFGoodsWOVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setStatus(dto.getStatus().getDescription());
		
		return vo;
	}
}
