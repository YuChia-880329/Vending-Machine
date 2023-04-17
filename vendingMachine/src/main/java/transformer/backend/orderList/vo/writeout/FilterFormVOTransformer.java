package transformer.backend.orderList.vo.writeout;

import java.time.LocalDate;

import bean.dto.backend.orderList.vo.writeout.FilterFormVODTO;
import bean.vo.backend.orderList.writeout.FilterFormVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import util.DateTimeUtil;

public class FilterFormVOTransformer extends VOWriteOutTransformerTemplate<FilterFormVODTO, FilterFormVO> {

	private static final FilterFormVOTransformer INSTANCE = new FilterFormVOTransformer();
	
	private FilterFormVOTransformer() {
	}
	
	public static FilterFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FilterFormVO dtoToVoTransform(FilterFormVODTO dto) {
		
		FilterFormVO vo = new FilterFormVO();
		
		String customerName = dto.getCustomerName();
		vo.setCustomerName(customerName==null ? "" : customerName);
		
		LocalDate startDate = dto.getStartDate();
		vo.setStartDate(startDate==null ? "" : DateTimeUtil.localDateToString(startDate));
		
		LocalDate endDate = dto.getEndDate();
		vo.setEndDate(endDate==null ? "" : DateTimeUtil.localDateToString(endDate));
		
		String goodsName = dto.getGoodsName();
		vo.setGoodsName(goodsName==null ? "" : goodsName);
		
		Integer goodsPriceMin = dto.getGoodsPriceMin();
		vo.setGoodsPriceMin(goodsPriceMin==null ? "" : String.valueOf(goodsPriceMin));
		
		Integer goodsPriceMax = dto.getGoodsPriceMax();
		vo.setGoodsPriceMax(goodsPriceMax==null ? "" : String.valueOf(goodsPriceMax));
		
		Integer buyQuantityMin = dto.getBuyQuantityMin();
		vo.setBuyQuantityMin(buyQuantityMin==null ? "" : String.valueOf(buyQuantityMin));
		
		Integer buyQuantityMax = dto.getBuyQuantityMax();
		vo.setBuyQuantityMax(buyQuantityMax==null ? "" : String.valueOf(buyQuantityMax));
		
		Integer totalPriceMin = dto.getTotalPriceMin();
		vo.setTotalPriceMin(totalPriceMin==null ? "" : String.valueOf(totalPriceMin));
		
		Integer totalPriceMax = dto.getTotalPriceMax();
		vo.setTotalPriceMax(totalPriceMax==null ? "" : String.valueOf(totalPriceMax));
		
		return vo;
	}
}
