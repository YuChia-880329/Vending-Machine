package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.GoodsIntroductionVODTO;
import bean.vo.frontend.writeout.GoodsIntroductionVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsIntroductionVOTransformer extends VOWriteOutTransformerTemplate<GoodsIntroductionVODTO, GoodsIntroductionVO> {

	private static final GoodsIntroductionVOTransformer INSTANCE = new GoodsIntroductionVOTransformer();
	
	private GoodsIntroductionVOTransformer() {
	}
	
	public static GoodsIntroductionVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsIntroductionVO dtoToVoTransform(GoodsIntroductionVODTO dto) {
		
		GoodsIntroductionVO vo = new GoodsIntroductionVO();
		
		vo.setName(dto.getName());
		vo.setImagePath(dto.getImagePath());
		vo.setDescription(dto.getDescription());
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		
		return vo;
	}
	
	
}
