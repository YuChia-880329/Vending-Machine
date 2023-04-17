package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTableOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTableOBJ, GoodsTableOBJDTO> {

	private GoodsTableRowOBJTransformer goodsTableRowOBJTransformer;
	
	
	private static final GoodsTableOBJTransformer INSTANCE = new GoodsTableOBJTransformer();
	
	private GoodsTableOBJTransformer() {
		
		goodsTableRowOBJTransformer = GoodsTableRowOBJTransformer.getInstance();
	}
	
	public static GoodsTableOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTableOBJDTO objToDtoTransform(GoodsTableOBJ obj) {
		
		GoodsTableOBJDTO dto = new GoodsTableOBJDTO();
		
		dto.setGoodsTableRows(goodsTableRowOBJTransformer.objListToDtoList(obj.getGoodsTableRows()));
		
		return dto;
	}
}
