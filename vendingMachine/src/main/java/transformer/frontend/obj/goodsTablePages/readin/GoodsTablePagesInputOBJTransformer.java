package transformer.frontend.obj.goodsTablePages.readin;

import bean.dto.frontend.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import template.memory.repository.RepositoryInputTransformerTemplate;

public class GoodsTablePagesInputOBJTransformer extends RepositoryInputTransformerTemplate<GoodsTablePagesInputOBJDTO, GoodsTablePagesInputOBJ> {

	private static final GoodsTablePagesInputOBJTransformer INSTANCE = new GoodsTablePagesInputOBJTransformer();
	
	private GoodsTablePagesInputOBJTransformer() {
	}
	
	public static GoodsTablePagesInputOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTablePagesInputOBJ dtoToInputTransform(GoodsTablePagesInputOBJDTO dto) {
		
		GoodsTablePagesInputOBJ obj = new GoodsTablePagesInputOBJ();
		
		obj.setCurrentPage(dto.getCurrentPage());
		obj.setName(dto.getName());
		
		return obj;
	}
}
