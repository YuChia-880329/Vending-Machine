package memory.repository.backend.goodsList.goodsTablePages;

import java.util.List;

class GoodsTableObj {

	private List<GoodsObj> goodsList;

	GoodsTableObj() {
	}
	GoodsTableObj(List<GoodsObj> goodsList) {

		this.goodsList = goodsList;
	}
	
	
	List<GoodsObj> getGoodsList() {
		return goodsList;
	}
	
	
	void setGoodsList(List<GoodsObj> goodsList) {
		this.goodsList = goodsList;
	}
}
