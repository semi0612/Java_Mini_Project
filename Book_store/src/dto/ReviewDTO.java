package dto;

public class ReviewDTO {
	
	private int review_no; //리뷰번호
	private String review_title; //리뷰제목
	private String p_name; //도서명
	private String cus_id; //리뷰 작성자
	private String review_date; //리뷰작성 날짜
	private String review; //리뷰내용
	private int review_available; //리뷰의 삭제여부
	
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getReview_available() {
		return review_available;
	}
	public void setReview_available(int review_available) {
		this.review_available = review_available;
	}
	
	
	
	
	
	
	
	
	
	
	
}
