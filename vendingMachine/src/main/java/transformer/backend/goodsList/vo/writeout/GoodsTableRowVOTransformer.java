package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.GoodsTableRowVODTO;
import bean.vo.backend.goodsList.writeout.GoodsTableRowVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsTableRowVOTransformer extends VOWriteOutTransformerTemplate<GoodsTableRowVODTO, GoodsTableRowVO> {

	private static final GoodsTableRowVOTransformer INSTANCE = new GoodsTableRowVOTransformer();
	
	private GoodsTableRowVOTransformer() {
	}
	
	public static GoodsTableRowVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTableRowVO dtoToVo(GoodsTableRowVODTO dto) {
		
		GoodsTableRowVO vo = new GoodsTableRowVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(String.valueOf(dto.getName()));
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setStatus(dto.getStatus().getDescription());
		
		return vo;
	}
}
