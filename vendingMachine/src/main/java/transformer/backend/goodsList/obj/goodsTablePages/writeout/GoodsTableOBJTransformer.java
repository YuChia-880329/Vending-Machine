package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTableOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTableOBJ, GoodsTableOBJDTO> {

	private GoodsOBJTransformer goodsOBJTransformer;
	
	
	private static final GoodsTableOBJTransformer INSTANCE = new GoodsTableOBJTransformer();
	
	private GoodsTableOBJTransformer() {
		
		goodsOBJTransformer = GoodsOBJTransformer.getInstance();
	}
	
	public static GoodsTableOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTableOBJDTO objToDto(GoodsTableOBJ obj) {
		
		GoodsTableOBJDTO dto = new GoodsTableOBJDTO();
		
		dto.setGoodsList(goodsOBJTransformer.objListToDtoList(obj.getGoodsList()));
		
		return dto;
	}
}
