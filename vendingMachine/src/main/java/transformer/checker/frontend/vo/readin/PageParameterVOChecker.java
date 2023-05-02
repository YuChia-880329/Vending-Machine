package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.PageParameterVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class PageParameterVOChecker extends CheckerTemplate<PageParameterVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, search form, ";
	
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
		checkName(vo);
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
	private void checkName(PageParameterVO vo) throws CheckerException {	
	}
}
