package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.GoodsTableVODTO;
import bean.vo.frontend.writeout.GoodsTableEntryVO;
import bean.vo.frontend.writeout.GoodsTableVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsTableVOTransformer extends VOWriteOutTransformerTemplate<GoodsTableVODTO, GoodsTableVO> {

	private GoodsTableEntryVOTransformer goodsTableEntryVOTransformer;
	
	
	private static final GoodsTableVOTransformer INSTANCE = new GoodsTableVOTransformer();
	
	private GoodsTableVOTransformer() {
		
		goodsTableEntryVOTransformer = GoodsTableEntryVOTransformer.getInstance();
	}
	
	public static GoodsTableVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTableVO dtoToVoTransform(GoodsTableVODTO dto) {

		GoodsTableVO vo = new GoodsTableVO();
		
		vo.setGoodsTableEntries(goodsTableEntryVOTransformer.dtoListToVoArray(dto.getGoodsTableEntries(), size -> new GoodsTableEntryVO[size]));
		
		return vo;
	}
}
