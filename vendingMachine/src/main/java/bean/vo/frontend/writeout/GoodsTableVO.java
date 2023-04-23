package bean.vo.frontend.writeout;

public class GoodsTableVO {

	private GoodsTableEntryVO[] goodsTableEntries;

	public GoodsTableVO() {
	}
	public GoodsTableVO(GoodsTableEntryVO[] goodsTableEntries) {

		this.goodsTableEntries = goodsTableEntries;
	}
	
	
	public GoodsTableEntryVO[] getGoodsTableEntries() {
		return goodsTableEntries;
	}
	
	public void setGoodsTableEntries(GoodsTableEntryVO[] goodsTableEntries) {
		this.goodsTableEntries = goodsTableEntries;
	}
}
