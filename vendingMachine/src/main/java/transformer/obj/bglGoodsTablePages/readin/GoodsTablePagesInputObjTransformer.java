package transformer.obj.bglGoodsTablePages.readin;

import bean.dto.obj.repository.bglGoodsTablePages.readin.BGLGoodsTablePagesInputRIOBJDTO;
import bean.obj.repository.bglGoodsTablePages.readin.GoodsTablePagesInputObj;
import template.memory.repository.RepositoryInputTransformerTemplate;
import transformer.obj.bglGoodsTablePages.SearchParametersObjTransformer;

public class GoodsTablePagesInputObjTransformer extends RepositoryInputTransformerTemplate<BGLGoodsTablePagesInputRIOBJDTO, GoodsTablePagesInputObj> {

	private SearchParametersObjTransformer searchParametersObjTransformer;
	
	private static final GoodsTablePagesInputObjTransformer INSTANCE = new GoodsTablePagesInputObjTransformer();
	
	private GoodsTablePagesInputObjTransformer() {

		searchParametersObjTransformer = SearchParametersObjTransformer.getInstance();
	}
	
	public static GoodsTablePagesInputObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePagesInputObj dtoToInput(BGLGoodsTablePagesInputRIOBJDTO dto) {
		
		GoodsTablePagesInputObj obj = new GoodsTablePagesInputObj();
		
		obj.setSearchParameters(searchParametersObjTransformer.dtoToInput(dto.getSearchParameters()));
		obj.setCurrentPage(dto.getCurrentPage());
		
		return obj;
	}
	
	
}
