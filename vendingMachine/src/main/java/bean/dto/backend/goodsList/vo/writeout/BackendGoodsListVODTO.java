package bean.dto.backend.goodsList.vo.writeout;

public class BackendGoodsListVODTO {

	private GoodsTablePageVODTO goodsTablePage;

	public BackendGoodsListVODTO() {
	}
	public BackendGoodsListVODTO(GoodsTablePageVODTO goodsTablePage) {

		this.goodsTablePage = goodsTablePage;
	}
	
	
	public GoodsTablePageVODTO getGoodsTablePage() {
		return goodsTablePage;
	}
	
	
	public void setGoodsTablePage(GoodsTablePageVODTO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
}
