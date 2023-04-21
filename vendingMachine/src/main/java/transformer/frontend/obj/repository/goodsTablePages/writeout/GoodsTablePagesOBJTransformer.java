package transformer.frontend.obj.repository.goodsTablePages.writeout;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePageOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePageOBJ;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTablePagesOBJ;
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
		
		Map<Integer, GoodsTablePageOBJ> goodsTablePageOBJMap = obj.getGoodsTablePageMap();
		Map<Integer, GoodsTablePageOBJDTO> goodsTablePageOBJDTOMap = goodsTablePageOBJMap==null ? new HashMap<>() : goodsTablePageOBJMap.entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> goodsTablePageOBJTransformer.objToDto(entry.getValue())));
		
		dto.setGoodsTablePageMap(goodsTablePageOBJDTOMap);
		dto.setMaxPage(obj.getMaxPage());
		dto.setFilterParameter(filterParameterOBJTransformer.objToDto(obj.getFilterParameter()));
		
		return dto;
	}
}
