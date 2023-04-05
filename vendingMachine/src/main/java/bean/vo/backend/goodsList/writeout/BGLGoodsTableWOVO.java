package bean.vo.backend.goodsList.writeout;

import java.util.List;

public class BGLGoodsTableWOVO {

	private List<BGLGTGoodsWOVO> goods;

	public BGLGoodsTableWOVO() {
	}
	public BGLGoodsTableWOVO(List<BGLGTGoodsWOVO> goods) {

		this.goods = goods;
	}
	
	
	public List<BGLGTGoodsWOVO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<BGLGTGoodsWOVO> goods) {
		this.goods = goods;
	}
}
