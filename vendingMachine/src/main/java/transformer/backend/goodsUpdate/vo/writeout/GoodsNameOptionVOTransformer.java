package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.GoodsNameOptionVODTO;
import bean.vo.backend.goodsUpdate.writeout.GoodsNameOptionVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsNameOptionVOTransformer extends VOWriteOutTransformerTemplate<GoodsNameOptionVODTO, GoodsNameOptionVO> {

	private static final GoodsNameOptionVOTransformer INSTANCE = new GoodsNameOptionVOTransformer();
	
	private GoodsNameOptionVOTransformer() {
	}
	
	public static GoodsNameOptionVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsNameOptionVO dtoToVoTransform(GoodsNameOptionVODTO dto) {

		GoodsNameOptionVO vo = new GoodsNameOptionVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(dto.getName());
		
		return vo;
	}
}
