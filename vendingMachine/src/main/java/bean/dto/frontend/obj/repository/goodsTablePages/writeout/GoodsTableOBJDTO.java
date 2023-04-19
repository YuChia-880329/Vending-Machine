package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJDTO {

	private List<GoodsTableEntryOBJDTO> goodsTableEntries;

	public GoodsTableOBJDTO() {
	}
	public GoodsTableOBJDTO(List<GoodsTableEntryOBJDTO> goodsTableEntries) {

		this.goodsTableEntries = goodsTableEntries;
	}
	
	
	public List<GoodsTableEntryOBJDTO> getGoodsTableEntries() {
		return goodsTableEntries;
	}
	
	
	public void setGoodsTableEntries(List<GoodsTableEntryOBJDTO> goodsTableEntries) {
		this.goodsTableEntries = goodsTableEntries;
	}
}
