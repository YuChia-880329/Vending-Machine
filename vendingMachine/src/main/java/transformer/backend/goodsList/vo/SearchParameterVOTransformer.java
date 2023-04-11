package transformer.backend.goodsList.vo;

import bean.dto.backend.goodsList.vo.SearchParameterVODTO;
import bean.vo.backend.goodsList.SearchParameterVO;
import enumeration.Status;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOTransformerTemplate;
import transformer.backend.goodsList.vo.checker.SearchParameterVOChecker;

public class SearchParameterVOTransformer extends VOTransformerTemplate<SearchParameterVO, SearchParameterVODTO, CheckerException, SearchParameterVOChecker> {

	private static final SearchParameterVOTransformer INSTANCE = new SearchParameterVOTransformer();
	
	private SearchParameterVOTransformer() {
	}
	
	public static SearchParameterVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public SearchParameterVODTO voToDto(SearchParameterVO vo) throws CheckerException {
		
		SearchParameterVODTO dto = new SearchParameterVODTO();
		
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
	public SearchParameterVO dtoToVo(SearchParameterVODTO dto) {
		
		SearchParameterVO vo = new SearchParameterVO();
		
		Integer idMin = dto.getIdMin();
		vo.setIdMin(idMin==null ? "" : String.valueOf(idMin));
		
		Integer idMax = dto.getIdMax();
		vo.setIdMax(idMax==null ? "" : String.valueOf(idMax));
		
		String name = dto.getName();
		vo.setName(name==null ? "" : name);
		
		Integer priceMin = dto.getPriceMin();
		vo.setPriceMin(priceMin==null ? "" : String.valueOf(priceMin));
		
		Integer priceMax = dto.getPriceMax();
		vo.setPriceMax(priceMax==null ? "" : String.valueOf(priceMax));
		
		Integer quantityMin = dto.getQuantityMin();
		vo.setQuantityMin(quantityMin==null ? "" : String.valueOf(quantityMin));
		
		Integer quantityMax = dto.getQuantityMax();
		vo.setQuantityMax(quantityMax==null ? "" : String.valueOf(quantityMax));
		
		Status status = dto.getStatus();
		vo.setStatus(status==null ? "" : String.valueOf(status.getValue()));
		
		return vo;
	}

	@Override
	protected SearchParameterVOChecker getChecker() {
		
		return SearchParameterVOChecker.getInstance();
	}
}
