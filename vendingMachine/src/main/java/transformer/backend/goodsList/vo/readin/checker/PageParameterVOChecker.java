package transformer.backend.goodsList.vo.readin.checker;

import bean.vo.backend.goodsList.readin.PageParameteVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class PageParameterVOChecker extends CheckerTemplate<PageParameteVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods list, filter form, ";
	
	
	private static final PageParameterVOChecker INSTANCE = new PageParameterVOChecker();
	
	private PageParameterVOChecker() {
	}
	
	public static PageParameterVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(PageParameteVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkPage(vo);
		checkIdMin(vo);
		checkIdMax(vo);
		checkName(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
		checkQuantityMin(vo);
		checkQuantityMax(vo);
		checkStatus(vo);
	}
	
	private void checkVo(PageParameteVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkPage(PageParameteVO vo) throws CheckerException {
		
		String page = vo.getPage();
		
		if(page==null || "".equals(page))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(page, StringConcatUtil.concate(NAME_PREFIX, "page"));
	}
	
	
	private void checkIdMin(PageParameteVO vo) throws CheckerException {
		
		String idMin = vo.getIdMin();
		
		if(idMin==null || "".equals(idMin))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMin, StringConcatUtil.concate(NAME_PREFIX, "idMin"));
	}
	private void checkIdMax(PageParameteVO vo) throws CheckerException {
		
		String idMax = vo.getIdMax();
		
		if(idMax==null || "".equals(idMax))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMax, StringConcatUtil.concate(NAME_PREFIX, "idMax"));
	}
	private void checkName(PageParameteVO vo) {
	}
	private void checkPriceMin(PageParameteVO vo) throws CheckerException {
		
		String priceMin = vo.getPriceMin();
		
		if(priceMin==null || "".equals(priceMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMin, StringConcatUtil.concate(NAME_PREFIX, "priceMin"));
	}
	private void checkPriceMax(PageParameteVO vo) throws CheckerException {
		
		String priceMax = vo.getPriceMax();
		
		if(priceMax==null || "".equals(priceMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMax, StringConcatUtil.concate(NAME_PREFIX, "priceMax"));
	}
	private void checkQuantityMin(PageParameteVO vo) throws CheckerException {
		
		String quantityMin = vo.getQuantityMin();
		
		if(quantityMin==null || "".equals(quantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMin, StringConcatUtil.concate(NAME_PREFIX, "quantityMin"));
	}
	private void checkQuantityMax(PageParameteVO vo) throws CheckerException {
		
		String quantityMax = vo.getQuantityMax();
		
		if(quantityMax==null || "".equals(quantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMax, StringConcatUtil.concate(NAME_PREFIX, "quantityMax"));
	}
	private void checkStatus(PageParameteVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		if(status==null || "".equals(status))
			return;
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {String.valueOf(Status.ON.getValue()), String.valueOf(Status.OFF.getValue())});
	}

}
