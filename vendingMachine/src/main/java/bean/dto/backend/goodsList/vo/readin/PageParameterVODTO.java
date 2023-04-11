package bean.dto.backend.goodsList.vo.readin;

import bean.dto.backend.goodsList.vo.SearchParameterVODTO;

public class PageParameterVODTO {

	private Integer page;
	private SearchParameterVODTO searchParameter;
	
	
	public PageParameterVODTO() {
	}
	public PageParameterVODTO(Integer page, SearchParameterVODTO searchParameter) {
		
		this.page = page;
		this.searchParameter = searchParameter;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public SearchParameterVODTO getSearchParameter() {
		return searchParameter;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setSearchParameter(SearchParameterVODTO searchParameter) {
		this.searchParameter = searchParameter;
	}
}
