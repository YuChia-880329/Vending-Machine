package service.frontend.prepare;

import java.util.ArrayList;
import java.util.List;

import bean.dto.frontend.obj.memoryDb.msg.MsgOBJDTO;
import bean.dto.frontend.vo.writeout.MsgVODTO;
import dao.memory.memoryDb.frontend.MsgMemoryDbDAO;
import enumeration.Has;

public class IllegalMsgService {

	private static final IllegalMsgService INSTANCE = new IllegalMsgService();
	
	private IllegalMsgService() {
	}
	
	public static IllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public MsgVODTO prepare(MsgMemoryDbDAO illegalMsgMemoryDbDAO) {
		
		MsgVODTO illegalMsgVODTO = new MsgVODTO();
		illegalMsgVODTO.setHasMsg(Has.FALSE);
		illegalMsgVODTO.setLines(new ArrayList<>());
		
		List<MsgOBJDTO> illegalMsgOBJDTOs = illegalMsgMemoryDbDAO.searchAll();
		
		for(MsgOBJDTO illegalMsgOBJDTO : illegalMsgOBJDTOs) {
			
			if(illegalMsgOBJDTO.getHasMsg() == Has.TRUE) {
				
				illegalMsgVODTO.setHasMsg(Has.FALSE);
				illegalMsgVODTO.getLines().addAll(illegalMsgOBJDTO.getLines());
			}
		}
		
		illegalMsgMemoryDbDAO.resetMemoryDb();
		
		return illegalMsgVODTO;
	}
	
}
