package bean.obj.frontend.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJ {

	private List<GoodsTableEntryOBJ> goodsTableEntries;

	public GoodsTableOBJ() {
	}
	public GoodsTableOBJ(List<GoodsTableEntryOBJ> goodsTableEntries) {

		this.goodsTableEntries = goodsTableEntries;
	}
	
	
	public List<GoodsTableEntryOBJ> getGoodsTableEntries() {
		return goodsTableEntries;
	}
	
	
	public void setGoodsTableEntries(List<GoodsTableEntryOBJ> goodsTableEntries) {
		this.goodsTableEntries = goodsTableEntries;
	}
}
