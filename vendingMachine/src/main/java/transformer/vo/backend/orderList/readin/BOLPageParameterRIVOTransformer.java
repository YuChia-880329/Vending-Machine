package transformer.vo.backend.orderList.readin;

import java.time.LocalDateTime;

import bean.dto.vo.backend.orderList.readin.BOLPageParameterRIVODTO;
import bean.vo.backend.orderList.readin.PageParameterVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.vo.backend.orderList.readin.checker.BOLPageParameterRIVOChecker;
import util.DateTimeUtil;
import util.StringConcatUtil;

public class BOLPageParameterRIVOTransformer extends VOReanInTransformerTemplate<PageParameterVO, BOLPageParameterRIVODTO, CheckerException, BOLPageParameterRIVOChecker>  {

	private static final BOLPageParameterRIVOTransformer INSTANCE = new BOLPageParameterRIVOTransformer();
	
	private BOLPageParameterRIVOTransformer() {
	}
	
	public static BOLPageParameterRIVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BOLPageParameterRIVODTO voToDto(PageParameterVO vo) throws CheckerException {

		BOLPageParameterRIVODTO dto = new BOLPageParameterRIVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));

		dto.setCustomerName(vo.getCustomerName());

		
		String startDateStr = vo.getStartDate();
		LocalDateTime startDate = null;
		if(startDateStr!=null && !"".equals(startDateStr))
			startDate = DateTimeUtil.stringToLocalDateTime(StringConcatUtil.concate(startDateStr, " 00:00:00"));
		dto.setStartDate(startDate);
		
		
		String endDateStr = vo.getEndDate();
		LocalDateTime endDate = null;
		if(endDateStr!=null && !"".equals(endDateStr))
			endDate = DateTimeUtil.stringToLocalDateTime(StringConcatUtil.concate(endDateStr, " 23:59:59"));
		dto.setEndDate(endDate);
		
		
		dto.setGoodsName(vo.getGoodsName());
		
		String goodsPriceMin = vo.getGoodsPriceMin();
		dto.setGoodsPriceMin((goodsPriceMin==null||"".equals(goodsPriceMin)) ? null : Integer.parseInt(goodsPriceMin));
		
		String goodsPriceMax = vo.getGoodsPriceMax();
		dto.setGoodsPriceMax((goodsPriceMax==null||"".equals(goodsPriceMax)) ? null : Integer.parseInt(goodsPriceMax));
		
		String quantityMin = vo.getQuantityMin();
		dto.setQuantityMin((quantityMin==null||"".equals(quantityMin)) ? null : Integer.parseInt(quantityMin));
		
		String quantityMax = vo.getQuantityMax();
		dto.setQuantityMax((quantityMax==null||"".equals(quantityMax)) ? null : Integer.parseInt(quantityMax));
		
		String totalPriceMin = vo.getTotalPriceMin();
		dto.setTotalPriceMin((totalPriceMin==null||"".equals(totalPriceMin)) ? null : Integer.parseInt(totalPriceMin));
		
		String totalPriceMax = vo.getTotalPriceMax();
		dto.setTotalPriceMax((totalPriceMax==null||"".equals(totalPriceMax)) ? null : Integer.parseInt(totalPriceMax));
		
		return dto;
	}

	@Override
	protected BOLPageParameterRIVOChecker getChecker() {

		return BOLPageParameterRIVOChecker.getInstance();
	}
}
