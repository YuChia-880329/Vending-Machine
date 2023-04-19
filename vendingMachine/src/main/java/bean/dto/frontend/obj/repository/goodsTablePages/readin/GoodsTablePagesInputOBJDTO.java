package bean.dto.frontend.obj.repository.goodsTablePages.readin;

public class GoodsTablePagesInputOBJDTO {

	private int currentPage;
	private String name;
	
	public GoodsTablePagesInputOBJDTO() {
	}
	public GoodsTablePagesInputOBJDTO(int currentPage, String name) {

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
