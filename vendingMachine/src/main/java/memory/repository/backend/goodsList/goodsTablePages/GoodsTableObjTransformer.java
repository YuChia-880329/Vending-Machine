package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.vo.backend.goodsList.BGLGoodsTableDTO;
import template.memory.repository.RepositoryObjTransformerTemplate;

class GoodsTableObjTransformer extends RepositoryObjTransformerTemplate<GoodsTableObj, BGLGoodsTableDTO> {

	private GoodsObjTransformer goodsObjTransformer;
	
	
	private static final GoodsTableObjTransformer INSTANCE = new GoodsTableObjTransformer();
	
	private GoodsTableObjTransformer() {
		
		goodsObjTransformer = GoodsObjTransformer.getInstance();
	}
	
	static GoodsTableObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTableDTO objToDto(GoodsTableObj obj) {
		
		BGLGoodsTableDTO dto = new BGLGoodsTableDTO();
		
		dto.setGoodsList(goodsObjTransformer.objListToDtoList(obj.getGoodsList()));
		
		return dto;
	}
}
