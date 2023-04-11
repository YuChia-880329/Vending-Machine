package transformer.backend.goodsList.vo.readin.checker;

import bean.vo.backend.goodsList.SearchParameterVO;
import bean.vo.backend.goodsList.readin.PageParameteVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import transformer.backend.goodsList.vo.checker.SearchParameterVOChecker;
import util.CheckUtil;
import util.StringConcatUtil;

public class PageParameterVOChecker extends CheckerTemplate<PageParameteVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods list, search form, ";
	
	private SearchParameterVOChecker searchParameterVOChecker;
	
	
	private static final PageParameterVOChecker INSTANCE = new PageParameterVOChecker();
	
	private PageParameterVOChecker() {
		
		searchParameterVOChecker = SearchParameterVOChecker.getInstance();
	}
	
	public static PageParameterVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(PageParameteVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkPage(vo);
		checkSearchParameter(vo);
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
	private void checkSearchParameter(PageParameteVO vo) throws CheckerException {
		
		SearchParameterVO searchParameter = vo.getSearchParameter();

		CheckUtil.checkOther(searchParameter, StringConcatUtil.concate(NAME_PREFIX, "searchParameter"));
		
		searchParameterVOChecker.check(searchParameter);
	}

}
