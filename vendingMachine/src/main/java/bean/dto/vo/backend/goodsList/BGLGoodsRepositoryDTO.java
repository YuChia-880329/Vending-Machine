package bean.dto.vo.backend.goodsList;

import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;

public class BGLGoodsRepositoryDTO {

	private BGLRParameterDTO parameter;
	private int maxPage;
	private Map<Integer, List<GoodsModelDTO>> goodsPages;
	
	
	public BGLGoodsRepositoryDTO() {
	}
	public BGLGoodsRepositoryDTO(BGLRParameterDTO parameter, int maxPage, Map<Integer, List<GoodsModelDTO>> goodsPages) {

		this.parameter = parameter;
		this.maxPage = maxPage;
		this.goodsPages = goodsPages;
	}




	public BGLRParameterDTO getParameter() {
		return parameter;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public Map<Integer, List<GoodsModelDTO>> getGoodsPages() {
		return goodsPages;
	}

	
	

	public void setParameter(BGLRParameterDTO parameter) {
		this.parameter = parameter;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setGoodsPages(Map<Integer, List<GoodsModelDTO>> goodsPages) {
		this.goodsPages = goodsPages;
	}
}
