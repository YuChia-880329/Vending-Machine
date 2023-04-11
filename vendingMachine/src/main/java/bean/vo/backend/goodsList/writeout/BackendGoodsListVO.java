package bean.vo.backend.goodsList.writeout;

public class BackendGoodsListVO {

	private GoodsTablePageVO goodsTablePage;

	
	public BackendGoodsListVO() {
	}
	public BackendGoodsListVO(GoodsTablePageVO goodsTablePage) {

		this.goodsTablePage = goodsTablePage;
	}
	
	
	public GoodsTablePageVO getGoodsTablePage() {
		return goodsTablePage;
	}
	
	public void setGoodsTablePage(GoodsTablePageVO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
}
