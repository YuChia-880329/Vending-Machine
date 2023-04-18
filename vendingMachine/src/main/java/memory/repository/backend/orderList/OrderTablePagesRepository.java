package memory.repository.backend.orderList;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTableRowOBJDTO;
import bean.dto.model.OrderJoinModelDTO;
import bean.obj.backend.orderList.repository.orderTablePages.readin.OrderTablePagesInputOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.FilterParameterOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTableOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePageOBJ;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePagesOBJ;
import service.backend.orderList.memory.repository.orderTablePages.FilterParameterService;
import service.backend.orderList.memory.repository.orderTablePages.OBJTransformService;
import service.backend.orderList.prepare.OrderTablePageService;
import service.model.OrderJoinModelService;
import template.memory.repository.RepositoryTemplate;
import template.model.QueryObj;
import transformer.backend.orderList.obj.orderTablePages.writeout.OrderTableRowOBJTransformer;
import util.DateTimeUtil;
import util.PaginationUtil;

public class OrderTablePagesRepository extends RepositoryTemplate<OrderTablePagesInputOBJ, OrderTablePagesOBJ> {

	private boolean updateRequired;
	
	private FilterParameterService filterParameterService;
	private OBJTransformService objTransformService;
	private OrderJoinModelService orderJoinModelService;
	private OrderTableRowOBJTransformer orderTableRowOBJTransformer;
	
	
	@Override
	protected void init() {
		
		updateRequired = false;
		
		filterParameterService = FilterParameterService.getInstance();
		objTransformService = OBJTransformService.getInstance();
		orderJoinModelService = OrderJoinModelService.getInstance();
		orderTableRowOBJTransformer = OrderTableRowOBJTransformer.getInstance();
	}

	@Override
	protected OrderTablePagesInputOBJ initialInput() {
		
		OrderTablePagesInputOBJ orderTablePagesInputOBJ = new OrderTablePagesInputOBJ();
		
		orderTablePagesInputOBJ.setCurrentPage(1);
		orderTablePagesInputOBJ.setCustomerName(null);
		orderTablePagesInputOBJ.setStartDate(null);
		orderTablePagesInputOBJ.setEndDate(null);
		orderTablePagesInputOBJ.setGoodsName(null);
		orderTablePagesInputOBJ.setGoodsPriceMin(null);
		orderTablePagesInputOBJ.setGoodsPriceMax(null);
		orderTablePagesInputOBJ.setBuyQuantityMin(null);
		orderTablePagesInputOBJ.setBuyQuantityMax(null);
		orderTablePagesInputOBJ.setTotalPriceMin(null);
		orderTablePagesInputOBJ.setTotalPriceMax(null);
		
		return orderTablePagesInputOBJ;
	}

	@Override
	protected boolean isNeedUpdate(OrderTablePagesInputOBJ inputObj) {
		
		return !filterParameterService.equals(objTransformService.orderTablePagesInputToFilterParameter(inputObj), obj.getFilterParameter())
				|| obj.getOrderTablePageMap().get(inputObj.getCurrentPage())==null
				|| updateRequired;
	}

	@Override
	protected OrderTablePagesOBJ update(OrderTablePagesInputOBJ inputObj) {
		
		OrderTablePagesOBJ orderTablePagesOBJ = new OrderTablePagesOBJ();
		
		FilterParameterOBJ filterParameterOBJ = objTransformService.orderTablePagesInputToFilterParameter(inputObj);
		QueryObj[] queryObjs = filterParameterService.getQueryObjs(filterParameterOBJ);
		int maxPage = 0;
		Map<Integer, OrderTablePageOBJ> orderTablePageMap = new HashMap<>();
		try {
			
			maxPage = PaginationUtil.getMaxPage(orderJoinModelService.searchRowNumber(queryObjs), OrderTablePageService.GOODS_PER_PAGE);
			int startPage = PaginationUtil.getStartPage(inputObj.getCurrentPage(), OrderTablePageService.PAGES_PER_PAGE_GROUP);
			int endpage = PaginationUtil.getEndPage(inputObj.getCurrentPage(), OrderTablePageService.PAGES_PER_PAGE_GROUP, maxPage);
			for(int i=startPage; i<=endpage; i++) {
				
				OrderTablePageOBJ orderTablePageOBJ = new OrderTablePageOBJ();
				
				OrderTableOBJ orderTableOBJ = new OrderTableOBJ();
				
				List<OrderJoinModelDTO> orderModelDTOList = orderJoinModelService.searchByQueryObjPage(i, OrderTablePageService.GOODS_PER_PAGE, queryObjs);
				
				orderTableOBJ.setOrderTableRows(orderTableRowOBJTransformer.dtoListToObjList(
						orderJoinModelsToOrderTableRowOBJs(orderModelDTOList)));
				
				orderTablePageOBJ.setOrderTable(orderTableOBJ);
				
				orderTablePageMap.put(i, orderTablePageOBJ);
			}
		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		
		orderTablePagesOBJ.setOrderTablePageMap(orderTablePageMap);
		orderTablePagesOBJ.setMaxPage(maxPage);
		orderTablePagesOBJ.setFilterParameter(filterParameterOBJ);
		
		return orderTablePagesOBJ;
	}
	
	public void requireUpdate() {
		
		updateRequired = true;
	}
	
	private List<OrderTableRowOBJDTO> orderJoinModelsToOrderTableRowOBJs(List<OrderJoinModelDTO> orderJoinModelDTOs){
		
		return orderJoinModelDTOs.stream()
				.map(orderJoinModelDTO -> orderJoinModelToOrderTableRowOBJ(orderJoinModelDTO))
				.collect(Collectors.toList());
	}
	private OrderTableRowOBJDTO orderJoinModelToOrderTableRowOBJ(OrderJoinModelDTO orderJoinModelDTO) {
		
		OrderTableRowOBJDTO orderTableRowOBJDTO = new OrderTableRowOBJDTO();
		
		orderTableRowOBJDTO.setCustomerName(orderJoinModelDTO.getCustomerName());
		orderTableRowOBJDTO.setDate(DateTimeUtil.localDateTimeToLocalDate(orderJoinModelDTO.getDateTime()));
		orderTableRowOBJDTO.setGoodsName(orderJoinModelDTO.getGoodsName());
		orderTableRowOBJDTO.setGoodsPrice(orderJoinModelDTO.getGoodsPrice());
		orderTableRowOBJDTO.setBuyQuantity(orderJoinModelDTO.getBuyQuantity());
		orderTableRowOBJDTO.setTotalPrice(orderJoinModelDTO.getTotalPrice());
		
		return orderTableRowOBJDTO;
	}
}
