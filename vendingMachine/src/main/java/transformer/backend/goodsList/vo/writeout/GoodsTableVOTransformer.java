package transformer.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.writeout.GoodsTableVODTO;
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
	public GoodsTableVO dtoToVo(GoodsTableVODTO dto) {

		GoodsTableVO vo = new GoodsTableVO();
		
		vo.setGoodsTableRow(goodsTableRowVOTransformer.dtoListToVoList(dto.getGoodsTableRow()));
		
		return vo;
	}
}
