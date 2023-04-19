package bean.obj.frontend.repository.goodsTablePages.readin;

public class GoodsTablePagesInputOBJ {

	private int currentPage;
	private String name;
	
	
	public GoodsTablePagesInputOBJ() {
	}
	public GoodsTablePagesInputOBJ(int currentPage, String name) {

		this.currentPage = currentPage;
		this.name = name;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public String getName() {
		return name;
	}
	
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setName(String name) {
		this.name = name;
	}
}
