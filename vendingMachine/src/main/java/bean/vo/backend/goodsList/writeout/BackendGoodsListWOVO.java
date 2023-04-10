package bean.vo.backend.goodsList.writeout;

public class BackendGoodsListWOVO {

	private BGLGoodsTablePageWOVO goodsTablePage;

	
	public BackendGoodsListWOVO() {
	}
	public BackendGoodsListWOVO(BGLGoodsTablePageWOVO goodsTablePage) {

		this.goodsTablePage = goodsTablePage;
	}
	
	
	public BGLGoodsTablePageWOVO getGoodsTablePage() {
		return goodsTablePage;
	}
	
	public void setGoodsTablePage(BGLGoodsTablePageWOVO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
}
