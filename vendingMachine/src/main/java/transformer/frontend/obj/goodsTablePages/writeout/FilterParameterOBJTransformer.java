package transformer.frontend.obj.goodsTablePages.writeout;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.FilterParameterOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.FilterParameterOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class FilterParameterOBJTransformer extends RepositoryObjTransformerTemplate<FilterParameterOBJ, FilterParameterOBJDTO> {

	private static final FilterParameterOBJTransformer INSTANCE = new FilterParameterOBJTransformer();
	
	private FilterParameterOBJTransformer() {
	}
	
	public static FilterParameterOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FilterParameterOBJDTO objToDtoTransform(FilterParameterOBJ obj) {
		
		FilterParameterOBJDTO dto = new FilterParameterOBJDTO();
		
		dto.setName(obj.getName());
		
		return dto;
	}
}
