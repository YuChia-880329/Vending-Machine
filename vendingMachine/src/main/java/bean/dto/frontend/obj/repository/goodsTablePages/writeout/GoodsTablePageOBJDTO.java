package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

public class GoodsTablePageOBJDTO {

	private GoodsTableOBJDTO goodsTable;

	public GoodsTablePageOBJDTO() {
	}
	public GoodsTablePageOBJDTO(GoodsTableOBJDTO goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public GoodsTableOBJDTO getGoodsTable() {
		return goodsTable;
	}
	
	
	public void setGoodsTable(GoodsTableOBJDTO goodsTable) {
		this.goodsTable = goodsTable;
	}
}
