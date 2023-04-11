package bean.obj.repository.bglGoodsTablePages.writeout;

public class GoodsTablePageObj {

	private GoodsTableObj goodsTable;

	public GoodsTablePageObj() {
	}
	public GoodsTablePageObj(GoodsTableObj goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public GoodsTableObj getGoodsTable() {
		return goodsTable;
	}
	
	public void setGoodsTable(GoodsTableObj goodsTable) {
		this.goodsTable = goodsTable;
	}
}
