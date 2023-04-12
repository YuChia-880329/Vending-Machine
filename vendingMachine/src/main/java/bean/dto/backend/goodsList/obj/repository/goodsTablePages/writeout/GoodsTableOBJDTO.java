package bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJDTO {

	private List<GoodsTableRowOBJDTO> goodsTableRows;

	public GoodsTableOBJDTO() {
	}
	public GoodsTableOBJDTO(List<GoodsTableRowOBJDTO> goodsTableRows) {

		this.goodsTableRows = goodsTableRows;
	}
	
	
	public List<GoodsTableRowOBJDTO> getGoodsTableRows() {
		return goodsTableRows;
	}
	
	
	public void setGoodsTableRows(List<GoodsTableRowOBJDTO> goodsTableRows) {
		this.goodsTableRows = goodsTableRows;
	}
}
