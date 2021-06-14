package dto;

import java.io.Serializable;

public class Book_product implements Serializable {
	
	private String isbn; // 책 아이디
	private String catagory; // 카테고리
	private String name; // 책 이름
	private String author; // 책 작가
	private Integer unitPrice; // 상품 가격
	private String description; // 상품 설명
	private long unitsInStrock; // 재고수
	private String state; // 신상품, 중고품, 재고상품
	private String fileName; // 이미지 파일
	private int quantity; // 장바구니에 담은  개수
	
	public Book_product() { super();}
	public Book_product(String isbn, String name, Integer unitPrice) {
		this.isbn = isbn;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getUnitsInStrock() {
		return unitsInStrock;
	}
	public void setUnitsInStrock(long unitsInStrock) {
		this.unitsInStrock = unitsInStrock;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
