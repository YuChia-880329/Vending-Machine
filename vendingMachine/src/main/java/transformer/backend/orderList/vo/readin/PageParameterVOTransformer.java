package transformer.backend.orderList.vo.readin;

import java.time.LocalDate;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.vo.backend.orderList.readin.PageParameterVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.backend.orderList.vo.readin.checker.PageParameterVOChecker;
import util.DateTimeUtil;
import util.StringConcatUtil;

public class PageParameterVOTransformer extends VOReanInTransformerTemplate<PageParameterVO, PageParameterVODTO, CheckerException, PageParameterVOChecker>  {

	private static final PageParameterVOTransformer INSTANCE = new PageParameterVOTransformer();
	
	private PageParameterVOTransformer() {
	}
	
	public static PageParameterVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PageParameterVODTO voToDto(PageParameterVO vo) throws CheckerException {

		PageParameterVODTO dto = new PageParameterVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));

		dto.setCustomerName(vo.getCustomerName());

		
		String startDateStr = vo.getStartDate();
		LocalDate startDate = null;
		if(startDateStr!=null && !"".equals(startDateStr))
			startDate = DateTimeUtil.stringToLocalDate(StringConcatUtil.concate(startDateStr));
		dto.setStartDate(startDate);
		
		
		String endDateStr = vo.getEndDate();
		LocalDate endDate = null;
		if(endDateStr!=null && !"".equals(endDateStr))
			endDate = DateTimeUtil.stringToLocalDate(StringConcatUtil.concate(endDateStr));
		dto.setEndDate(endDate);
		
		
		dto.setGoodsName(vo.getGoodsName());
		
		String goodsPriceMin = vo.getGoodsPriceMin();
		dto.setGoodsPriceMin((goodsPriceMin==null||"".equals(goodsPriceMin)) ? null : Integer.parseInt(goodsPriceMin));
		
		String goodsPriceMax = vo.getGoodsPriceMax();
		dto.setGoodsPriceMax((goodsPriceMax==null||"".equals(goodsPriceMax)) ? null : Integer.parseInt(goodsPriceMax));
		
		String buyQuantityMin = vo.getBuyQuantityMin();
		dto.setBuyQuantityMin((buyQuantityMin==null||"".equals(buyQuantityMin)) ? null : Integer.parseInt(buyQuantityMin));
		
		String buyQuantityMax = vo.getBuyQuantityMax();
		dto.setBuyQuantityMax((buyQuantityMax==null||"".equals(buyQuantityMax)) ? null : Integer.parseInt(buyQuantityMax));
		
		String totalPriceMin = vo.getTotalPriceMin();
		dto.setTotalPriceMin((totalPriceMin==null||"".equals(totalPriceMin)) ? null : Integer.parseInt(totalPriceMin));
		
		String totalPriceMax = vo.getTotalPriceMax();
		dto.setTotalPriceMax((totalPriceMax==null||"".equals(totalPriceMax)) ? null : Integer.parseInt(totalPriceMax));
		
		return dto;
	}

	@Override
	protected PageParameterVOChecker getChecker() {

		return PageParameterVOChecker.getInstance();
	}
}
