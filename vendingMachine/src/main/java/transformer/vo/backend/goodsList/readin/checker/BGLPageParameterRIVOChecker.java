package transformer.vo.backend.goodsList.readin.checker;

import bean.vo.backend.goodsList.BGLSearchParameterVO;
import bean.vo.backend.goodsList.readin.BGLPageParameteRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import transformer.vo.backend.goodsList.checker.BGLSearchParameterVOChecker;
import util.CheckUtil;
import util.StringConcatUtil;

public class BGLPageParameterRIVOChecker extends CheckerTemplate<BGLPageParameteRIVO, CheckerException> {

	private static final String NAME_PREFIX = "backend goods list, search form, ";
	
	private BGLSearchParameterVOChecker bglSearchParameterRIVOChecker;
	
	
	private static final BGLPageParameterRIVOChecker INSTANCE = new BGLPageParameterRIVOChecker();
	
	private BGLPageParameterRIVOChecker() {
		
		bglSearchParameterRIVOChecker = BGLSearchParameterVOChecker.getInstance();
	}
	
	public static BGLPageParameterRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(BGLPageParameteRIVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkPage(vo);
		checkSearchParameter(vo);
	}
	
	private void checkVo(BGLPageParameteRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkPage(BGLPageParameteRIVO vo) throws CheckerException {
		
		String page = vo.getPage();
		
		if(page==null || "".equals(page))
			return;
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(page, StringConcatUtil.concate(NAME_PREFIX, "page"));
	}
	private void checkSearchParameter(BGLPageParameteRIVO vo) throws CheckerException {
		
		BGLSearchParameterVO searchParameter = vo.getSearchParameters();

		CheckUtil.checkOther(searchParameter, StringConcatUtil.concate(NAME_PREFIX, "searchParameter"));
		
		bglSearchParameterRIVOChecker.check(searchParameter);
	}

}
