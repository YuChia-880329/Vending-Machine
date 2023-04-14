package bean.dto.backend.goodsUpdate.vo.readin;

public class ChangeGoodsVODTO {

	private int id;

	public ChangeGoodsVODTO() {
	}
	public ChangeGoodsVODTO(int id) {

		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
}
