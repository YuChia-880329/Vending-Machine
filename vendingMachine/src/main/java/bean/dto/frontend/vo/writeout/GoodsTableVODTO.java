package bean.dto.frontend.vo.writeout;

import java.util.List;

public class GoodsTableVODTO {

	private List<GoodsTableEntryVODTO> goodsTableEntries;

	public GoodsTableVODTO() {
	}
	public GoodsTableVODTO(List<GoodsTableEntryVODTO> goodsTableEntries) {

		this.goodsTableEntries = goodsTableEntries;
	}
	
	
	public List<GoodsTableEntryVODTO> getGoodsTableEntries() {
		return goodsTableEntries;
	}
	
	public void setGoodsTableEntries(List<GoodsTableEntryVODTO> goodsTableEntries) {
		this.goodsTableEntries = goodsTableEntries;
	}
}
