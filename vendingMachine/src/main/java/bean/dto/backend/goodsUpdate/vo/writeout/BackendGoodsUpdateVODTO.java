package bean.dto.backend.goodsUpdate.vo.writeout;

public class BackendGoodsUpdateVODTO {

	private UpdateFormVODTO updateForm;

	public BackendGoodsUpdateVODTO() {
	}
	public BackendGoodsUpdateVODTO(UpdateFormVODTO updateForm) {

		this.updateForm = updateForm;
	}
	
	
	public UpdateFormVODTO getUpdateForm() {
		return updateForm;
	}
	
	
	public void setUpdateForm(UpdateFormVODTO updateForm) {
		this.updateForm = updateForm;
	}
}
