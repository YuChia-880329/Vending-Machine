package bean.vo.frontend.writeout;

public class GoodsTableEntryVO {

	private String id;
	private GoodsCardVO goodsCard;
	private GoodsIntroductionVO goodsIntroduction;
	
	
	public GoodsTableEntryVO() {
	}
	public GoodsTableEntryVO(String id, GoodsCardVO goodsCard, GoodsIntroductionVO goodsIntroduction) {

		this.id = id;
		this.goodsCard = goodsCard;
		this.goodsIntroduction = goodsIntroduction;
	}
	
	
	public String getId() {
		return id;
	}
	public GoodsCardVO getGoodsCard() {
		return goodsCard;
	}
	public GoodsIntroductionVO getGoodsIntroduction() {
		return goodsIntroduction;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setGoodsCard(GoodsCardVO goodsCard) {
		this.goodsCard = goodsCard;
	}
	public void setGoodsIntroduction(GoodsIntroductionVO goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}
}
