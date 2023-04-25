package transformer.frontend.obj.memoryDb.shoppingCart;

import java.util.ArrayList;

import bean.dto.frontend.obj.memoryDb.msg.MsgOBJDTO;
import bean.obj.frontend.memoryDb.msg.MsgOBJ;
import enumeration.Has;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class MsgOBJTransformer extends MemoryDbTransformerTemplate<Integer, MsgOBJ, MsgOBJDTO> {

	private int idCounter;
	
	
	private static final MsgOBJTransformer INSTANCE = new MsgOBJTransformer();

	private MsgOBJTransformer() {
		
		idCounter = 0;
	}
	
	public static MsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public void resetIdCounter() {
		
		idCounter = 0;
	}
	
	
	@Override
	protected Integer getPkByDto(MsgOBJDTO dto) {
		
		idCounter++;
		
		return idCounter;
	}
	@Override
	protected MsgOBJ getObjByDto(MsgOBJDTO dto) {
		
		MsgOBJ obj = new MsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		obj.setLines(dto.getLines());
		
		return obj;
	}
	@Override
	protected MsgOBJDTO paoToDtoTransform(PKAndObject<Integer, MsgOBJ> pao) {
		
		MsgOBJDTO dto = new MsgOBJDTO();
		
		MsgOBJ illegalMsgOBJ = pao.getObj();
		if(illegalMsgOBJ == null)
			illegalMsgOBJ = new MsgOBJ(Has.FALSE, new ArrayList<>());
		
		dto.setHasMsg(illegalMsgOBJ.getHasMsg());
		dto.setLines(illegalMsgOBJ.getLines());
		
		return dto;
	}

}
