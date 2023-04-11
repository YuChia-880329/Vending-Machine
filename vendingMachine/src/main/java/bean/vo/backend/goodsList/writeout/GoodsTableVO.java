package bean.vo.backend.goodsList.writeout;

import java.util.List;

public class GoodsTableVO {

	private List<GoodsTableRowVO> goodsTableRows;

	public GoodsTableVO() {
	}
	public GoodsTableVO(List<GoodsTableRowVO> goodsTableRows) {

		this.goodsTableRows = goodsTableRows;
	}
	
	
	public List<GoodsTableRowVO> getGoodsTableRows() {
		return goodsTableRows;
	}
	
	public void setGoodsTableRows(List<GoodsTableRowVO> goodsTableRows) {
		this.goodsTableRows = goodsTableRows;
	}
}
