package transformer.vo.backend.orderList.checker.readin;

import bean.vo.backend.orderList.readin.BOLPageParameterRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BOLPageParameterRIVOChecker extends CheckerTemplate<BOLPageParameterRIVO, CheckerException> {

	private static final String NAME_PREFIX = "backend order list, search form, ";
	
	private static final BOLPageParameterRIVOChecker INSTANCE = new BOLPageParameterRIVOChecker();
	
	private BOLPageParameterRIVOChecker() {
	}
	
	public static BOLPageParameterRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(BOLPageParameterRIVO vo) throws CheckerException {
		
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
	
	private void checkVo(BOLPageParameterRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPage(BOLPageParameterRIVO vo) throws CheckerException {
		
		String page = vo.getPage();
		
		if(page==null || "".equals(page))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(page, StringConcatUtil.concate(NAME_PREFIX, "page"));
	}
	private void checkCustomerName(BOLPageParameterRIVO vo) throws CheckerException {
	}
	private void checkStartDate(BOLPageParameterRIVO vo) throws CheckerException {
	}
	private void checkEndDate(BOLPageParameterRIVO vo) throws CheckerException {
	}
	private void checkGoodsName(BOLPageParameterRIVO vo) throws CheckerException {
	}
	private void checkGoodsPriceMin(BOLPageParameterRIVO vo) throws CheckerException {
		
		String goodsPriceMin = vo.getGoodsPriceMin();
		
		if(goodsPriceMin==null || "".equals(goodsPriceMin))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(goodsPriceMin, StringConcatUtil.concate(NAME_PREFIX, "goodsPriceMin"));
	}
	private void checkGoodsPriceMax(BOLPageParameterRIVO vo) throws CheckerException {
		
		String goodsPriceMax = vo.getGoodsPriceMax();
		
		if(goodsPriceMax==null || "".equals(goodsPriceMax))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(goodsPriceMax, StringConcatUtil.concate(NAME_PREFIX, "goodsPriceMax"));
	}
	private void checkQuantityMin(BOLPageParameterRIVO vo) throws CheckerException {
		
		String quantityMin = vo.getQuantityMin();
		
		if(quantityMin==null || "".equals(quantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMin, StringConcatUtil.concate(NAME_PREFIX, "quantityMin"));
	}
	private void checkQuantityMax(BOLPageParameterRIVO vo) throws CheckerException {
		
		String quantityMax = vo.getQuantityMax();
		
		if(quantityMax==null || "".equals(quantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMax, StringConcatUtil.concate(NAME_PREFIX, "quantityMax"));
	}
	private void checkTotalPriceMin(BOLPageParameterRIVO vo) throws CheckerException {
		
		String totalPriceMin = vo.getTotalPriceMin();
		
		if(totalPriceMin==null || "".equals(totalPriceMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(totalPriceMin, StringConcatUtil.concate(NAME_PREFIX, "totalPriceMin"));
	}
	private void checkTotalPriceMax(BOLPageParameterRIVO vo) throws CheckerException {
		
		String totalPriceMax = vo.getTotalPriceMax();
		
		if(totalPriceMax==null || "".equals(totalPriceMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(totalPriceMax, StringConcatUtil.concate(NAME_PREFIX, "totalPriceMax"));
	}
	
}
