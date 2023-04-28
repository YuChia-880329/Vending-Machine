package service.backend.goodsCreate;

import java.io.IOException;
import java.sql.SQLException;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateMsgVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import enumeration.Has;
import service.model.GoodsModelService;

public class CreateService {
	
	private GoodsModelService goodsModelService;
	private UploadImageService uploadImageService;
	
	
	private static final CreateService INSTANCE = new CreateService();
	
	private CreateService() {
		
		goodsModelService = GoodsModelService.getInstance();
		uploadImageService = UploadImageService.getInstance();
	}
	
	public static CreateService getInstance() {
		
		return INSTANCE;
	}
	
	public CreateResultVODTO create(CreateFormVODTO createFormVODTO, String imagesDirectorySymbolicLinkName, 
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, 
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO) {
		
		GoodsModelDTO goodsModelDTO = createFormVOToGoodsModel(createFormVODTO);
		
		CreateMsgVODTO createMsgVODTO = new CreateMsgVODTO();
		try {
			
			goodsModelDTO = goodsModelService.add(goodsModelDTO);
			
			if(goodsModelDTO != null) {
				
				uploadImageService.upload(createFormVODTO.getImagePart(), imagesDirectorySymbolicLinkName);
				createMsgVODTO.setSuccess(Has.TRUE);
				goodsTablePagesRepositoryDAO.requireUpdate();
				frontendGoodsTablePagesRepositoryDAO.requireUpdate();
			}else {
				
				createMsgVODTO.setSuccess(Has.FALSE);
			}
		} catch (SQLException | IOException ex) {
			
			ex.printStackTrace();
			createMsgVODTO.setSuccess(Has.FALSE);
		}
		createMsgVODTO.setId(goodsModelDTO.getId());
		createMsgVODTO.setName(goodsModelDTO.getName());
		
		CreateResultVODTO createResultVODTO = new CreateResultVODTO();
		
		createResultVODTO.setCreateMsg(createMsgVODTO);
		
		return createResultVODTO;
	}
	private GoodsModelDTO createFormVOToGoodsModel(CreateFormVODTO createFormVODTO) {
		
		GoodsModelDTO goodsModelDTO = new GoodsModelDTO();
		
		goodsModelDTO.setName(createFormVODTO.getName());
		goodsModelDTO.setDescription(createFormVODTO.getDescription());
		goodsModelDTO.setPrice(createFormVODTO.getPrice());
		goodsModelDTO.setQuantity(createFormVODTO.getQuantity());
		goodsModelDTO.setImageName(createFormVODTO.getImagePart().getSubmittedFileName());
		goodsModelDTO.setStatus(createFormVODTO.getStatus());
		
		return goodsModelDTO;
	}
}
