package bean.dto.frontend.vo.writeout;

public class GoodsTableEntryVODTO {

	private int id;
	private int pageId;
	private GoodsCardVODTO goodsCard;
	private GoodsIntroductionVODTO goodsIntroduction;
	
	
	public GoodsTableEntryVODTO() {
	}
	public GoodsTableEntryVODTO(int id, int pageId, GoodsCardVODTO goodsCard, GoodsIntroductionVODTO goodsIntroduction) {

		this.id = id;
		this.pageId = pageId;
		this.goodsCard = goodsCard;
		this.goodsIntroduction = goodsIntroduction;
	}
	
	
	public int getId() {
		return id;
	}
	public int getPageId() {
		return pageId;
	}
	public GoodsCardVODTO getGoodsCard() {
		return goodsCard;
	}
	public GoodsIntroductionVODTO getGoodsIntroduction() {
		return goodsIntroduction;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public void setGoodsCard(GoodsCardVODTO goodsCard) {
		this.goodsCard = goodsCard;
	}
	public void setGoodsIntroduction(GoodsIntroductionVODTO goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}
}
