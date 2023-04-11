package bean.dto.backend.goodsList.vo.writeout;

import java.util.List;

public class GoodsTableVODTO {

	private List<GoodsTableRowVODTO> goodsTableRow;

	public GoodsTableVODTO() {
	}
	public GoodsTableVODTO(List<GoodsTableRowVODTO> goodsTableRow) {

		this.goodsTableRow = goodsTableRow;
	}
	
	
	public List<GoodsTableRowVODTO> getGoodsTableRow() {
		return goodsTableRow;
	}
	
	public void setGoodsTableRow(List<GoodsTableRowVODTO> goodsTableRow) {
		this.goodsTableRow = goodsTableRow;
	}
}
