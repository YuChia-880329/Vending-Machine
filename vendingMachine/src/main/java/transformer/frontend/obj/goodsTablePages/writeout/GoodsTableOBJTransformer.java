package transformer.frontend.obj.goodsTablePages.writeout;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTableOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTableOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTableOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTableOBJ, GoodsTableOBJDTO> {

	private GoodsTableEntryOBJTransformer goodsTableEntryOBJTransformer;
	
	
	private static final GoodsTableOBJTransformer INSTANCE = new GoodsTableOBJTransformer();
	
	private GoodsTableOBJTransformer() {
		
		goodsTableEntryOBJTransformer = GoodsTableEntryOBJTransformer.getInstance();
	}
	
	public static GoodsTableOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected GoodsTableOBJDTO objToDtoTransform(GoodsTableOBJ obj) {
		
		GoodsTableOBJDTO dto = new GoodsTableOBJDTO();
		
		dto.setGoodsTableEntries(goodsTableEntryOBJTransformer.objListToDtoList(obj.getGoodsTableEntries()));
		
		return dto;
	}
}
