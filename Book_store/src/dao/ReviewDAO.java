package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.CsDTO;
import dto.ReviewDTO;

public class ReviewDAO {



	private Connection conn;
	private ResultSet rs;



	public ReviewDAO() {



		try {

			//데이터베이스 정보
			String url="jdbc:mysql://localhost:3306/bookstore";
			String userId="root";
			String userPw="$^!423*^&";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, userPw);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}



	//현재 날짜와 시간을 출력하는 함수 
	public String getDate() {
		String sql = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; //데이터베이스 오류

	}


	//다음 게시글의 번호를 가지고 있는 함수
	public int getNext() {
		String sql = "select review_no from reviewtable order by review_no desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1; //첫 번째 게시물
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}



	//글을 작성하는 함수
	public int reviewWrite(String review_title, String cus_id ,String p_name, String review) {
		String sql = "insert into reviewtable values(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());//도서번호
			pstmt.setString(2, review_title);//리뷰제목
			pstmt.setString(3, p_name);//도서명
			pstmt.setString(4, cus_id);//작성자
			pstmt.setString(5, getDate());//작성일
			pstmt.setString(6, review);//리뷰내용
			pstmt.setInt(7, 1);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}


	//글을 출력하기 위한 함수
	public ArrayList<ReviewDTO> getList(int pageNumber) {
		String sql = "select * from reviewtable where review_no < ? and review_available = 1 order by review_no desc limit 10";
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // getNext()함수가 다음으로 작성될 글에 대한 번호를 저장하고있기 때문
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO();

				reviewDTO.setReview_no(rs.getInt(1));
				reviewDTO.setReview_title(rs.getString(2));
				reviewDTO.setP_name(rs.getString(3));
				reviewDTO.setCus_id(rs.getString(4));
				reviewDTO.setReview_date(rs.getString(5));
				reviewDTO.setReview(rs.getString(6));
				reviewDTO.setReview_available(rs.getInt(7));
				list.add(reviewDTO);

			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	//페이징 처리 함수
	public boolean nextPage(int pageNumber) {


		String nextpageSql = "select * from reviewtable where review_no < ? and review_available = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(nextpageSql);
			pstmt.setInt(1, getNext() - (pageNumber -1) * 10); // getNext()함수가 다음 글에 대한 번호를 저장하고있기 때문
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}


	//특정 리뷰에 대한 상세 페이지 출력함수
	public ReviewDTO getDTO(int review_no) {


		String sql = "select * from reviewtable where review_no = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setReview_no(rs.getInt(1));
				reviewDTO.setReview_title(rs.getString(2));
				reviewDTO.setP_name(rs.getString(3));
				reviewDTO.setCus_id(rs.getString(4));
				reviewDTO.setReview_date(rs.getString(5));
				reviewDTO.setReview(rs.getString(6));
				reviewDTO.setReview_available(rs.getInt(7));

				return reviewDTO;

			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;



	}


	//리뷰 글 삭제
	public int delete(int review_no) {
		String sql = "update reviewtable set review_available = 0 where review_no =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류

	}



}
