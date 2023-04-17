package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FRBoughtGoodsWOVODTO;
import bean.vo.frontend.writeout.FRBoughtGoodsWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FRBoughtGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<FRBoughtGoodsWOVODTO, FRBoughtGoodsWOVO> {

	private static final FRBoughtGoodsWOVOTransformer INSTANCE = new FRBoughtGoodsWOVOTransformer();
	
	private FRBoughtGoodsWOVOTransformer() {
	}
	
	public static FRBoughtGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FRBoughtGoodsWOVO dtoToVoTransform(FRBoughtGoodsWOVODTO dto) {

		FRBoughtGoodsWOVO vo = new FRBoughtGoodsWOVO();
		
		vo.setName(dto.getName());
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		
		return vo;
	}
}
