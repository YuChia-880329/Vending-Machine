package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePageOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
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
	public GoodsTablePageOBJDTO objToDto(GoodsTablePageOBJ obj) {
		
		GoodsTablePageOBJDTO dto = new GoodsTablePageOBJDTO();
		
		dto.setGoodsTable(goodsTableOBJTransformer.objToDto(obj.getGoodsTable()));
		
		return dto;
	}
}
