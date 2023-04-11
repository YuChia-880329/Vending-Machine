package bean.dto.obj.repository.bglGoodsTablePages.writeout;

import java.util.Map;

public class BGLGoodsTablePagesDTO {

	private Map<Integer, BGLGoodsTablePageDTO> goodsTablePageMap;
	private int maxPage;
	
	
	public BGLGoodsTablePagesDTO() {
	}
	public BGLGoodsTablePagesDTO(Map<Integer, BGLGoodsTablePageDTO> goodsTablePageMap, int maxPage) {

		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
	}
	
	
	public Map<Integer, BGLGoodsTablePageDTO> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	

	public void setGoodsTablePageMap(Map<Integer, BGLGoodsTablePageDTO> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
