package memory.repository.backend.goodsList.goodsTablePages;

class GoodsTablePageObj {

	private GoodsTableObj goodsTable;

	GoodsTablePageObj() {
	}
	GoodsTablePageObj(GoodsTableObj goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	GoodsTableObj getGoodsTable() {
		return goodsTable;
	}
	
	void setGoodsTable(GoodsTableObj goodsTable) {
		this.goodsTable = goodsTable;
	}
}
