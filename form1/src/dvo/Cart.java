

package dvo;

import java.net.URLEncoder;

public class Cart {
	private String c_name;
	private int c_price;
	private int c_count;
	private String image;
	private String kind;
	private String order_id;
	private int total_money;
	private int sum;
	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	private String encodingKind;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getEncodingKind() {
		try{
			encodingKind = URLEncoder.encode(kind, "UTF-8");
			}
		catch(Exception e){
				e.printStackTrace();
			}
		return encodingKind;
	}

	public void setEncodingKind(String encodingKind) {
		this.encodingKind = encodingKind;
	}

	public String getC_name() {
		return c_name;
	}
	
	public Cart(String c_name, int c_price, int c_count,String image,String order_id,int total_money) {
		super();
		this.c_name = c_name;
		this.c_price = c_price;
		this.c_count = c_count;
		this.image = image;
		this.order_id = order_id;
		this.total_money = total_money;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
}
