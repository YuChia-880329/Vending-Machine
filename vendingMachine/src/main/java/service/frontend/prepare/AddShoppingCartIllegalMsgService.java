package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import enumeration.Has;

public class AddShoppingCartIllegalMsgService {

	private static final AddShoppingCartIllegalMsgService INSTANCE = new AddShoppingCartIllegalMsgService();
	
	private AddShoppingCartIllegalMsgService() {
	}
	
	public static AddShoppingCartIllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartIllegalMsgVODTO prepare(AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO) {
		
		AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsgVODTO = new AddShoppingCartIllegalMsgVODTO();
		
		List<AddShoppingCartIllegalMsgLineOBJDTO> addShoppingCartIllegalMsgLineOBJDTOs = addShoppingCartIllegalMsgLineCacheDAO.use(true);
		
		addShoppingCartIllegalMsgVODTO.setHasMsg(addShoppingCartIllegalMsgLineOBJDTOs.size()>0 ? Has.TRUE : Has.FALSE);
		addShoppingCartIllegalMsgVODTO.setLines(addShoppingCartIllegalMsgLineOBJsToAddShoppingCartIllegalMsgLineVOs(addShoppingCartIllegalMsgLineOBJDTOs));
		
		return addShoppingCartIllegalMsgVODTO;
	}
	
	private List<AddShoppingCartIllegalMsgLineVODTO> addShoppingCartIllegalMsgLineOBJsToAddShoppingCartIllegalMsgLineVOs(List<AddShoppingCartIllegalMsgLineOBJDTO> addShoppingCartIllegalMsgLineOBJDTOs) {
		
		return addShoppingCartIllegalMsgLineOBJDTOs.stream()
				.map(addShoppingCartIllegalMsgLineOBJDTO -> addShoppingCartIllegalMsgLineOBJToAddShoppingCartIllegalMsgLineVO(addShoppingCartIllegalMsgLineOBJDTO))
				.collect(Collectors.toList());
	}

	private AddShoppingCartIllegalMsgLineVODTO addShoppingCartIllegalMsgLineOBJToAddShoppingCartIllegalMsgLineVO(AddShoppingCartIllegalMsgLineOBJDTO addShoppingCartIllegalMsgLineOBJDTO) {
		
		AddShoppingCartIllegalMsgLineVODTO addShoppingCartIllegalMsgLineVODTO = new AddShoppingCartIllegalMsgLineVODTO();
		
		addShoppingCartIllegalMsgLineVODTO.setName(addShoppingCartIllegalMsgLineOBJDTO.getName());
		
		return addShoppingCartIllegalMsgLineVODTO;
	}
}
