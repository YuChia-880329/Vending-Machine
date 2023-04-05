package bean.dto.vo.frontend.writeout;

import java.util.List;

public class FrontendShoppingCartWOVODTO {

	private List<FSCGoodsWOVODTO> goods;

	public FrontendShoppingCartWOVODTO() {
	}
	public FrontendShoppingCartWOVODTO(List<FSCGoodsWOVODTO> goods) {

		this.goods = goods;
	}
	
	
	public List<FSCGoodsWOVODTO> getGoods() {
		return goods;
	}
	
	
	public void setGoods(List<FSCGoodsWOVODTO> goods) {
		this.goods = goods;
	}
}
