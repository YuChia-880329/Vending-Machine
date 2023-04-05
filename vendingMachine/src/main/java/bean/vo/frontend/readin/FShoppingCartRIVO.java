package bean.vo.frontend.readin;

import java.util.List;

public class FShoppingCartRIVO {

	private List<FSCGoodsRIVO> goods;

	public FShoppingCartRIVO() {
	}
	public FShoppingCartRIVO(List<FSCGoodsRIVO> goods) {
		this.goods = goods;
	}
	
	
	public List<FSCGoodsRIVO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<FSCGoodsRIVO> goods) {
		this.goods = goods;
	}
}
