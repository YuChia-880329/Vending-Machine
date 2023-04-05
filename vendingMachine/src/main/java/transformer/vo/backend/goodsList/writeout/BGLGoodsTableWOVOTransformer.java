package transformer.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTableWOVODTO;
import bean.vo.backend.goodsList.writeout.BGLGoodsTableWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGLGoodsTableWOVOTransformer extends VOWriteOutTransformerTemplate<BGLGoodsTableWOVODTO, BGLGoodsTableWOVO> {

	private BGLGTGoodsWOVOTransformer bglgtGoodsWOVOTransformer;
	
	
	private static final BGLGoodsTableWOVOTransformer INSTANCE = new BGLGoodsTableWOVOTransformer();
	
	private BGLGoodsTableWOVOTransformer() {
		
		bglgtGoodsWOVOTransformer = BGLGTGoodsWOVOTransformer.getInstance();
	}
	
	public static BGLGoodsTableWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTableWOVO dtoToVo(BGLGoodsTableWOVODTO dto) {

		BGLGoodsTableWOVO vo = new BGLGoodsTableWOVO();
		
		vo.setGoods(bglgtGoodsWOVOTransformer.dtoListToVoList(dto.getGoods()));
		
		return vo;
	}
}
