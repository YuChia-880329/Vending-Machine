package transformer.vo.backend.orderList.writeout;

import bean.dto.vo.backend.orderList.writeout.BOLOrderTableLWOVODTO;
import bean.vo.backend.orderList.writeout.BOLOrderTableLWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BOLOrderTableLWOVOTransformer extends VOWriteOutTransformerTemplate<BOLOrderTableLWOVODTO, BOLOrderTableLWOVO> {

	private BOLOTOrderWOVOTransformer bolotOrderWOVOTransformer;
	
	
	private static final BOLOrderTableLWOVOTransformer INSTANCE = new BOLOrderTableLWOVOTransformer();
	
	private BOLOrderTableLWOVOTransformer() {
		
		bolotOrderWOVOTransformer = BOLOTOrderWOVOTransformer.getInstance();
	}
	
	public static BOLOrderTableLWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BOLOrderTableLWOVO dtoToVo(BOLOrderTableLWOVODTO dto) {

		BOLOrderTableLWOVO vo = new BOLOrderTableLWOVO();
		
		vo.setOrders(bolotOrderWOVOTransformer.dtoListToVoList(dto.getOrders()));
		
		return vo;
	}
}
