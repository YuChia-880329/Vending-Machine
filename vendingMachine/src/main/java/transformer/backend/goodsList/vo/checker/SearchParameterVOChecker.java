package transformer.backend.goodsList.vo.checker;

import bean.vo.backend.goodsList.SearchParameterVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class SearchParameterVOChecker extends CheckerTemplate<SearchParameterVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods list, search form, ";
	
	private static final SearchParameterVOChecker INSTANCE = new SearchParameterVOChecker();
	
	private SearchParameterVOChecker() {
	}
	
	public static SearchParameterVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(SearchParameterVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkIdMin(vo);
		checkIdMax(vo);
		checkName(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
		checkQuantityMin(vo);
		checkQuantityMax(vo);
		checkStatus(vo);
	}
	
	private void checkVo(SearchParameterVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkIdMin(SearchParameterVO vo) throws CheckerException {
		
		String idMin = vo.getIdMin();
		
		if(idMin==null || "".equals(idMin))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMin, StringConcatUtil.concate(NAME_PREFIX, "idMin"));
	}
	private void checkIdMax(SearchParameterVO vo) throws CheckerException {
		
		String idMax = vo.getIdMax();
		
		if(idMax==null || "".equals(idMax))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMax, StringConcatUtil.concate(NAME_PREFIX, "idMax"));
	}
	private void checkName(SearchParameterVO vo) {
	}
	private void checkPriceMin(SearchParameterVO vo) throws CheckerException {
		
		String priceMin = vo.getPriceMin();
		
		if(priceMin==null || "".equals(priceMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMin, StringConcatUtil.concate(NAME_PREFIX, "priceMin"));
	}
	private void checkPriceMax(SearchParameterVO vo) throws CheckerException {
		
		String priceMax = vo.getPriceMax();
		
		if(priceMax==null || "".equals(priceMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMax, StringConcatUtil.concate(NAME_PREFIX, "priceMax"));
	}
	private void checkQuantityMin(SearchParameterVO vo) throws CheckerException {
		
		String quantityMin = vo.getQuantityMin();
		
		if(quantityMin==null || "".equals(quantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMin, StringConcatUtil.concate(NAME_PREFIX, "quantityMin"));
	}
	private void checkQuantityMax(SearchParameterVO vo) throws CheckerException {
		
		String quantityMax = vo.getQuantityMax();
		
		if(quantityMax==null || "".equals(quantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMax, StringConcatUtil.concate(NAME_PREFIX, "quantityMax"));
	}
	private void checkStatus(SearchParameterVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		if(status==null || "".equals(status))
			return;
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {String.valueOf(Status.ON.getValue()), String.valueOf(Status.OFF.getValue())});
	}
}
