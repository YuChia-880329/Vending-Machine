package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.GoodsTablePageVODTO;
import bean.vo.frontend.writeout.GoodsTablePageVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsTablePageVOTransformer extends VOWriteOutTransformerTemplate<GoodsTablePageVODTO, GoodsTablePageVO> {

	private GoodsTableVOTransformer goodsTableVOTransformer;
	
	
	private static final GoodsTablePageVOTransformer INSTANCE = new GoodsTablePageVOTransformer();
	
	private GoodsTablePageVOTransformer() {
		
		goodsTableVOTransformer = GoodsTableVOTransformer.getInstance();
	}
	
	public static GoodsTablePageVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTablePageVO dtoToVoTransform(GoodsTablePageVODTO dto) {
		
		GoodsTablePageVO vo = new GoodsTablePageVO();
		
		vo.setGoodsTable(goodsTableVOTransformer.dtoToVo(dto.getGoodsTable()));
		
		return vo;
	}
}
