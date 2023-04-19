package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

import java.util.Map;

public class GoodsTablePagesOBJDTO {

	private Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap;
	private int maxPage;
	private FilterParameterOBJDTO filterParameter;
	
	
	public GoodsTablePagesOBJDTO() {
	}
	public GoodsTablePagesOBJDTO(Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap, int maxPage,
			FilterParameterOBJDTO filterParameter) {

		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
		this.filterParameter = filterParameter;
	}
	
	
	public Map<Integer, GoodsTablePageOBJDTO> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public FilterParameterOBJDTO getFilterParameter() {
		return filterParameter;
	}
	
	
	public void setGoodsTablePageMap(Map<Integer, GoodsTablePageOBJDTO> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setFilterParameter(FilterParameterOBJDTO filterParameter) {
		this.filterParameter = filterParameter;
	}
}
