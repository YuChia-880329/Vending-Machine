package bean.dto.backend.goodsUpdate.vo.writeout;

import java.util.List;

import enumeration.Has;

public class UpdateFormVODTO {

	private List<GoodsNameOptionVODTO> goodsNameOptions;

	public UpdateFormVODTO() {
	}
	public UpdateFormVODTO(List<GoodsNameOptionVODTO> goodsNameOptions) {

		this.goodsNameOptions = goodsNameOptions;
	}
	
	
	public List<GoodsNameOptionVODTO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	
	
	public void setGoodsNameOptions(List<GoodsNameOptionVODTO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
}
