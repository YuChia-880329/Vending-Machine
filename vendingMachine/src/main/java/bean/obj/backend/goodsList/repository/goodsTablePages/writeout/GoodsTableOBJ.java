package bean.obj.backend.goodsList.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJ {

	private List<GoodsOBJ> goodsList;

	public GoodsTableOBJ() {
	}
	public GoodsTableOBJ(List<GoodsOBJ> goodsList) {

		this.goodsList = goodsList;
	}
	
	
	public List<GoodsOBJ> getGoodsList() {
		return goodsList;
	}
	
	
	public void setGoodsList(List<GoodsOBJ> goodsList) {
		this.goodsList = goodsList;
	}
}
