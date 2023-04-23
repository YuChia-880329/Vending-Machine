package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormVODTO;
import bean.vo.backend.goodsUpdate.writeout.GoodsNameOptionVO;
import bean.vo.backend.goodsUpdate.writeout.UpdateFormVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateFormVOTransformer extends VOWriteOutTransformerTemplate<UpdateFormVODTO, UpdateFormVO> {

	private GoodsNameOptionVOTransformer goodsNameOptionVOTransformer;
	
	private static final UpdateFormVOTransformer INSTANCE = new UpdateFormVOTransformer();
	
	private UpdateFormVOTransformer() {
		
		goodsNameOptionVOTransformer = GoodsNameOptionVOTransformer.getInstance();
	}
	
	public static UpdateFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateFormVO dtoToVoTransform(UpdateFormVODTO dto) {

		UpdateFormVO vo = new UpdateFormVO();
		
		vo.setGoodsNameOptions(goodsNameOptionVOTransformer.dtoListToVoArray(dto.getGoodsNameOptions(), size -> new GoodsNameOptionVO[size]));
		
		return vo;
	}
}
