package bean.dto.vo.frontend.writeout;

import java.util.List;

public class FGoodsTableWOVODTO {

	private List<FGTGoodsWOVODTO> goods;

	public FGoodsTableWOVODTO() {
	}
	public FGoodsTableWOVODTO(List<FGTGoodsWOVODTO> goods) {

		this.goods = goods;
	}
	
	
	public List<FGTGoodsWOVODTO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<FGTGoodsWOVODTO> goods) {
		this.goods = goods;
	}
}
