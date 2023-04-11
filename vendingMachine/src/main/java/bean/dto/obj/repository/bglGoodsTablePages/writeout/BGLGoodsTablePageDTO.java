package bean.dto.obj.repository.bglGoodsTablePages.writeout;

public class BGLGoodsTablePageDTO {

	private BGLGoodsTableDTO goodsTable;

	public BGLGoodsTablePageDTO() {
	}
	public BGLGoodsTablePageDTO(BGLGoodsTableDTO goodsTable) {

		this.goodsTable = goodsTable;
	}
	
	
	public BGLGoodsTableDTO getGoodsTable() {
		return goodsTable;
	}
	
	
	public void setGoodsTable(BGLGoodsTableDTO goodsTable) {
		this.goodsTable = goodsTable;
	}
}
