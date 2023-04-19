package bean.obj.frontend.repository.goodsTablePages.writeout;

public class GoodsTablePageOBJ {

	private GoodsTableOBJ goodsTable;

	public GoodsTablePageOBJ() {
	}
	public GoodsTablePageOBJ(GoodsTableOBJ goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public GoodsTableOBJ getGoodsTable() {
		return goodsTable;
	}
	
	
	public void setGoodsTable(GoodsTableOBJ goodsTable) {
		this.goodsTable = goodsTable;
	}
}
