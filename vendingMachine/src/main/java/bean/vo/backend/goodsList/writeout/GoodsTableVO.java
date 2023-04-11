package bean.vo.backend.goodsList.writeout;

import java.util.List;

public class GoodsTableVO {

	private List<GoodsTableRowVO> goodsTableRow;

	public GoodsTableVO() {
	}
	public GoodsTableVO(List<GoodsTableRowVO> goodsTableRow) {

		this.goodsTableRow = goodsTableRow;
	}
	
	
	public List<GoodsTableRowVO> getGoodsTableRow() {
		return goodsTableRow;
	}
	
	public void setGoodsTableRow(List<GoodsTableRowVO> goodsTableRow) {
		this.goodsTableRow = goodsTableRow;
	}
}
