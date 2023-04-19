package bean.dto.frontend.vo.writeout;

public class GoodsTableEntryVODTO {

	private int id;
	private GoodsCardVODTO goodsCard;
	private GoodsIntroductionVODTO goodsIntroduction;
	
	
	public GoodsTableEntryVODTO() {
	}
	public GoodsTableEntryVODTO(int id, GoodsCardVODTO goodsCard, GoodsIntroductionVODTO goodsIntroduction) {

		this.id = id;
		this.goodsCard = goodsCard;
		this.goodsIntroduction = goodsIntroduction;
	}
	
	
	public int getId() {
		return id;
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
	public void setGoodsCard(GoodsCardVODTO goodsCard) {
		this.goodsCard = goodsCard;
	}
	public void setGoodsIntroduction(GoodsIntroductionVODTO goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}
}
