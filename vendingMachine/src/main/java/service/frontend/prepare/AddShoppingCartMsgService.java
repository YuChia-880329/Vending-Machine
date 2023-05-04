package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgVODTO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;

public class AddShoppingCartMsgService {

	
	
	private static final AddShoppingCartMsgService INSTANCE = new AddShoppingCartMsgService();
	
	private AddShoppingCartMsgService() {
	}
	
	public static AddShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartLegalMsgVODTO prepare(AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO) {
		
		AddShoppingCartLegalMsgVODTO addShoppingCartMsgVODTO = new AddShoppingCartLegalMsgVODTO();
		
		List<AddShoppingCartMsgLineOBJDTO> addShoppingCartMsgLineOBJDTOs = addShoppingCartMsgLineCacheDAO.use(true);
	
		addShoppingCartMsgVODTO.setHasMsg(addShoppingCartMsgLineOBJDTOs.size()>0 ? true : false);
		addShoppingCartMsgVODTO.setLines(addShoppingCartMsgLineOBJsToAddShoppingCartMsgLineVOs(addShoppingCartMsgLineOBJDTOs));
		
		return addShoppingCartMsgVODTO;
	}
	
	private List<AddShoppingCartLegalMsgLineVODTO> addShoppingCartMsgLineOBJsToAddShoppingCartMsgLineVOs(List<AddShoppingCartMsgLineOBJDTO> addShoppingCartMsgLineOBJDTOs){
		
		return addShoppingCartMsgLineOBJDTOs.stream()
				.map(addShoppingCartMsgLineOBJDTO -> addShoppingCartMsgLineOBJToAddShoppingCartMsgLineVO(addShoppingCartMsgLineOBJDTO))
				.collect(Collectors.toList());
	}
	private AddShoppingCartLegalMsgLineVODTO addShoppingCartMsgLineOBJToAddShoppingCartMsgLineVO(AddShoppingCartMsgLineOBJDTO addShoppingCartMsgLineOBJDTO) {
		
		AddShoppingCartLegalMsgLineVODTO addShoppingCartMsgLineVODTO = new AddShoppingCartLegalMsgLineVODTO();
		
		addShoppingCartMsgLineVODTO.setName(addShoppingCartMsgLineOBJDTO.getName());
		addShoppingCartMsgLineVODTO.setAddQuantity(addShoppingCartMsgLineOBJDTO.getAddQuantity());
		
		return addShoppingCartMsgLineVODTO;
	}
}
