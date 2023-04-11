package transformer.backend.goodsList.obj.goodsTablePages.readin;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.readin.GoodsTablePagesInputOBJ;
import template.memory.repository.RepositoryInputTransformerTemplate;

public class GoodsTablePagesInputOBJTransformer extends RepositoryInputTransformerTemplate<GoodsTablePagesInputOBJDTO, GoodsTablePagesInputOBJ> {
	
	private static final GoodsTablePagesInputOBJTransformer INSTANCE = new GoodsTablePagesInputOBJTransformer();
	
	private GoodsTablePagesInputOBJTransformer() {
	}
	
	public static GoodsTablePagesInputOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePagesInputOBJ dtoToInput(GoodsTablePagesInputOBJDTO dto) {
		
		GoodsTablePagesInputOBJ obj = new GoodsTablePagesInputOBJ();
		
		obj.setCurrentPage(dto.getCurrentPage());
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
