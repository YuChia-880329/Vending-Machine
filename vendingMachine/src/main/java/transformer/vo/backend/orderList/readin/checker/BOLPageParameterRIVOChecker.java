package transformer.vo.backend.orderList.readin.checker;

import bean.vo.backend.orderList.readin.PageParameterVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BOLPageParameterRIVOChecker extends CheckerTemplate<PageParameterVO, CheckerException> {

	private static final String NAME_PREFIX = "backend order list, search form, ";
	
	private static final BOLPageParameterRIVOChecker INSTANCE = new BOLPageParameterRIVOChecker();
	
	private BOLPageParameterRIVOChecker() {
	}
	
	public static BOLPageParameterRIVOChecker getInstance() {
		
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
		checkQuantityMin(vo);
		checkQuantityMax(vo);
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
	private void checkQuantityMin(PageParameterVO vo) throws CheckerException {
		
		String quantityMin = vo.getQuantityMin();
		
		if(quantityMin==null || "".equals(quantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMin, StringConcatUtil.concate(NAME_PREFIX, "quantityMin"));
	}
	private void checkQuantityMax(PageParameterVO vo) throws CheckerException {
		
		String quantityMax = vo.getQuantityMax();
		
		if(quantityMax==null || "".equals(quantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMax, StringConcatUtil.concate(NAME_PREFIX, "quantityMax"));
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
