package service.backend.goodsCreate;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateMsgVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import service.model.GoodsModelService;

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
	
	public CreateResultVODTO create(CreateFormVODTO createFormVODTO) {
		
		GoodsModelDTO goodsModelDTO = createFormVOToGoodsModel(createFormVODTO);
		
		goodsModelDTO = goodsModelService.add(goodsModelDTO);
		CreateResultVODTO createResultVODTO = new CreateResultVODTO();
		
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
}
