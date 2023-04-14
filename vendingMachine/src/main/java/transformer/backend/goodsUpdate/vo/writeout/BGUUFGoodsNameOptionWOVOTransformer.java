package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BGUUFGoodsNameOptionWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.GoodsNameOptionVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUFGoodsNameOptionWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUFGoodsNameOptionWOVODTO, GoodsNameOptionVO> {

	private static final BGUUFGoodsNameOptionWOVOTransformer INSTANCE = new BGUUFGoodsNameOptionWOVOTransformer();
	
	private BGUUFGoodsNameOptionWOVOTransformer() {
	}
	
	public static BGUUFGoodsNameOptionWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsNameOptionVO dtoToVo(BGUUFGoodsNameOptionWOVODTO dto) {

		GoodsNameOptionVO vo = new GoodsNameOptionVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(dto.getName());
		
		return vo;
	}
}
