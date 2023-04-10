package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.vo.backend.goodsList.BGLSearchParameterVODTO;
import template.memory.repository.RepositoryInputTransformerTemplate;

class SearchParametersObjTransformer extends RepositoryInputTransformerTemplate<BGLSearchParameterVODTO, SearchParametersObj> {

	private static final SearchParametersObjTransformer INSTANCE = new SearchParametersObjTransformer();
	
	private SearchParametersObjTransformer() {

	}
	
	static SearchParametersObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public SearchParametersObj dtoToInput(BGLSearchParameterVODTO dto) {
		
		SearchParametersObj obj = new SearchParametersObj();
		
		obj.setIdMin(dto.getIdMin());
		obj.setIdMax(dto.getIdMax());
		obj.setName(dto.getName());
		obj.setPriceMin(dto.getPriceMin());
		obj.setPriceMax(dto.getPriceMax());
		obj.setQuantityMin(dto.getQuantityMin());
		obj.setQuantityMax(dto.getQuantityMax());
		obj.setStatus(dto.getStatus());
		
		return obj;
	}
}
