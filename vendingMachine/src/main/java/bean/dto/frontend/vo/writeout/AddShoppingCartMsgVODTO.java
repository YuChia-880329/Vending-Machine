package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class AddShoppingCartMsgVODTO {

	private Has hasMsg;
	private List<String> names;
	
	
	public AddShoppingCartMsgVODTO() {
	}
	public AddShoppingCartMsgVODTO(Has hasMsg, List<String> names) {

		this.hasMsg = hasMsg;
		this.names = names;
	}
	
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<String> getNames() {
		return names;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
}
