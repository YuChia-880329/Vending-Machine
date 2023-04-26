package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJDTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgCacheDAO;
import enumeration.Has;

public class AddShoppingCartIllegalMsgService {

	private static final AddShoppingCartIllegalMsgService INSTANCE = new AddShoppingCartIllegalMsgService();
	
	private AddShoppingCartIllegalMsgService() {
	}
	
	public static AddShoppingCartIllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartIllegalMsgVODTO prepare(AddShoppingCartIllegalMsgCacheDAO addShoppingCartIllegalMsgCacheDAO) {
		
		AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsgVODTO = new AddShoppingCartIllegalMsgVODTO();
		
		List<AddShoppingCartIllegalMsgOBJDTO> nameOBJDTOs = addShoppingCartIllegalMsgCacheDAO.use();
		
		addShoppingCartIllegalMsgVODTO.setHasMsg(nameOBJDTOs.size()>0 ? Has.TRUE : Has.FALSE);
		addShoppingCartIllegalMsgVODTO.setNames(msgOBJToMsgVO(nameOBJDTOs));
		
		return addShoppingCartIllegalMsgVODTO;
	}
	
	private List<String> msgOBJToMsgVO(List<AddShoppingCartIllegalMsgOBJDTO> nameOBJDTOs) {
		
		return nameOBJDTOs.stream()
				.map(nameOBJDTO -> msgOBJToMsgVO(nameOBJDTO))
				.collect(Collectors.toList());
	}

	private String msgOBJToMsgVO(AddShoppingCartIllegalMsgOBJDTO nameOBJDTO) {
		
		return nameOBJDTO.getName();
	}
}
