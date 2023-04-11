package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTablePagesOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTablePagesOBJ, GoodsTablePagesOBJDTO> {

	private GoodsTablePageOBJTransformer goodsTablePageOBJTransformer;
	
	
	private static final GoodsTablePagesOBJTransformer INSTANCE = new GoodsTablePagesOBJTransformer();
	
	private GoodsTablePagesOBJTransformer() {

		goodsTablePageOBJTransformer = GoodsTablePageOBJTransformer.getInstance();
	}
	
	public static GoodsTablePagesOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsTablePagesOBJDTO objToDto(GoodsTablePagesOBJ obj) {
	
		GoodsTablePagesOBJDTO dto = new GoodsTablePagesOBJDTO();
		
		dto.setGoodsTablePageMap(obj.getGoodsTablePageMap().entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> goodsTablePageOBJTransformer.objToDto(entry.getValue()))));
		dto.setMaxPage(obj.getMaxPage());
		
		return dto;
	}
}
