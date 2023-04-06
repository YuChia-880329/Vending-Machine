package bean.dto.vo.backend.goodsList;

import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.writeout.PaginationWOVODTO;

public class BGLGoodsRepositoryDTO {

	private BGLRParameterDTO parameter;
	private Map<Integer, List<GoodsModelDTO>> pages;
	private PaginationWOVODTO pagination;
	
	
	public BGLGoodsRepositoryDTO() {
	}
	public BGLGoodsRepositoryDTO(BGLRParameterDTO parameter, Map<Integer, List<GoodsModelDTO>> pages,
			PaginationWOVODTO pagination) {

		this.parameter = parameter;
		this.pages = pages;
		this.pagination = pagination;
	}




	public BGLRParameterDTO getParameter() {
		return parameter;
	}
	public Map<Integer, List<GoodsModelDTO>> getPages() {
		return pages;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}

	
	

	public void setParameter(BGLRParameterDTO parameter) {
		this.parameter = parameter;
	}
	public void setPages(Map<Integer, List<GoodsModelDTO>> pages) {
		this.pages = pages;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
