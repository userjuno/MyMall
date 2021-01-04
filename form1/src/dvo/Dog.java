package dvo;

public class Dog {
	
	private int id;
	private String item_name;
	private int price;
	private String image;
	private String made;
	private String category;
	private int trans_pay;
	public Dog(int id, String item_name, int price, String image, String made, String category, int trans_pay,
			String content, int readcount) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.price = price;
		this.image = image;
		this.made = made;
		this.category = category;
		this.trans_pay = trans_pay;
		this.content = content;
		this.readcount = readcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getTrans_pay() {
		return trans_pay;
	}
	public void setTrans_pay(int trans_pay) {
		this.trans_pay = trans_pay;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	private String content;
	private int readcount;
	
	
}
