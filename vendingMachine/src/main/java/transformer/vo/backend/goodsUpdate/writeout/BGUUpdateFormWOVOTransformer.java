package transformer.vo.backend.goodsUpdate.writeout;

import bean.dto.vo.backend.goodsUpdate.writeout.BGUUpdateFormWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BGUUpdateFormWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUpdateFormWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUpdateFormWOVODTO, BGUUpdateFormWOVO> {

	private BGUUFGoodsNameOptionWOVOTransformer bguufGoodsNameOptionWOVOTransformer;
	private BGUUFGoodsWOVOTransformer bguufGoodsWOVOTransformer;
	
	private static final BGUUpdateFormWOVOTransformer INSTANCE = new BGUUpdateFormWOVOTransformer();
	
	private BGUUpdateFormWOVOTransformer() {
		
		bguufGoodsNameOptionWOVOTransformer = BGUUFGoodsNameOptionWOVOTransformer.getInstance();
		bguufGoodsWOVOTransformer = BGUUFGoodsWOVOTransformer.getInstance();
	}
	
	public static BGUUpdateFormWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUUpdateFormWOVO dtoToVo(BGUUpdateFormWOVODTO dto) {

		BGUUpdateFormWOVO vo = new BGUUpdateFormWOVO();
		
		vo.setGoodsNameOptions(bguufGoodsNameOptionWOVOTransformer.dtoListToVoList(dto.getGoodsNameOptions()));
		vo.setCurrentGoods(bguufGoodsWOVOTransformer.dtoToVo(dto.getCurrentGoods()));
		
		return vo;
	}
}
