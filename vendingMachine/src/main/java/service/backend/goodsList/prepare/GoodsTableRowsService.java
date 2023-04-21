package service.backend.goodsList.prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePageOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableRowOBJDTO;
import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTableRowVODTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;

public class GoodsTableRowsService {

	private static final GoodsTableRowsService INSTANCE = new GoodsTableRowsService();
	
	private GoodsTableRowsService() {
	}
	
	public static GoodsTableRowsService getInstance() {
		
		return INSTANCE;
	}
	
	public List<GoodsTableRowVODTO> prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO){
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = pageParameterVOToGoodsTablePagesInputOBJ(pageParameterVODTO);
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO =  goodsTablePagesRepositoryDAO.getObjDto(goodsTablePagesInputOBJDTO);
		int currentPage = pageParameterVODTO.getPage();
		GoodsTablePageOBJDTO goodsTablePageOBJDTO = goodsTablePagesOBJDTO.getGoodsTablePageMap().get(currentPage);
		List<GoodsTableRowOBJDTO> goodsTableRowOBJDTOs = goodsTablePageOBJDTO==null ? new ArrayList<>() : goodsTablePageOBJDTO.getGoodsTable().getGoodsTableRows();
		return goodsTableRowOBJsToGoodsTableRowVOs(goodsTableRowOBJDTOs);
	}
	
	
	private GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();

		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage().intValue());
		goodsTablePagesInputOBJDTO.setIdMin(pageParameterVODTO.getIdMin());
		goodsTablePagesInputOBJDTO.setIdMax(pageParameterVODTO.getIdMax());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		goodsTablePagesInputOBJDTO.setPriceMin(pageParameterVODTO.getPriceMin());
		goodsTablePagesInputOBJDTO.setPriceMax(pageParameterVODTO.getPriceMax());
		goodsTablePagesInputOBJDTO.setQuantityMin(pageParameterVODTO.getQuantityMin());
		goodsTablePagesInputOBJDTO.setQuantityMax(pageParameterVODTO.getQuantityMax());
		goodsTablePagesInputOBJDTO.setStatus(pageParameterVODTO.getStatus());
		
		return goodsTablePagesInputOBJDTO;
	}
	
	private List<GoodsTableRowVODTO> goodsTableRowOBJsToGoodsTableRowVOs(List<GoodsTableRowOBJDTO> goodsOBJDTOs){
		
		return goodsOBJDTOs.stream()
				.map(goodsOBJDTO -> goodsTableRowOBJToGoodsTableRowVO(goodsOBJDTO))
				.collect(Collectors.toList());
	}
	private GoodsTableRowVODTO goodsTableRowOBJToGoodsTableRowVO(GoodsTableRowOBJDTO goodsOBJDTO){
		
		GoodsTableRowVODTO goodsTableRowVODTO = new GoodsTableRowVODTO();
		
		goodsTableRowVODTO.setId(goodsOBJDTO.getId());
		goodsTableRowVODTO.setName(goodsOBJDTO.getName());
		goodsTableRowVODTO.setPrice(goodsOBJDTO.getPrice());
		goodsTableRowVODTO.setQuantity(goodsOBJDTO.getQuantity());
		goodsTableRowVODTO.setStatus(goodsOBJDTO.getStatus());
		
		return goodsTableRowVODTO;
	}
}
