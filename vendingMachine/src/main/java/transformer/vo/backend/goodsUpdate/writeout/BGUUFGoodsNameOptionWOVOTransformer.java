package transformer.vo.backend.goodsUpdate.writeout;

import bean.dto.vo.backend.goodsUpdate.writeout.BGUUFGoodsNameOptionWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BGUUFGoodsNameOptionWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUFGoodsNameOptionWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUFGoodsNameOptionWOVODTO, BGUUFGoodsNameOptionWOVO> {

	private static final BGUUFGoodsNameOptionWOVOTransformer INSTANCE = new BGUUFGoodsNameOptionWOVOTransformer();
	
	private BGUUFGoodsNameOptionWOVOTransformer() {
	}
	
	public static BGUUFGoodsNameOptionWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUUFGoodsNameOptionWOVO dtoToVo(BGUUFGoodsNameOptionWOVODTO dto) {

		BGUUFGoodsNameOptionWOVO vo = new BGUUFGoodsNameOptionWOVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(dto.getName());
		
		return vo;
	}
}
