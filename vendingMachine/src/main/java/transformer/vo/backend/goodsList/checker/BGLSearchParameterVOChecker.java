package transformer.vo.backend.goodsList.checker;

import bean.vo.backend.goodsList.BGLSearchParameterVO;
import enumeration.Status;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class BGLSearchParameterVOChecker extends CheckerTemplate<BGLSearchParameterVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods list, search form, ";
	
	private static final BGLSearchParameterVOChecker INSTANCE = new BGLSearchParameterVOChecker();
	
	private BGLSearchParameterVOChecker() {
	}
	
	public static BGLSearchParameterVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(BGLSearchParameterVO vo) throws CheckerException {
		
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
	
	private void checkVo(BGLSearchParameterVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkIdMin(BGLSearchParameterVO vo) throws CheckerException {
		
		String idMin = vo.getIdMin();
		
		if(idMin==null || "".equals(idMin))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMin, StringConcatUtil.concate(NAME_PREFIX, "idMin"));
	}
	private void checkIdMax(BGLSearchParameterVO vo) throws CheckerException {
		
		String idMax = vo.getIdMax();
		
		if(idMax==null || "".equals(idMax))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(idMax, StringConcatUtil.concate(NAME_PREFIX, "idMax"));
	}
	private void checkName(BGLSearchParameterVO vo) {
	}
	private void checkPriceMin(BGLSearchParameterVO vo) throws CheckerException {
		
		String priceMin = vo.getPriceMin();
		
		if(priceMin==null || "".equals(priceMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMin, StringConcatUtil.concate(NAME_PREFIX, "priceMin"));
	}
	private void checkPriceMax(BGLSearchParameterVO vo) throws CheckerException {
		
		String priceMax = vo.getPriceMax();
		
		if(priceMax==null || "".equals(priceMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(priceMax, StringConcatUtil.concate(NAME_PREFIX, "priceMax"));
	}
	private void checkQuantityMin(BGLSearchParameterVO vo) throws CheckerException {
		
		String quantityMin = vo.getQuantityMin();
		
		if(quantityMin==null || "".equals(quantityMin))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMin, StringConcatUtil.concate(NAME_PREFIX, "quantityMin"));
	}
	private void checkQuantityMax(BGLSearchParameterVO vo) throws CheckerException {
		
		String quantityMax = vo.getQuantityMax();
		
		if(quantityMax==null || "".equals(quantityMax))
			return;
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantityMax, StringConcatUtil.concate(NAME_PREFIX, "quantityMax"));
	}
	private void checkStatus(BGLSearchParameterVO vo) throws CheckerException {
		
		String status = vo.getStatus();
		
		if(status==null || "".equals(status))
			return;
		
		CheckUtil.checkStringWithOptions(status, StringConcatUtil.concate(NAME_PREFIX, "status"), new String[] {String.valueOf(Status.ON.getValue()), String.valueOf(Status.OFF.getValue())});
	}
}
