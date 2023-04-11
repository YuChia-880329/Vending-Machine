package bean.dto.backend.goodsList.vo.writeout;

public class BackendGoodsListVODTO {

	private GoodsTablePageVODTO goodsTablePage;
	private FilterFormVODTO filterForm;

	public BackendGoodsListVODTO() {
	}
	public BackendGoodsListVODTO(GoodsTablePageVODTO goodsTablePage, FilterFormVODTO filterForm) {

		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
	}
	
	
	public GoodsTablePageVODTO getGoodsTablePage() {
		return goodsTablePage;
	}
	public FilterFormVODTO getFilterForm() {
		return filterForm;
	}
	
	public void setGoodsTablePage(GoodsTablePageVODTO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setFilterForm(FilterFormVODTO filterForm) {
		this.filterForm = filterForm;
	}
}
