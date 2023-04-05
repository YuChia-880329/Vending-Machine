package bean.vo.frontend.writeout;

import java.util.List;

public class FrontendShoppingCartWOVO {

	private List<FSCGoodsWOVO> goods;

	public FrontendShoppingCartWOVO() {
	}
	public FrontendShoppingCartWOVO(List<FSCGoodsWOVO> goods) {

		this.goods = goods;
	}
	
	
	public List<FSCGoodsWOVO> getGoods() {
		return goods;
	}
	
	
	public void setGoods(List<FSCGoodsWOVO> goods) {
		this.goods = goods;
	}
}
