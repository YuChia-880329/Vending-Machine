package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FGTGoodsWOVODTO;
import bean.vo.frontend.writeout.FGTGoodsWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FGTGoodsWOVOTransformer extends VOWriteOutTransformerTemplate<FGTGoodsWOVODTO, FGTGoodsWOVO> {

	private static final FGTGoodsWOVOTransformer INSTANCE = new FGTGoodsWOVOTransformer();
	
	private FGTGoodsWOVOTransformer() {
	}
	
	public static FGTGoodsWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FGTGoodsWOVO dtoToVo(FGTGoodsWOVODTO dto) {

		FGTGoodsWOVO vo = new FGTGoodsWOVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setIdForPage(String.valueOf(dto.getIdForPage()));
		vo.setName(dto.getName());
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setImageName(dto.getImageName());
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		vo.setInStockQuantity(String.valueOf(dto.getInStockQuantity()));
		
		return vo;
	}
}
