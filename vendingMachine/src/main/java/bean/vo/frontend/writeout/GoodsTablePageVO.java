package bean.vo.frontend.writeout;

public class GoodsTablePageVO {

	private GoodsTableVO goodsTable;

	public GoodsTablePageVO() {
	}
	public GoodsTablePageVO(GoodsTableVO goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public GoodsTableVO getGoodsTable() {
		return goodsTable;
	}
	
	
	public void setGoodsTable(GoodsTableVO goodsTable) {
		this.goodsTable = goodsTable;
	}
}
