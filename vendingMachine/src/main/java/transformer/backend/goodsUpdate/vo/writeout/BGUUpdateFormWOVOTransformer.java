package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BGUUpdateFormWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateFormVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUpdateFormWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUpdateFormWOVODTO, UpdateFormVO> {

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
	public UpdateFormVO dtoToVo(BGUUpdateFormWOVODTO dto) {

		UpdateFormVO vo = new UpdateFormVO();
		
		vo.setGoodsNameOptions(bguufGoodsNameOptionWOVOTransformer.dtoListToVoList(dto.getGoodsNameOptions()));
		vo.setCurrentGoods(bguufGoodsWOVOTransformer.dtoToVo(dto.getCurrentGoods()));
		
		return vo;
	}
}
