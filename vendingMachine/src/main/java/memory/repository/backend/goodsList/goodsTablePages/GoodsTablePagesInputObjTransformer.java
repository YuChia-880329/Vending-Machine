package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesInputDTO;
import template.memory.repository.RepositoryInputTransformerTemplate;

class GoodsTablePagesInputObjTransformer extends RepositoryInputTransformerTemplate<BGLGoodsTablePagesInputDTO, GoodsTablePagesInputObj> {

	private SearchParametersObjTransformer searchParametersObjTransformer;
	
	private static final GoodsTablePagesInputObjTransformer INSTANCE = new GoodsTablePagesInputObjTransformer();
	
	private GoodsTablePagesInputObjTransformer() {

		searchParametersObjTransformer = SearchParametersObjTransformer.getInstance();
	}
	
	static GoodsTablePagesInputObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePagesInputObj dtoToInput(BGLGoodsTablePagesInputDTO dto) {
		
		GoodsTablePagesInputObj obj = new GoodsTablePagesInputObj();
		
		obj.setSearchParameters(searchParametersObjTransformer.dtoToInput(dto.getSearchParameters()));
		obj.setCurrentPage(dto.getCurrentPage());
		
		return obj;
	}
	
	
}
