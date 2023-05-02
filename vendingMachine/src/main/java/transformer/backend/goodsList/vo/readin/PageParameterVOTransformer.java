package transformer.backend.goodsList.vo.readin;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.vo.backend.goodsList.readin.PageParameterVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.backend.goodsList.vo.readin.PageParameterVOChecker;

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

		String idMin = vo.getIdMin();
		dto.setIdMin((idMin==null||"".equals(idMin)) ? null : Integer.parseInt(idMin));
		
		String idMax = vo.getIdMax();
		dto.setIdMax((idMax==null||"".equals(idMax)) ? null : Integer.parseInt(idMax));
		
		dto.setName(vo.getName());
		
		String priceMin = vo.getPriceMin();
		dto.setPriceMin((priceMin==null||"".equals(priceMin)) ? null : Integer.parseInt(priceMin));
		
		String priceMax = vo.getPriceMax();
		dto.setPriceMax((priceMax==null||"".equals(priceMax)) ? null : Integer.parseInt(priceMax));
		
		String quantityMin = vo.getQuantityMin();
		dto.setQuantityMin((quantityMin==null||"".equals(quantityMin)) ? null : Integer.parseInt(quantityMin));
		
		String quantityMax = vo.getQuantityMax();
		dto.setQuantityMax((quantityMax==null||"".equals(quantityMax)) ? null : Integer.parseInt(quantityMax));
		
		String status = vo.getStatus();
		dto.setStatus((status==null||"".equals(status)) ? null : Status.getByValue(Integer.parseInt(status)));
		
		return dto;
	}

	@Override
	protected PageParameterVOChecker getChecker() {

		return PageParameterVOChecker.getInstance();
	}
}
