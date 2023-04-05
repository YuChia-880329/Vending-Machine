package bean.dto.vo.backend.goodsList.writeout;

import java.util.List;

public class BGLGoodsTableWOVODTO {

	private List<BGLGTGoodsWOVODTO> goods;

	public BGLGoodsTableWOVODTO() {
	}
	public BGLGoodsTableWOVODTO(List<BGLGTGoodsWOVODTO> goods) {

		this.goods = goods;
	}
	
	
	public List<BGLGTGoodsWOVODTO> getGoods() {
		return goods;
	}
	
	public void setGoods(List<BGLGTGoodsWOVODTO> goods) {
		this.goods = goods;
	}
}
