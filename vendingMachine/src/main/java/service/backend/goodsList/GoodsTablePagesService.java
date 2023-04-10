package service.backend.goodsList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesDTO;
import bean.dto.vo.backend.goodsList.BGLGoodsTablePagesInputDTO;
import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGTGoodsWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTablePageWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTableWOVODTO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import memory.repository.backend.goodsList.goodsTablePages.GoodsTablePagesDAO;
import service.PaginationService;
import util.PaginationUtil;

public class GoodsTablePagesService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
	private PaginationService paginationService;
	private BGLUrlService bglUrlService;
	
	
	private static final GoodsTablePagesService INSTANCE = new GoodsTablePagesService();
	
	private GoodsTablePagesService() {
		
		paginationService = PaginationService.getInstance();
		bglUrlService = BGLUrlService.getInstance();
	}
	
	public static GoodsTablePagesService getInstance() {
		
		return INSTANCE;
	}
	
	public BGLGoodsTablePageWOVODTO prepare(BGLPageParameterRIVODTO pageParameter, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		BGLGoodsTablePageWOVODTO bglGoodsTablePageWOVODTO = new BGLGoodsTablePageWOVODTO();
		
		BGLGoodsTableWOVODTO bglGoodsTableWOVODTO = new BGLGoodsTableWOVODTO();
		
		BGLGoodsTablePagesDTO bglGoodsTablePagesDTO = goodsTablePagesDAO.getObjDto(transform(pageParameter));
		
		int currentPage = pageParameter.getPage();
		List<BGLGTGoodsWOVODTO> goods = transform(bglGoodsTablePagesDTO
				.getGoodsTablePageMap().get(currentPage)
				.getGoodsTable().getGoodsList());
		
		bglGoodsTableWOVODTO.setGoods(goods);
		
		int maxPage = bglGoodsTablePagesDTO.getMaxPage();
		bglGoodsTablePageWOVODTO.setGoodsTable(bglGoodsTableWOVODTO);
		bglGoodsTablePageWOVODTO.setSearchParameters(pageParameter.getSearchParameters());
		bglGoodsTablePageWOVODTO.setPagination(paginationService.getPagination(
				currentPage, 
				PaginationUtil.getStartPage(currentPage, PAGES_PER_PAGE_GROUP), 
				PaginationUtil.getEndPage(currentPage, PAGES_PER_PAGE_GROUP, maxPage), 
				maxPage, 
				bglUrlService.getUrlFctn(GoBackendGoodsListServlet.URL, pageParameter)));
		
		return bglGoodsTablePageWOVODTO;
	}
	
	
	private BGLGoodsTablePagesInputDTO transform(BGLPageParameterRIVODTO pageParameter) {
		
		BGLGoodsTablePagesInputDTO bglGoodsTablePagesInputDTO = new BGLGoodsTablePagesInputDTO();
		
		bglGoodsTablePagesInputDTO.setSearchParameters(pageParameter.getSearchParameters());
		bglGoodsTablePagesInputDTO.setCurrentPage(pageParameter.getPage());
		
		return bglGoodsTablePagesInputDTO;
	}
	
	private List<BGLGTGoodsWOVODTO> transform(List<GoodsModelDTO> goodsModelDTOList){
		
		return goodsModelDTOList.stream()
				.map(dto -> transform(dto))
				.collect(Collectors.toList());
	}
	private BGLGTGoodsWOVODTO transform(GoodsModelDTO goodsModelDTO) {
		
		BGLGTGoodsWOVODTO bglgtGoodsWOVODTO = new BGLGTGoodsWOVODTO();
		
		bglgtGoodsWOVODTO.setId(goodsModelDTO.getId());
		bglgtGoodsWOVODTO.setName(goodsModelDTO.getName());
		bglgtGoodsWOVODTO.setPrice(goodsModelDTO.getPrice());
		bglgtGoodsWOVODTO.setQuantity(goodsModelDTO.getQuantity());
		bglgtGoodsWOVODTO.setStatus(goodsModelDTO.getStatus());
		
		return bglgtGoodsWOVODTO;
	}
}
