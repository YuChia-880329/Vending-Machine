package bean.vo.backend.goodsList.writeout;

public class BackendGoodsListVO {

	private GoodsTablePageVO goodsTablePage;
	private FilterFormVO filterForm;

	
	public BackendGoodsListVO() {
	}
	public BackendGoodsListVO(GoodsTablePageVO goodsTablePage, FilterFormVO filterForm) {

		this.goodsTablePage = goodsTablePage;
		this.filterForm = filterForm;
	}
	
	
	public GoodsTablePageVO getGoodsTablePage() {
		return goodsTablePage;
	}
	public FilterFormVO getFilterForm() {
		return filterForm;
	}
	
	public void setGoodsTablePage(GoodsTablePageVO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setFilterForm(FilterFormVO filterForm) {
		this.filterForm = filterForm;
	}
}
