package transformer.backend.orderList.vo.readin.checker;

import bean.vo.backend.orderList.readin.PageParameterVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class PageParameterVOChecker extends CheckerTemplate<PageParameterVO, CheckerException> {

	private static final String NAME_PREFIX = "backend order list, filter form, ";
	
	private static final PageParameterVOChecker INSTANCE = new PageParameterVOChecker();
	
	private PageParameterVOChecker() {
	}
	
	public static PageParameterVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(PageParameterVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkPage(vo);
		checkCustomerName(vo);
		checkStartDate(vo);
		checkEndDate(vo);
		checkGoodsName(vo);
		checkGoodsPriceMin(vo);
		checkGoodsPriceMax(vo);
		checkBuyQuantityMin(vo);
		checkBuyQuantityMax(vo);
		checkTotalPriceMin(vo);
		checkTotalPriceMax(vo);
	}
	
	private void checkVo(PageParameterVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPage(PageParameterVO vo) throws CheckerException {
		
		String page = vo.getPage();
		
		if(page==null || "".equals(page))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(page, StringConcatUtil.concate(NAME_PREFIX, "page"));
	}
	private void checkCustomerName(PageParameterVO vo) throws CheckerException {
	}
	private void checkStartDate(PageParameterVO vo) throws CheckerException {
	}
	private void checkEndDate(PageParameterVO vo) throws CheckerException {
	}
	private void checkGoodsName(PageParameterVO vo) throws CheckerException {
	}
	private void checkGoodsPriceMin(PageParameterVO vo) throws CheckerException {
		
		String goodsPriceMin = vo.getGoodsPriceMin();
		
		if(goodsPriceMin==null || "".equals(goodsPriceMin))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(goodsPriceMin, StringConcatUtil.concate(NAME_PREFIX, "goodsPriceMin"));
	}
	private void checkGoodsPriceMax(PageParameterVO vo) throws CheckerException {
		
		String goodsPriceMax = vo.getGoodsPriceMax();
		
		if(goodsPriceMax==null || "".equals(goodsPriceMax))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(goodsPriceMax, StringConcatUtil.concate(NAME_PREFIX, "goodsPriceMax"));
	}
	private void checkBuyQuantityMin(PageParameterVO vo) throws CheckerException {
		
		String buyQuantityMin = vo.getBuyQuantityMin();
		
		if(buyQuantityMin==null || "".equals(buyQuantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(buyQuantityMin, StringConcatUtil.concate(NAME_PREFIX, "buyQuantityMin"));
	}
	private void checkBuyQuantityMax(PageParameterVO vo) throws CheckerException {
		
		String buyQuantityMax = vo.getBuyQuantityMax();
		
		if(buyQuantityMax==null || "".equals(buyQuantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(buyQuantityMax, StringConcatUtil.concate(NAME_PREFIX, "buyQuantityMax"));
	}
	private void checkTotalPriceMin(PageParameterVO vo) throws CheckerException {
		
		String totalPriceMin = vo.getTotalPriceMin();
		
		if(totalPriceMin==null || "".equals(totalPriceMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(totalPriceMin, StringConcatUtil.concate(NAME_PREFIX, "totalPriceMin"));
	}
	private void checkTotalPriceMax(PageParameterVO vo) throws CheckerException {
		
		String totalPriceMax = vo.getTotalPriceMax();
		
		if(totalPriceMax==null || "".equals(totalPriceMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(totalPriceMax, StringConcatUtil.concate(NAME_PREFIX, "totalPriceMax"));
	}
	
}
