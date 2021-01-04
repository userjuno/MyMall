package dvo;

public class OrderBean1 {
	private int order_no;
	private String goods_name;
	private String buyer;
	private String addr;
	private String addr_more;
	private String zipcode;
	private String phone;
	private String memo;
	private int price;
	private int trans_pay;
	private int or_count;
	private String img;
	private String order_id;
	private int totalMoney;
	private String order_date;
	private String order_state;
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public OrderBean1(String goods_name, String buyer, String addr, String phone, String memo, int price, int or_count,
			String img, String order_id, int totalMoney, String order_date, String order_state) {
		super();
		this.goods_name = goods_name;
		this.buyer = buyer;
		this.addr = addr;
		this.phone = phone;
		this.memo = memo;
		this.price = price;
		this.or_count = or_count;
		this.img = img;
		this.order_id = order_id;
		this.totalMoney = totalMoney;
		this.order_date = order_date;
		this.order_state = order_state;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getOrder_no() {
		return order_no;
	}
	public OrderBean1(int order_no, String goods_name, String buyer, String addr, String addr_more, String zipcode,
			String phone, String memo, int price, int trans_pay, int or_count,String img,String order_id) {
		super();
		this.order_no = order_no;
		this.goods_name = goods_name;
		this.buyer = buyer;
		this.addr = addr;
		this.addr_more = addr_more;
		this.zipcode = zipcode;
		this.phone = phone;
		this.memo = memo;
		this.price = price;
		this.trans_pay = trans_pay;
		this.or_count = or_count;
		this.img = img;
		this.order_id = order_id;
		
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr_more() {
		return addr_more;
	}
	public void setAddr_more(String addr_more) {
		this.addr_more = addr_more;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTrans_pay() {
		return trans_pay;
	}
	public void setTrans_pay(int trans_pay) {
		this.trans_pay = trans_pay;
	}
	public int getOr_count() {
		return or_count;
	}
	public void setOr_count(int or_count) {
		this.or_count = or_count;
	}
}
