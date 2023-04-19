package bean.vo.frontend.writeout;

import java.util.List;

public class GoodsTableVO {

	private List<GoodsTableEntryVO> goodsTableEntries;

	public GoodsTableVO() {
	}
	public GoodsTableVO(List<GoodsTableEntryVO> goodsTableEntries) {

		this.goodsTableEntries = goodsTableEntries;
	}
	
	
	public List<GoodsTableEntryVO> getGoodsTableEntries() {
		return goodsTableEntries;
	}
	
	public void setGoodsTableEntries(List<GoodsTableEntryVO> goodsTableEntries) {
		this.goodsTableEntries = goodsTableEntries;
	}
}
