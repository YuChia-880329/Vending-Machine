package bean.dto.backend.goodsList.vo.writeout;

import java.util.List;

public class GoodsTableVODTO {

	private List<GoodsTableRowVODTO> goodsTableRows;

	public GoodsTableVODTO() {
	}
	public GoodsTableVODTO(List<GoodsTableRowVODTO> goodsTableRows) {

		this.goodsTableRows = goodsTableRows;
	}
	
	
	public List<GoodsTableRowVODTO> getGoodsTableRows() {
		return goodsTableRows;
	}
	
	public void setGoodsTableRows(List<GoodsTableRowVODTO> goodsTableRows) {
		this.goodsTableRows = goodsTableRows;
	}
}
