package bean.dto.frontend.vo.writeout;

public class GoodsTablePageVODTO {

	private GoodsTableVODTO goodsTable;

	public GoodsTablePageVODTO() {
	}
	public GoodsTablePageVODTO(GoodsTableVODTO goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public GoodsTableVODTO getGoodsTable() {
		return goodsTable;
	}
	
	public void setGoodsTable(GoodsTableVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
}
