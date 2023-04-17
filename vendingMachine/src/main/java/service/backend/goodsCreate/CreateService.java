package service.backend.goodsCreate;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateMsgVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import service.model.GoodsModelService;
import util.ImageUtil;
import util.StringConcatUtil;

public class CreateService {

	private static final String CREATE_MSG = "已新增商品 id %d, %s";
	
	
	private GoodsModelService goodsModelService;
	
	
	private static final CreateService INSTANCE = new CreateService();
	
	private CreateService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static CreateService getInstance() {
		
		return INSTANCE;
	}
	
	public CreateResultVODTO create(CreateFormVODTO createFormVODTO, String deployPath, String contextPath) {
		
		GoodsModelDTO goodsModelDTO = createFormVOToGoodsModel(createFormVODTO);
		
		goodsModelDTO = goodsModelService.add(goodsModelDTO);
		
		CreateResultVODTO createResultVODTO = new CreateResultVODTO();
		try {
			if(goodsModelDTO != null)
				uploadImage(createFormVODTO.getImagePart(), deployPath, contextPath);
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
		
		createResultVODTO.setCreateMsg(getCreateMsgVODTO(goodsModelDTO.getId(), goodsModelDTO.getName()));
		
		return createResultVODTO;
	}
	private GoodsModelDTO createFormVOToGoodsModel(CreateFormVODTO createFormVODTO) {
		
		GoodsModelDTO goodsModelDTO = new GoodsModelDTO();
		
		goodsModelDTO.setName(createFormVODTO.getName());
		goodsModelDTO.setDescription("");
		goodsModelDTO.setPrice(createFormVODTO.getPrice());
		goodsModelDTO.setQuantity(createFormVODTO.getQuantity());
		goodsModelDTO.setImageName(createFormVODTO.getImagePart().getSubmittedFileName());
		goodsModelDTO.setStatus(createFormVODTO.getStatus());
		
		return goodsModelDTO;
	}
	private CreateMsgVODTO getCreateMsgVODTO(int id, String name) {
		
		CreateMsgVODTO createMsgVODTO = new CreateMsgVODTO();
		
		createMsgVODTO.setMsg(String.format(CREATE_MSG, id, name));
		
		return createMsgVODTO;
	}
	private void uploadImage(Part imagePart, String deployPath, String contextPath) throws IOException {
		
		String imagePath = StringConcatUtil.concate(deployPath, File.separator, contextPath, File.separator, imagePart.getSubmittedFileName());
	
		ImageUtil.uploadImage(imagePart, imagePath);
	}
}
