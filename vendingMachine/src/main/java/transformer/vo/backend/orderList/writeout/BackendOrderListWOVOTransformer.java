package transformer.vo.backend.orderList.writeout;

import bean.dto.vo.backend.orderList.writeout.BackendOrderListWOVODTO;
import bean.vo.backend.orderList.writeout.BackendOrderListWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class BackendOrderListWOVOTransformer extends VOWriteOutTransformerTemplate<BackendOrderListWOVODTO, BackendOrderListWOVO> {

	private BOLOrderTableLWOVOTransformer bolOrderTableLWOVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	
	private static final BackendOrderListWOVOTransformer INSTANCE = new BackendOrderListWOVOTransformer();
	
	private BackendOrderListWOVOTransformer() {
		
		bolOrderTableLWOVOTransformer = BOLOrderTableLWOVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static BackendOrderListWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendOrderListWOVO dtoToVo(BackendOrderListWOVODTO dto) {
		
		BackendOrderListWOVO vo = new BackendOrderListWOVO();
		
		vo.setOrderTable(bolOrderTableLWOVOTransformer.dtoToVo(dto.getOrderTable()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
}
