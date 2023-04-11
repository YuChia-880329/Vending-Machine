package bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout;

import java.util.Map;

public class GoodsTablePagesOBJDTO {

	private Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap;
	private int maxPage;
	
	
	public GoodsTablePagesOBJDTO() {
	}
	public GoodsTablePagesOBJDTO(Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap, int maxPage) {

		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
	}
	
	
	public Map<Integer, GoodsTablePageOBJDTO> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	

	public void setGoodsTablePageMap(Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
