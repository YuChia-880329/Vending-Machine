package transformer.frontend.obj.goodsTablePages.writeout;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePageOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTablePageOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTablePageOBJ, GoodsTablePageOBJDTO> {

	private GoodsTableOBJTransformer goodsTableOBJTransformer;
	
	
	private static final GoodsTablePageOBJTransformer INSTANCE = new GoodsTablePageOBJTransformer();
	
	private GoodsTablePageOBJTransformer() {
		
		goodsTableOBJTransformer = GoodsTableOBJTransformer.getInstance();
	}
	
	public static GoodsTablePageOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTablePageOBJDTO objToDtoTransform(GoodsTablePageOBJ obj) {
		
		GoodsTablePageOBJDTO dto = new GoodsTablePageOBJDTO();
		
		dto.setGoodsTable(goodsTableOBJTransformer.objToDto(obj.getGoodsTable()));
		
		return dto;
	}
}
