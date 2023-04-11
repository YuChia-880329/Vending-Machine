package bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.SearchParameterOBJDTO;

public class GoodsTablePagesInputOBJDTO {

	private SearchParameterOBJDTO searchParameter;
	private int currentPage;
	
	
	public GoodsTablePagesInputOBJDTO() {

	}
	public GoodsTablePagesInputOBJDTO(SearchParameterOBJDTO searchParameter, int currentPage) {

		this.searchParameter = searchParameter;
		this.currentPage = currentPage;
	}
	
	
	public SearchParameterOBJDTO getSearchParameter() {
		return searchParameter;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
	public void setSearchParameter(SearchParameterOBJDTO searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
