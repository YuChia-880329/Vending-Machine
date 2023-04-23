package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.GoodsTableEntryVODTO;
import bean.vo.frontend.writeout.GoodsTableEntryVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class GoodsTableEntryVOTransformer extends VOWriteOutTransformerTemplate<GoodsTableEntryVODTO, GoodsTableEntryVO> {

	private GoodsCardVOTransformer goodsCardVOTransformer;
	private GoodsIntroductionVOTransformer goodsIntroductionVOTransformer;
	
	private static final GoodsTableEntryVOTransformer INSTANCE = new GoodsTableEntryVOTransformer();
	
	private GoodsTableEntryVOTransformer() {
		
		goodsCardVOTransformer = GoodsCardVOTransformer.getInstance();
		goodsIntroductionVOTransformer = GoodsIntroductionVOTransformer.getInstance();
	}
	
	public static GoodsTableEntryVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTableEntryVO dtoToVoTransform(GoodsTableEntryVODTO dto) {

		GoodsTableEntryVO vo = new GoodsTableEntryVO();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setPageId(String.valueOf(dto.getPageId()));
		vo.setGoodsCard(goodsCardVOTransformer.dtoToVo(dto.getGoodsCard()));
		vo.setGoodsIntroduction(goodsIntroductionVOTransformer.dtoToVo(dto.getGoodsIntroduction()));
		
		return vo;
	}
}
