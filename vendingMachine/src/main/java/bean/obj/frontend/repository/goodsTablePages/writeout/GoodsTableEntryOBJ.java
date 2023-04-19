package bean.obj.frontend.repository.goodsTablePages.writeout;

public class GoodsTableEntryOBJ {

	private int id;
	private GoodsCardOBJ goodsCard;
	private GoodsIntroductionOBJ goodsIntroduction;
	
	
	public GoodsTableEntryOBJ() {
	}
	public GoodsTableEntryOBJ(int id, GoodsCardOBJ goodsCard, GoodsIntroductionOBJ goodsIntroduction) {

		this.id = id;
		this.goodsCard = goodsCard;
		this.goodsIntroduction = goodsIntroduction;
	}
	
	
	public int getId() {
		return id;
	}
	public GoodsCardOBJ getGoodsCard() {
		return goodsCard;
	}
	public GoodsIntroductionOBJ getGoodsIntroduction() {
		return goodsIntroduction;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setGoodsCard(GoodsCardOBJ goodsCard) {
		this.goodsCard = goodsCard;
	}
	public void setGoodsIntroduction(GoodsIntroductionOBJ goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}
}
