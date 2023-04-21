package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FilterFormVODTO;

public class FilterFormService {

	private static final FilterFormService INSTANCE = new FilterFormService();
	
	private FilterFormService() {
	}
	
	public static FilterFormService getInstance() {
		
		return INSTANCE;
	}
	
	public FilterFormVODTO prepare(PageParameterVODTO pageParameterVODTO) {
		
		FilterFormVODTO filterFormVODTO = new FilterFormVODTO();
		
		filterFormVODTO.setName(pageParameterVODTO.getName());
		
		return filterFormVODTO;
	}
}
