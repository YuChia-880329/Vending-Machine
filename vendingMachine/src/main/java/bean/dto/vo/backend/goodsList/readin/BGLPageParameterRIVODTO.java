package bean.dto.vo.backend.goodsList.readin;

import bean.dto.vo.backend.goodsList.BGLSearchParameterVODTO;

public class BGLPageParameterRIVODTO {

	private Integer page;
	private BGLSearchParameterVODTO searchParameters;
	
	
	public BGLPageParameterRIVODTO() {
	}
	public BGLPageParameterRIVODTO(Integer page, BGLSearchParameterVODTO searchParameters) {
		
		this.page = page;
		this.searchParameters = searchParameters;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public BGLSearchParameterVODTO getSearchParameters() {
		return searchParameters;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setSearchParameters(BGLSearchParameterVODTO searchParameters) {
		this.searchParameters = searchParameters;
	}
}
