package transformer.backend.goodsList.obj.goodsTablePages;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.SearchParameterOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.SearchParameterOBJ;
import template.memory.repository.RepositoryInputTransformerTemplate;

public class SearchParameterOBJTransformer extends RepositoryInputTransformerTemplate<SearchParameterOBJDTO, SearchParameterOBJ> {

	private static final SearchParameterOBJTransformer INSTANCE = new SearchParameterOBJTransformer();
	
	private SearchParameterOBJTransformer() {

	}
	
	public static SearchParameterOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public SearchParameterOBJ dtoToInput(SearchParameterOBJDTO dto) {
		
		SearchParameterOBJ obj = new SearchParameterOBJ();
		
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
