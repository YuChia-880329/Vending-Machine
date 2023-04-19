package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

public class GoodsTableEntryOBJDTO {

	private int id;
	private GoodsCardOBJDTO goodsCard;
	private GoodsIntroductionOBJDTO goodsIntroduction;
	
	
	public GoodsTableEntryOBJDTO() {
	}
	public GoodsTableEntryOBJDTO(int id, GoodsCardOBJDTO goodsCard, GoodsIntroductionOBJDTO goodsIntroduction) {

		this.id = id;
		this.goodsCard = goodsCard;
		this.goodsIntroduction = goodsIntroduction;
	}
	
	
	public int getId() {
		return id;
	}
	public GoodsCardOBJDTO getGoodsCard() {
		return goodsCard;
	}
	public GoodsIntroductionOBJDTO getGoodsIntroduction() {
		return goodsIntroduction;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setGoodsCard(GoodsCardOBJDTO goodsCard) {
		this.goodsCard = goodsCard;
	}
	public void setGoodsIntroduction(GoodsIntroductionOBJDTO goodsIntroduction) {
		this.goodsIntroduction = goodsIntroduction;
	}
}
