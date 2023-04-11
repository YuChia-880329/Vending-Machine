package bean.obj.repository.bglGoodsTablePages.writeout;

import java.util.List;

public class GoodsTableObj {

	private List<GoodsObj> goodsList;

	public GoodsTableObj() {
	}
	public GoodsTableObj(List<GoodsObj> goodsList) {

		this.goodsList = goodsList;
	}
	
	
	public List<GoodsObj> getGoodsList() {
		return goodsList;
	}
	
	
	public void setGoodsList(List<GoodsObj> goodsList) {
		this.goodsList = goodsList;
	}
}
