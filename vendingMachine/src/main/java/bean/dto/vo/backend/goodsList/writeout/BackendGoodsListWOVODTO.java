package bean.dto.vo.backend.goodsList.writeout;

public class BackendGoodsListWOVODTO {

	private BGLGoodsTablePageWOVODTO goodsTablePage;

	public BackendGoodsListWOVODTO() {
	}
	public BackendGoodsListWOVODTO(BGLGoodsTablePageWOVODTO goodsTablePage) {

		this.goodsTablePage = goodsTablePage;
	}
	
	
	public BGLGoodsTablePageWOVODTO getGoodsTablePage() {
		return goodsTablePage;
	}
	
	
	public void setGoodsTablePage(BGLGoodsTablePageWOVODTO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
}
