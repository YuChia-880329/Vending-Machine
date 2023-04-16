package service.backend.goodsList.prepare;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.FilterFormVODTO;

public class FilterFormService {

	private static final FilterFormService INSTANCE = new FilterFormService();
	
	private FilterFormService() {
	}
	
	public static FilterFormService getInstance() {
		
		return INSTANCE;
	}
	
	public FilterFormVODTO prepare(PageParameterVODTO pageParameterVODTO) {
		
		FilterFormVODTO filterFormVODTO = new FilterFormVODTO();
		
		filterFormVODTO.setIdMin(pageParameterVODTO.getIdMin());
		filterFormVODTO.setIdMax(pageParameterVODTO.getIdMax());
		filterFormVODTO.setName(pageParameterVODTO.getName());
		filterFormVODTO.setPriceMin(pageParameterVODTO.getPriceMin());
		filterFormVODTO.setPriceMax(pageParameterVODTO.getPriceMax());
		filterFormVODTO.setQuantityMin(pageParameterVODTO.getQuantityMin());
		filterFormVODTO.setQuantityMax(pageParameterVODTO.getQuantityMax());
		filterFormVODTO.setStatus(pageParameterVODTO.getStatus());
		
		return filterFormVODTO;
	}
}
