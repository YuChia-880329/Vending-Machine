package memory.repository.backend.goodsList.goodsTablePages;

import java.util.stream.Collectors;

import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesDTO;
import template.memory.repository.RepositoryObjTransformerTemplate;

class GoodsTablePagesObjTransformer extends RepositoryObjTransformerTemplate<GoodsTablePagesObj, BGLGoodsTablePagesDTO> {

	private GoodsTablePageObjTransformer goodsTablePageObjTransformer;
	
	
	private static final GoodsTablePagesObjTransformer INSTANCE = new GoodsTablePagesObjTransformer();
	
	private GoodsTablePagesObjTransformer() {

		goodsTablePageObjTransformer = GoodsTablePageObjTransformer.getInstance();
	}
	
	static GoodsTablePagesObjTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGLGoodsTablePagesDTO objToDto(GoodsTablePagesObj obj) {
	
		BGLGoodsTablePagesDTO dto = new BGLGoodsTablePagesDTO();
		
		dto.setGoodsTablePageMap(obj.getGoodsTablePageMap().entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> goodsTablePageObjTransformer.objToDto(entry.getValue()))));
		dto.setMaxPage(obj.getMaxPage());
		
		return dto;
	}
}
