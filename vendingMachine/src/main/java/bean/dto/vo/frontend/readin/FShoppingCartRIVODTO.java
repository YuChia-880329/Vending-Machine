package bean.dto.vo.frontend.readin;

import java.util.List;

public class FShoppingCartRIVODTO {

	private List<FSCGoodsRIVODTO> goods;

	public FShoppingCartRIVODTO() {
	}
	public FShoppingCartRIVODTO(List<FSCGoodsRIVODTO> goods) {
		this.goods = goods;
	}
	
	
	public List<FSCGoodsRIVODTO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<FSCGoodsRIVODTO> goods) {
		this.goods = goods;
	}
}
