package transformer.backend.goodsList.obj.repository.goodsTablePages.writeout;

import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class GoodsTablePagesOBJTransformer extends RepositoryObjTransformerTemplate<GoodsTablePagesOBJ, GoodsTablePagesOBJDTO> {

	private GoodsTablePageOBJTransformer goodsTablePageOBJTransformer;
	private FilterParameterOBJTransformer filterParameterOBJTransformer;
	
	
	private static final GoodsTablePagesOBJTransformer INSTANCE = new GoodsTablePagesOBJTransformer();
	
	private GoodsTablePagesOBJTransformer() {

		goodsTablePageOBJTransformer = GoodsTablePageOBJTransformer.getInstance();
		filterParameterOBJTransformer = FilterParameterOBJTransformer.getInstance();
	}
	
	public static GoodsTablePagesOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsTablePagesOBJDTO objToDtoTransform(GoodsTablePagesOBJ obj) {
	
		GoodsTablePagesOBJDTO dto = new GoodsTablePagesOBJDTO();
		
		dto.setGoodsTablePageMap(obj.getGoodsTablePageMap().entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> goodsTablePageOBJTransformer.objToDto(entry.getValue()))));
		dto.setMaxPage(obj.getMaxPage());
		dto.setFilterParameter(filterParameterOBJTransformer.objToDto(obj.getFilterParameter()));
		
		return dto;
	}
}
