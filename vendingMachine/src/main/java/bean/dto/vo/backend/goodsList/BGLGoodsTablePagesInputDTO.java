package bean.dto.vo.backend.goodsList;

public class BGLGoodsTablePagesInputDTO {

	private BGLSearchParameterVODTO searchParameters;
	private int currentPage;
	
	
	public BGLGoodsTablePagesInputDTO() {

	}
	public BGLGoodsTablePagesInputDTO(BGLSearchParameterVODTO searchParameters, int currentPage) {

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
