package service.frontend.prepare;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<GoodsTableEntryVODTO> prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectorySymbolicLinkName){
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = pageParameterVOToGoodsTablePagesInputOBJ(pageParameterVODTO);
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO = goodsTablePagesRepositoryDAO.getObjDto(goodsTablePagesInputOBJDTO);
		int page = pageParameterVODTO.getPage();
		List<GoodsTableEntryOBJDTO> goodsTableEntryOBJDTOs = goodsTablePagesOBJDTO.getGoodsTablePageMap().get(page).getGoodsTable().getGoodsTableEntries();
		return goodsTableEntryOBJsToGoodsTableEntryVOs(goodsTableEntryOBJDTOs, shoppingCartMemoryDbDAO, imagesDirectorySymbolicLinkName);
	}
	
	private GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();
		
		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		
		return goodsTablePagesInputOBJDTO;
	}
	
	private List<GoodsTableEntryVODTO> goodsTableEntryOBJsToGoodsTableEntryVOs(List<GoodsTableEntryOBJDTO> goodsTableEntryOBJDTOs, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectorySymbolicLinkName){
		
		return goodsTableEntryOBJDTOs.stream()
				.map(goodsTableEntryOBJDTO -> goodsTableEntryOBJToGoodsTableEntryVO(goodsTableEntryOBJDTO, shoppingCartMemoryDbDAO, imagesDirectorySymbolicLinkName))
				.collect(Collectors.toList());
	}
	private GoodsTableEntryVODTO goodsTableEntryOBJToGoodsTableEntryVO(GoodsTableEntryOBJDTO goodsTableEntryOBJDTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectorySymbolicLinkName) {
		
		GoodsTableEntryVODTO goodsTableEntryVODTO = new GoodsTableEntryVODTO();
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(goodsTableEntryOBJDTO.getId());
		
		goodsTableEntryVODTO.setId(goodsTableEntryOBJDTO.getId());
		goodsTableEntryVODTO.setGoodsCard(goodsCardOBJToGoodsCardVO(goodsTableEntryOBJDTO.getGoodsCard(), imagesDirectorySymbolicLinkName, shoppingCartOBJDTO));
		goodsTableEntryVODTO.setGoodsIntroduction(goodsIntroductionOBJToGoodsIntroductionVO(goodsTableEntryOBJDTO.getGoodsIntroduction(), imagesDirectorySymbolicLinkName, shoppingCartOBJDTO));
		
		return goodsTableEntryVODTO;
	}
	private GoodsCardVODTO goodsCardOBJToGoodsCardVO(GoodsCardOBJDTO goodsCardOBJDTO, String imagesDirectorySymbolicLinkName, ShoppingCartOBJDTO shoppingCartOBJDTO) {
		
		GoodsCardVODTO goodsCardVODTO = new GoodsCardVODTO();

		goodsCardVODTO.setName(goodsCardOBJDTO.getName());
		goodsCardVODTO.setPrice(goodsCardOBJDTO.getPrice());
		goodsCardVODTO.setImagePath(StringConcatUtil.concate(imagesDirectorySymbolicLinkName, File.separator, goodsCardOBJDTO.getImageName()));
		goodsCardVODTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
		goodsCardVODTO.setQuantity(goodsCardOBJDTO.getQuantity());
		
		return goodsCardVODTO;
	}
	private GoodsIntroductionVODTO goodsIntroductionOBJToGoodsIntroductionVO(GoodsIntroductionOBJDTO goodsIntroductionOBJDTO, String imagesDirectorySymbolicLinkName, 
			ShoppingCartOBJDTO shoppingCartOBJDTO) {
		
		GoodsIntroductionVODTO goodsIntroductionVODTO = new GoodsIntroductionVODTO();
		
		goodsIntroductionVODTO.setName(goodsIntroductionOBJDTO.getName());
		goodsIntroductionVODTO.setImagePath(StringConcatUtil.concate(imagesDirectorySymbolicLinkName, File.separator, goodsIntroductionOBJDTO.getImageName()));
		goodsIntroductionVODTO.setDescription(goodsIntroductionOBJDTO.getDescription());
		goodsIntroductionVODTO.setPrice(goodsIntroductionOBJDTO.getPrice());
		goodsIntroductionVODTO.setQuantity(goodsIntroductionOBJDTO.getQuantity());
		goodsIntroductionVODTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
		
		return goodsIntroductionVODTO;
	}
	
}
