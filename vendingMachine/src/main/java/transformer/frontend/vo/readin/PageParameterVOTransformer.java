package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.vo.frontend.readin.PageParameterVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.PageParameterVOChecker;

public class PageParameterVOTransformer extends VOReanInTransformerTemplate<PageParameterVO, PageParameterVODTO, CheckerException, PageParameterVOChecker> {

	private static final PageParameterVOTransformer INSTANCE = new PageParameterVOTransformer();
	
	private PageParameterVOTransformer() {
	}
	
	public static PageParameterVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected PageParameterVODTO voToDtoTransform(PageParameterVO vo) throws CheckerException {

		PageParameterVODTO dto = new PageParameterVODTO();
		
		String page = vo.getPage();
		dto.setPage((page==null||"".equals(page)) ? null : Integer.parseInt(page));
		
		dto.setName(vo.getName());
		
		return dto;
	}

	@Override
	protected PageParameterVOChecker getChecker() {

		return PageParameterVOChecker.getInstance();
	}
}
