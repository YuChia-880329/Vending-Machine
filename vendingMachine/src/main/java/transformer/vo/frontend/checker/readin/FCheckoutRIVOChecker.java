package transformer.vo.frontend.checker.readin;

import bean.vo.frontend.readin.FCheckoutRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class FCheckoutRIVOChecker extends CheckerTemplate<FCheckoutRIVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, checkout form, ";
	
	private static final FCheckoutRIVOChecker INSTANCE = new FCheckoutRIVOChecker();
	
	private FCheckoutRIVOChecker() {
	}
	
	public static FCheckoutRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(FCheckoutRIVO vo) throws CheckerException {

		checkVo(vo);
		
		checkPaidMoney(vo);
	}
	
	private void checkVo(FCheckoutRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPaidMoney(FCheckoutRIVO vo) throws CheckerException {
		
		String paidMoney = vo.getPaidMoney();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(paidMoney, StringConcatUtil.concate(NAME_PREFIX, "paidMoney"));
	}
}
