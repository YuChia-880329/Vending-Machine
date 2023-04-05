package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BGLGTGoodsWOVODTO;
import bean.vo.backend.goodsList.writeout.BGLGTGoodsWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGLGTGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<BGLGTGoodsWOVODTO, BGLGTGoodsWOVO> {

	private static final BGLGTGoodsWOVOTransformer INSTANCE = new BGLGTGoodsWOVOTransformer();
	
	private BGLGTGoodsWOVOTransformer() {
	}
	
	public static BGLGTGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGTGoodsWOVO dtoToVo(BGLGTGoodsWOVODTO dto) {
		
		BGLGTGoodsWOVO vo = new BGLGTGoodsWOVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(String.valueOf(dto.getName()));
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setStatus(dto.getStatus().getDescription());
		
		return vo;
	}
}
