package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FSCGoodsWOVODTO;
import bean.vo.frontend.writeout.FSCGoodsWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FSCGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<FSCGoodsWOVODTO, FSCGoodsWOVO> {

	private static final FSCGoodsWOVOTransformer INSTANCE = new FSCGoodsWOVOTransformer();
	
	private FSCGoodsWOVOTransformer() {
	}
	
	public static FSCGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FSCGoodsWOVO dtoToVo(FSCGoodsWOVODTO dto) {

		FSCGoodsWOVO vo = new FSCGoodsWOVO();
		
		vo.setName(dto.getName());
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		vo.setPrice(String.valueOf(dto.getPrice()));
		
		return vo;
	}
}
