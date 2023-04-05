package transformer.vo.frontend.checker.readin;

import bean.vo.frontend.readin.FPageParameterRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class FPageParameterRIVOChecker extends CheckerTemplate<FPageParameterRIVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, search form, ";
	
	private static final FPageParameterRIVOChecker INSTANCE = new FPageParameterRIVOChecker();
	
	private FPageParameterRIVOChecker() {
	}
	
	public static FPageParameterRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(FPageParameterRIVO vo) throws CheckerException {

		checkVo(vo);
		
		checkPage(vo);
		checkName(vo);
	}
	
	private void checkVo(FPageParameterRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPage(FPageParameterRIVO vo) throws CheckerException {
		
		String page = vo.getPage();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(page, StringConcatUtil.concate(NAME_PREFIX, "page"));
	}
	private void checkName(FPageParameterRIVO vo) throws CheckerException {	
	}
}
