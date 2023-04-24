package service.frontend.prepare;

import java.util.ArrayList;
import java.util.List;

import bean.dto.frontend.obj.memoryDb.illegalMsg.IllegalMsgOBJDTO;
import bean.dto.frontend.vo.writeout.IllegalMsgVODTO;
import dao.memory.memoryDb.frontend.IllegalMsgMemoryDbDAO;
import enumeration.Has;

public class IllegalMsgService {

	private static final IllegalMsgService INSTANCE = new IllegalMsgService();
	
	private IllegalMsgService() {
	}
	
	public static IllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public IllegalMsgVODTO prepare(IllegalMsgMemoryDbDAO illegalMsgMemoryDbDAO) {
		
		IllegalMsgVODTO illegalMsgVODTO = new IllegalMsgVODTO();
		illegalMsgVODTO.setHasMsg(Has.FALSE);
		illegalMsgVODTO.setMsgs(new ArrayList<>());
		
		List<IllegalMsgOBJDTO> illegalMsgOBJDTOs = illegalMsgMemoryDbDAO.searchAll();
		
		for(IllegalMsgOBJDTO illegalMsgOBJDTO : illegalMsgOBJDTOs) {
			
			if(illegalMsgOBJDTO.getHasMsg() == Has.TRUE) {
				
				illegalMsgVODTO.setHasMsg(Has.FALSE);
				illegalMsgVODTO.getMsgs().addAll(illegalMsgOBJDTO.getMsgs());
			}
		}
		
		illegalMsgMemoryDbDAO.resetMemoryDb();
		
		return illegalMsgVODTO;
	}
	
}
