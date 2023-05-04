package service.frontend.prepare;

import java.util.ArrayList;
import java.util.List;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsCardOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsIntroductionOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTableEntryOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.GoodsCardVODTO;
import bean.dto.frontend.vo.writeout.GoodsIntroductionVODTO;
import bean.dto.frontend.vo.writeout.GoodsTableEntryVODTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import util.StringConcatUtil;

public class GoodsTableEntriesService {

	private static final GoodsTableEntriesService INSTANCE = new GoodsTableEntriesService();
	
	private GoodsTableEntriesService() {
	}
	
	public static GoodsTableEntriesService getInstance() {
		
		return INSTANCE;
	}
	
	public List<GoodsTableEntryVODTO> prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectoryName){
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = pageParameterVOToGoodsTablePagesInputOBJ(pageParameterVODTO);
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO = goodsTablePagesRepositoryDAO.getObjDto(goodsTablePagesInputOBJDTO);
		int page = pageParameterVODTO.getPage();
		List<GoodsTableEntryOBJDTO> goodsTableEntryOBJDTOs = goodsTablePagesOBJDTO.getGoodsTablePageMap().get(page).getGoodsTable().getGoodsTableEntries();
		return goodsTableEntryOBJsToGoodsTableEntryVOs(goodsTableEntryOBJDTOs, shoppingCartMemoryDbDAO, imagesDirectoryName);
	}
	
	private GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();
		
		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		
		return goodsTablePagesInputOBJDTO;
	}
	
	private List<GoodsTableEntryVODTO> goodsTableEntryOBJsToGoodsTableEntryVOs(List<GoodsTableEntryOBJDTO> goodsTableEntryOBJDTOs, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectoryName){
		
		List<GoodsTableEntryVODTO> goodsTableEntryVODTOs = new ArrayList<>();
		
		for(int i=0; i<goodsTableEntryOBJDTOs.size(); i++) {
			
			goodsTableEntryVODTOs.add(goodsTableEntryOBJToGoodsTableEntryVO(goodsTableEntryOBJDTOs.get(i), shoppingCartMemoryDbDAO, imagesDirectoryName, i+1));
		}
		return goodsTableEntryVODTOs;
	}
	private GoodsTableEntryVODTO goodsTableEntryOBJToGoodsTableEntryVO(GoodsTableEntryOBJDTO goodsTableEntryOBJDTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectoryName, int pageId) {
		
		GoodsTableEntryVODTO goodsTableEntryVODTO = new GoodsTableEntryVODTO();
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(goodsTableEntryOBJDTO.getId());
		
		goodsTableEntryVODTO.setId(goodsTableEntryOBJDTO.getId());
		goodsTableEntryVODTO.setPageId(pageId);
		goodsTableEntryVODTO.setGoodsCard(goodsCardOBJToGoodsCardVO(goodsTableEntryOBJDTO.getGoodsCard(), imagesDirectoryName, shoppingCartOBJDTO));
		goodsTableEntryVODTO.setGoodsIntroduction(goodsIntroductionOBJToGoodsIntroductionVO(goodsTableEntryOBJDTO.getGoodsIntroduction(), imagesDirectoryName, shoppingCartOBJDTO));
		
		return goodsTableEntryVODTO;
	}
	private GoodsCardVODTO goodsCardOBJToGoodsCardVO(GoodsCardOBJDTO goodsCardOBJDTO, String imagesDirectoryName, ShoppingCartOBJDTO shoppingCartOBJDTO) {
		
		GoodsCardVODTO goodsCardVODTO = new GoodsCardVODTO();

		goodsCardVODTO.setName(goodsCardOBJDTO.getName());
		goodsCardVODTO.setPrice(goodsCardOBJDTO.getPrice());
		goodsCardVODTO.setImagePath(StringConcatUtil.concate(imagesDirectoryName, "/", goodsCardOBJDTO.getImageName()));
		goodsCardVODTO.setQuantity(goodsCardOBJDTO.getQuantity());
		
		return goodsCardVODTO;
	}
	private GoodsIntroductionVODTO goodsIntroductionOBJToGoodsIntroductionVO(GoodsIntroductionOBJDTO goodsIntroductionOBJDTO, String imagesDirectoryName, 
			ShoppingCartOBJDTO shoppingCartOBJDTO) {
		
		GoodsIntroductionVODTO goodsIntroductionVODTO = new GoodsIntroductionVODTO();
		
		goodsIntroductionVODTO.setName(goodsIntroductionOBJDTO.getName());
		goodsIntroductionVODTO.setImagePath(StringConcatUtil.concate(imagesDirectoryName, "/", goodsIntroductionOBJDTO.getImageName()));
		goodsIntroductionVODTO.setDescription(goodsIntroductionOBJDTO.getDescription());
		goodsIntroductionVODTO.setPrice(goodsIntroductionOBJDTO.getPrice());
		goodsIntroductionVODTO.setQuantity(goodsIntroductionOBJDTO.getQuantity());
		goodsIntroductionVODTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
		
		return goodsIntroductionVODTO;
	}
	
}
