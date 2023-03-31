package bean.vo.backend.goodsList.writeout;

import java.util.List;

public class BGLVO {

	private List<BGLGoodVO> goods;

	
	public BGLVO() {
	}
	public BGLVO(List<BGLGoodVO> goods) {
		
		this.goods = goods;
	}
	
	
	List<BGLGoodVO> getGoods() {
		return goods;
	}
	
	
	void setGoods(List<BGLGoodVO> goods) {
		this.goods = goods;
	}
}
