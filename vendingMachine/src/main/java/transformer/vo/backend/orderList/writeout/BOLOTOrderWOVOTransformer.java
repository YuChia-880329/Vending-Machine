package transformer.vo.backend.orderList.writeout;

import bean.dto.vo.backend.orderList.writeout.BOLOTOrderWOVODTO;
import bean.vo.backend.orderList.writeout.BOLOTOrderWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BOLOTOrderWOVOTransformer extends VOWriteOutTransformerTemplate<BOLOTOrderWOVODTO, BOLOTOrderWOVO> {

	private static final BOLOTOrderWOVOTransformer INSTANCE = new BOLOTOrderWOVOTransformer();
	
	private BOLOTOrderWOVOTransformer() {
	}
	
	public static BOLOTOrderWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BOLOTOrderWOVO dtoToVo(BOLOTOrderWOVODTO dto) {
		
		BOLOTOrderWOVO vo = new BOLOTOrderWOVO();
		
		vo.setCustomerName(dto.getCustomerName());
		vo.setDate(dto.getDate());
		vo.setGoodsName(dto.getGoodsName());
		vo.setGoodsPrice(String.valueOf(dto.getGoodsPrice()));
		vo.setQuantity(String.valueOf(dto.getQuantity()));
		vo.setTotalPrice(String.valueOf(dto.getTotalPrice()));
		
		return vo;
	}
}
