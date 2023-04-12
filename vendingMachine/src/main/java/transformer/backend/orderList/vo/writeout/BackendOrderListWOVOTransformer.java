package transformer.backend.orderList.vo.writeout;

import bean.dto.backend.orderList.vo.writeout.BackendOrderListWOVODTO;
import bean.vo.backend.orderList.writeout.BackendOrderListVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendOrderListWOVOTransformer extends VOWriteOutTransformerTemplate<BackendOrderListWOVODTO, BackendOrderListVO> {

	private OrderTablePageVOTransformer orderTablePageVOTransformer;
	private FilterFormVOTransformer filterFormVOTransformer;
	
	
	private static final BackendOrderListWOVOTransformer INSTANCE = new BackendOrderListWOVOTransformer();
	
	private BackendOrderListWOVOTransformer() {
		
		orderTablePageVOTransformer = OrderTablePageVOTransformer.getInstance();
		filterFormVOTransformer = FilterFormVOTransformer.getInstance();
	}
	
	public static BackendOrderListWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BackendOrderListVO dtoToVo(BackendOrderListWOVODTO dto) {
		
		BackendOrderListVO vo = new BackendOrderListVO();
		
		vo.setOrderTablePage(orderTablePageVOTransformer.dtoToVo(dto.getOrderTablePage()));
		vo.setFilterForm(filterFormVOTransformer.dtoToVo(dto.getFilterForm()));
		
		return vo;
	}
}
