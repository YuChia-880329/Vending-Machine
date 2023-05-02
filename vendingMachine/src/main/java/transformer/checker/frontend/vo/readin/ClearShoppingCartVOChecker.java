package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.ClearShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class ClearShoppingCartVOChecker extends CheckerTemplate<ClearShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, clear shopping cart, ";
	
	
	private static final ClearShoppingCartVOChecker INSTANCE = new ClearShoppingCartVOChecker();
	
	private ClearShoppingCartVOChecker() {
	}
	
	public static ClearShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}
	
	@Override
	public void check(ClearShoppingCartVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkQueryString(vo);
	}

	private void checkVo(ClearShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkQueryString(ClearShoppingCartVO vo) throws CheckerException {
		
		String queryString = vo.getQueryString();
		
		CheckUtil.checkString(queryString, StringConcatUtil.concate(NAME_PREFIX, "queryString"));
	}
}
