package bean.vo.backend.goodsList.writeout;

public class GoodsTableVO {

	private GoodsTableRowVO[] goodsTableRows;

	public GoodsTableVO() {
	}
	public GoodsTableVO(GoodsTableRowVO[] goodsTableRows) {

		this.goodsTableRows = goodsTableRows;
	}
	
	
	public GoodsTableRowVO[] getGoodsTableRows() {
		return goodsTableRows;
	}
	
	public void setGoodsTableRows(GoodsTableRowVO[] goodsTableRows) {
		this.goodsTableRows = goodsTableRows;
	}
}
