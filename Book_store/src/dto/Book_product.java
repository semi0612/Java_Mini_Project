package dto;

import java.io.Serializable;

public class Book_product implements Serializable {
	
	private String isbn; // å ���̵�
	private String catagory; // ī�װ�
	private String name; // å �̸�
	private String author; // å �۰�
	private Integer unitPrice; // ��ǰ ����
	private String description; // ��ǰ ����
	private long unitsInStrock; // ����
	private String state; // �Ż�ǰ, �߰�ǰ, ����ǰ
	private String fileName; // �̹��� ����
	private int quantity; // ��ٱ��Ͽ� ����  ����
	
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
