package transformer.backend.goodsList.obj.goodsTablePages.readin;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import template.memory.repository.RepositoryInputTransformerTemplate;
import transformer.backend.goodsList.obj.goodsTablePages.SearchParameterOBJTransformer;

public class GoodsTablePagesInputOBJTransformer extends RepositoryInputTransformerTemplate<GoodsTablePagesInputOBJDTO, GoodsTablePagesInputOBJ> {

	private SearchParameterOBJTransformer searchParameterOBJTransformer;
	
	private static final GoodsTablePagesInputOBJTransformer INSTANCE = new GoodsTablePagesInputOBJTransformer();
	
	private GoodsTablePagesInputOBJTransformer() {

		searchParameterOBJTransformer = SearchParameterOBJTransformer.getInstance();
	}
	
	public static GoodsTablePagesInputOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePagesInputOBJ dtoToInput(GoodsTablePagesInputOBJDTO dto) {
		
		GoodsTablePagesInputOBJ obj = new GoodsTablePagesInputOBJ();
		
		obj.setSearchParameter(searchParameterOBJTransformer.dtoToInput(dto.getSearchParameter()));
		obj.setCurrentPage(dto.getCurrentPage());
		
		return obj;
	}
	
	
}
