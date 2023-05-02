package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.CheckoutFormVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class CheckoutFormVOChecker extends CheckerTemplate<CheckoutFormVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, checkout form, ";
	
	private static final CheckoutFormVOChecker INSTANCE = new CheckoutFormVOChecker();
	
	private CheckoutFormVOChecker() {
	}
	
	public static CheckoutFormVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(CheckoutFormVO vo) throws CheckerException {

		checkVo(vo);
		
		checkPaidMoney(vo);
	}
	
	private void checkVo(CheckoutFormVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPaidMoney(CheckoutFormVO vo) throws CheckerException {
		
		String paidMoney = vo.getPaidMoney();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(paidMoney, StringConcatUtil.concate(NAME_PREFIX, "paidMoney"));
	}
}
