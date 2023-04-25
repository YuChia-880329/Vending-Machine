package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartMsgVODTO;
import dao.memory.memoryDb.frontend.AddShoppingCartMsgMemoryDbDAO;
import enumeration.Has;

public class AddShoppingCartMsgService {

	private static final AddShoppingCartMsgService INSTANCE = new AddShoppingCartMsgService();
	
	private AddShoppingCartMsgService() {
	}
	
	public static AddShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartMsgVODTO prepare(AddShoppingCartMsgMemoryDbDAO addShoppingCartMsgMemoryDbDAO) {
		
		AddShoppingCartMsgVODTO addShoppingCartMsgVODTO = new AddShoppingCartMsgVODTO();
		
		List<AddShoppingCartMsgOBJDTO> nameOBJDTOs = addShoppingCartMsgMemoryDbDAO.searchAll();
		
		addShoppingCartMsgVODTO.setHasMsg(nameOBJDTOs.size()>0 ? Has.TRUE : Has.FALSE);
		addShoppingCartMsgVODTO.setNames(msgOBJToMsgVO(nameOBJDTOs));
		
		addShoppingCartMsgMemoryDbDAO.resetMemoryDb();
		
		return addShoppingCartMsgVODTO;
	}
	
	private List<String> msgOBJToMsgVO(List<AddShoppingCartMsgOBJDTO> nameOBJDTOs) {
		
		return nameOBJDTOs.stream()
				.map(nameOBJDTO -> msgOBJToMsgVO(nameOBJDTO))
				.collect(Collectors.toList());
	}

	private String msgOBJToMsgVO(AddShoppingCartMsgOBJDTO nameOBJDTO) {
		
		return nameOBJDTO.getName();
	}
}
