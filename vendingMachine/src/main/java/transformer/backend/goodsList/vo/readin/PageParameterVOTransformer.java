package transformer.backend.goodsList.vo.readin;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.vo.backend.goodsList.readin.PageParameteVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.backend.goodsList.vo.SearchParameterVOTransformer;
import transformer.backend.goodsList.vo.readin.checker.PageParameterVOChecker;

public class PageParameterVOTransformer extends VOReanInTransformerTemplate<PageParameteVO, PageParameterVODTO, CheckerException, PageParameterVOChecker> {

	private SearchParameterVOTransformer searchParameterVOTransformer;
	
	
	private static final PageParameterVOTransformer INSTANCE = new PageParameterVOTransformer();
	
	private PageParameterVOTransformer() {
		
		searchParameterVOTransformer = SearchParameterVOTransformer.getInstance();
	}
	
	public static PageParameterVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public PageParameterVODTO voToDto(PageParameteVO vo) throws CheckerException {

		PageParameterVODTO dto = new PageParameterVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));

		dto.setSearchParameter(searchParameterVOTransformer.voToDto(vo.getSearchParameter()));
		
		return dto;
	}

	@Override
	protected PageParameterVOChecker getChecker() {

		return PageParameterVOChecker.getInstance();
	}
}
