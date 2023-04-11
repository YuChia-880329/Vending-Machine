package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.FilterParameterOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.FilterParameterOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class FilterParameterOBJTransformer extends RepositoryObjTransformerTemplate<FilterParameterOBJ, FilterParameterOBJDTO> {

	private static final FilterParameterOBJTransformer INSTANCE = new FilterParameterOBJTransformer();
	
	private FilterParameterOBJTransformer() {
	}
	
	public static FilterParameterOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public FilterParameterOBJDTO objToDto(FilterParameterOBJ obj) {
		
		FilterParameterOBJDTO dto = new FilterParameterOBJDTO();
		
		dto.setIdMin(obj.getIdMin());
		dto.setIdMax(obj.getIdMax());
		dto.setName(obj.getName());
		dto.setPriceMin(obj.getPriceMin());
		dto.setPriceMax(obj.getPriceMax());
		dto.setQuantityMin(obj.getQuantityMin());
		dto.setQuantityMax(obj.getQuantityMax());
		dto.setStatus(obj.getStatus());
		
		return dto;
	}
}
