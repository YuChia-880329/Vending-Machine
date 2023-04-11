package bean.dto.obj.repository.bglGoodsTablePages.readin;

import bean.dto.vo.backend.goodsList.BGLSearchParameterVODTO;

public class BGLGoodsTablePagesInputRIOBJDTO {

	private BGLSearchParameterVODTO searchParameters;
	private int currentPage;
	
	
	public BGLGoodsTablePagesInputRIOBJDTO() {

	}
	public BGLGoodsTablePagesInputRIOBJDTO(BGLSearchParameterVODTO searchParameters, int currentPage) {

		this.searchParameters = searchParameters;
		this.currentPage = currentPage;
	}
	
	
	public BGLSearchParameterVODTO getSearchParameters() {
		return searchParameters;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
	public void setSearchParameters(BGLSearchParameterVODTO searchParameters) {
		this.searchParameters = searchParameters;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
