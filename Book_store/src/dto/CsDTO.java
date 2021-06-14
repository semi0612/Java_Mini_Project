package dto;


public class CsDTO {
	
	
	private int cs_no; //게시글의 번호 
	private String cs_title; //게시글 제목
	private String cus_id; //작성자
	private String cs_date; //작성날짜
	private String ask; //게시글 내용
	private int cs_available; // 게시글 삭제여부
	
	
	
	public int getCs_no() {
		return cs_no;
	}
	public void setCs_no(int cs_no) {
		this.cs_no = cs_no;
	}
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getCs_date() {
		return cs_date;
	}
	public void setCs_date(String cs_date) {
		this.cs_date = cs_date;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public int getCs_available() {
		return cs_available;
	}
	public void setCs_available(int cs_available) {
		this.cs_available = cs_available;
	}

	
	
	
	
	
	
}
