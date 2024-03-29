package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormGoodsVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateFormGoodsVO;
import enumeration.Status;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateFormGoodsVOTransformer extends VOWriteOutTransformerTemplate<UpdateFormGoodsVODTO, UpdateFormGoodsVO> {

	private static final UpdateFormGoodsVOTransformer INSTANCE = new UpdateFormGoodsVOTransformer();
	
	private UpdateFormGoodsVOTransformer() {
	}
	
	public static UpdateFormGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateFormGoodsVO dtoToVoTransform(UpdateFormGoodsVODTO dto) {
		
		UpdateFormGoodsVO vo = new UpdateFormGoodsVO();
		
		Status status = dto.getStatus();
		
		vo.setId(String.valueOf(dto.getId()));
		vo.setPrice(String.valueOf(dto.getPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setStatus(status==null ? "" : String.valueOf(dto.getStatus().getValue()));
		
		return vo;
	}
}
