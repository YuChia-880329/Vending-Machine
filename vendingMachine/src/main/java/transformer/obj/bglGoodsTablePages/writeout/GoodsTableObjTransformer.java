package transformer.obj.bglGoodsTablePages.writeout;

import bean.dto.obj.repository.bglGoodsTablePages.writeout.BGLGoodsTableDTO;
import bean.obj.repository.bglGoodsTablePages.writeout.GoodsTableObj;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTableObjTransformer extends RepositoryObjTransformerTemplate<GoodsTableObj, BGLGoodsTableDTO> {

	private GoodsObjTransformer goodsObjTransformer;
	
	
	private static final GoodsTableObjTransformer INSTANCE = new GoodsTableObjTransformer();
	
	private GoodsTableObjTransformer() {
		
		goodsObjTransformer = GoodsObjTransformer.getInstance();
	}
	
	public static GoodsTableObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTableDTO objToDto(GoodsTableObj obj) {
		
		BGLGoodsTableDTO dto = new BGLGoodsTableDTO();
		
		dto.setGoodsList(goodsObjTransformer.objListToDtoList(obj.getGoodsList()));
		
		return dto;
	}
}
