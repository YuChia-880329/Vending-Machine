package transformer.frontend.obj.memoryDb.shoppingCart;

import java.util.ArrayList;

import bean.dto.frontend.obj.memoryDb.illegalMsg.IllegalMsgOBJDTO;
import bean.obj.frontend.memoryDb.illegalMsg.IllegalMsgOBJ;
import enumeration.Has;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class IllegalMsgOBJTransformer extends MemoryDbTransformerTemplate<Integer, IllegalMsgOBJ, IllegalMsgOBJDTO> {

	private int idCounter;
	
	
	private static final IllegalMsgOBJTransformer INSTANCE = new IllegalMsgOBJTransformer();

	private IllegalMsgOBJTransformer() {
		
		idCounter = 0;
	}
	
	public static IllegalMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public void resetIdCounter() {
		
		idCounter = 0;
	}
	
	
	@Override
	protected Integer getPkByDto(IllegalMsgOBJDTO dto) {
		
		idCounter++;
		
		return idCounter;
	}
	@Override
	protected IllegalMsgOBJ getObjByDto(IllegalMsgOBJDTO dto) {
		
		IllegalMsgOBJ obj = new IllegalMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		obj.setMsgs(dto.getMsgs());
		
		return obj;
	}
	@Override
	protected IllegalMsgOBJDTO paoToDtoTransform(PKAndObject<Integer, IllegalMsgOBJ> pao) {
		
		IllegalMsgOBJDTO dto = new IllegalMsgOBJDTO();
		
		IllegalMsgOBJ illegalMsgOBJ = pao.getObj();
		if(illegalMsgOBJ == null)
			illegalMsgOBJ = new IllegalMsgOBJ(Has.FALSE, new ArrayList<>());
		
		dto.setHasMsg(illegalMsgOBJ.getHasMsg());
		dto.setMsgs(illegalMsgOBJ.getMsgs());
		
		return dto;
	}

}
