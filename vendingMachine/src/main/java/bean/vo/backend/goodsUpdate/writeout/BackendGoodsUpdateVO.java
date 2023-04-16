package bean.vo.backend.goodsUpdate.writeout;

public class BackendGoodsUpdateVO {

	private UpdateFormVO updateForm;

	public BackendGoodsUpdateVO() {
	}
	public BackendGoodsUpdateVO(UpdateFormVO updateForm) {

		this.updateForm = updateForm;
	}
	
	
	public UpdateFormVO getUpdateForm() {
		return updateForm;
	}
	
	
	public void setUpdateForm(UpdateFormVO updateForm) {
		this.updateForm = updateForm;
	}
}
