package transformer.backend.orderList.vo.writeout;

import bean.dto.backend.orderList.vo.writeout.BackendOrderListVODTO;
import bean.vo.backend.orderList.writeout.BackendOrderListVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BackendOrderListVOTransformer extends VOWriteOutTransformerTemplate<BackendOrderListVODTO, BackendOrderListVO> {

	private OrderTablePageVOTransformer orderTablePageVOTransformer;
	private FilterFormVOTransformer filterFormVOTransformer;
	
	
	private static final BackendOrderListVOTransformer INSTANCE = new BackendOrderListVOTransformer();
	
	private BackendOrderListVOTransformer() {
		
		orderTablePageVOTransformer = OrderTablePageVOTransformer.getInstance();
		filterFormVOTransformer = FilterFormVOTransformer.getInstance();
	}
	
	public static BackendOrderListVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BackendOrderListVO dtoToVoTransform(BackendOrderListVODTO dto) {
		
		BackendOrderListVO vo = new BackendOrderListVO();
		
		vo.setOrderTablePage(orderTablePageVOTransformer.dtoToVo(dto.getOrderTablePage()));
		vo.setFilterForm(filterFormVOTransformer.dtoToVo(dto.getFilterForm()));
		
		return vo;
	}
}
