package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartMsgLineVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartMsgVODTO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import enumeration.Has;

public class AddShoppingCartMsgService {

	private static final AddShoppingCartMsgService INSTANCE = new AddShoppingCartMsgService();
	
	private AddShoppingCartMsgService() {
	}
	
	public static AddShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartMsgVODTO prepare(AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO) {
		
		AddShoppingCartMsgVODTO addShoppingCartMsgVODTO = new AddShoppingCartMsgVODTO();
		
		List<AddShoppingCartMsgLineOBJDTO> addShoppingCartMsgLineOBJDTOs = addShoppingCartMsgLineCacheDAO.use();
	
		addShoppingCartMsgVODTO.setHasMsg(addShoppingCartMsgLineOBJDTOs.size()>0 ? Has.TRUE : Has.FALSE);
		addShoppingCartMsgVODTO.setLines(addShoppingCartMsgLineOBJsToAddShoppingCartMsgLineVOs(addShoppingCartMsgLineOBJDTOs));
		
		return addShoppingCartMsgVODTO;
	}
	
	private List<AddShoppingCartMsgLineVODTO> addShoppingCartMsgLineOBJsToAddShoppingCartMsgLineVOs(List<AddShoppingCartMsgLineOBJDTO> addShoppingCartMsgLineOBJDTOs){
		
		return addShoppingCartMsgLineOBJDTOs.stream()
				.map(addShoppingCartMsgLineOBJDTO -> addShoppingCartMsgLineOBJToAddShoppingCartMsgLineVO(addShoppingCartMsgLineOBJDTO))
				.collect(Collectors.toList());
	}
	private AddShoppingCartMsgLineVODTO addShoppingCartMsgLineOBJToAddShoppingCartMsgLineVO(AddShoppingCartMsgLineOBJDTO addShoppingCartMsgLineOBJDTO) {
		
		AddShoppingCartMsgLineVODTO addShoppingCartMsgLineVODTO = new AddShoppingCartMsgLineVODTO();
		
		addShoppingCartMsgLineVODTO.setName(addShoppingCartMsgLineOBJDTO.getName());
		addShoppingCartMsgLineVODTO.setAddQuantity(addShoppingCartMsgLineOBJDTO.getAddQuantity());
		
		return addShoppingCartMsgLineVODTO;
	}
}
