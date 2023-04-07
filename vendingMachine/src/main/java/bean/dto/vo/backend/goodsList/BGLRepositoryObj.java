package bean.dto.vo.backend.goodsList;

import java.util.List;

import bean.dto.model.GoodsModelDTO;

public class BGLRepositoryObj {

	private List<GoodsModelDTO> goodsPage;
	private int maxPage;
	private BGLRParameterDTO parameter;
	
	
	public BGLRepositoryObj() {
	}
	public BGLRepositoryObj(List<GoodsModelDTO> goodsPage, int maxPage, BGLRParameterDTO parameter) {

		this.goodsPage = goodsPage;
		this.maxPage = maxPage;
		this.parameter = parameter;
	}
	
	
	public List<GoodsModelDTO> getGoodsPage() {
		return goodsPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public BGLRParameterDTO getParameter() {
		return parameter;
	}
	
	


	public void setGoodsPage(List<GoodsModelDTO> goodsPage) {
		this.goodsPage = goodsPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setParameter(BGLRParameterDTO parameter) {
		this.parameter = parameter;
	}
}
