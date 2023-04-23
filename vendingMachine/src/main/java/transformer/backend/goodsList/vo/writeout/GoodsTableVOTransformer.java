package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.GoodsTableVODTO;
import bean.vo.backend.goodsList.writeout.GoodsTableRowVO;
import bean.vo.backend.goodsList.writeout.GoodsTableVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsTableVOTransformer extends VOWriteOutTransformerTemplate<GoodsTableVODTO, GoodsTableVO> {

	private GoodsTableRowVOTransformer goodsTableRowVOTransformer;
	
	
	private static final GoodsTableVOTransformer INSTANCE = new GoodsTableVOTransformer();
	
	private GoodsTableVOTransformer() {
		
		goodsTableRowVOTransformer = GoodsTableRowVOTransformer.getInstance();
	}
	
	public static GoodsTableVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTableVO dtoToVoTransform(GoodsTableVODTO dto) {

		GoodsTableVO vo = new GoodsTableVO();
		
		vo.setGoodsTableRows(goodsTableRowVOTransformer.dtoListToVoArray(dto.getGoodsTableRows(), size -> new GoodsTableRowVO[size]));
		
		return vo;
	}
}
