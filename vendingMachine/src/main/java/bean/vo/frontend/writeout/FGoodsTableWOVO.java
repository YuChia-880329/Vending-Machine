package bean.vo.frontend.writeout;

import java.util.List;

public class FGoodsTableWOVO {

	private List<FGTGoodsWOVO> goods;

	public FGoodsTableWOVO() {
	}
	public FGoodsTableWOVO(List<FGTGoodsWOVO> goods) {

		this.goods = goods;
	}
	
	
	public List<FGTGoodsWOVO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<FGTGoodsWOVO> goods) {
		this.goods = goods;
	}
}
