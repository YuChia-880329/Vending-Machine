package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.GoodsCardVODTO;
import bean.vo.frontend.writeout.GoodsCardVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsCardVOTransformer extends VOWriteOutTransformerTemplate<GoodsCardVODTO, GoodsCardVO> {

	private static final GoodsCardVOTransformer INSTANCE = new GoodsCardVOTransformer();
	
	private GoodsCardVOTransformer() {
	}
	
	public static GoodsCardVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsCardVO dtoToVoTransform(GoodsCardVODTO dto) {
		
		GoodsCardVO vo = new GoodsCardVO();
		
		vo.setName(dto.getName());
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setImagePath(dto.getImagePath());
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		
		return vo;
	}
}
