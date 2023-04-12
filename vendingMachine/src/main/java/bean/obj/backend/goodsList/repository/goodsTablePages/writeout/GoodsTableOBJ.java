package bean.obj.backend.goodsList.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJ {

	private List<GoodsTableRowOBJ> goodsTableRows;

	public GoodsTableOBJ() {
	}
	public GoodsTableOBJ(List<GoodsTableRowOBJ> goodsTableRows) {

		this.goodsTableRows = goodsTableRows;
	}
	
	
	public List<GoodsTableRowOBJ> getGoodsTableRows() {
		return goodsTableRows;
	}
	
	
	public void setGoodsTableRows(List<GoodsTableRowOBJ> goodsTableRows) {
		this.goodsTableRows = goodsTableRows;
	}
}
