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

			//�����ͺ��̽� ����
			String url="jdbc:mysql://localhost:3306/bookstore";
			String userId="root";
			String userPw="$^!423*^&";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, userPw);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}



	//���� ��¥�� �ð��� ����ϴ� �Լ� 
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
		return ""; //�����ͺ��̽� ����

	}


	//���� �Խñ��� ��ȣ�� ������ �ִ� �Լ�
	public int getNext() {
		String sql = "select review_no from reviewtable order by review_no desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1; //ù ��° �Խù�
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}



	//���� �ۼ��ϴ� �Լ�
	public int reviewWrite(String review_title, String cus_id ,String p_name, String review) {
		String sql = "insert into reviewtable values(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());//������ȣ
			pstmt.setString(2, review_title);//��������
			pstmt.setString(3, p_name);//������
			pstmt.setString(4, cus_id);//�ۼ���
			pstmt.setString(5, getDate());//�ۼ���
			pstmt.setString(6, review);//���䳻��
			pstmt.setInt(7, 1);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}


	//���� ����ϱ� ���� �Լ�
	public ArrayList<ReviewDTO> getList(int pageNumber) {
		String sql = "select * from reviewtable where review_no < ? and review_available = 1 order by review_no desc limit 10";
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // getNext()�Լ��� �������� �ۼ��� �ۿ� ���� ��ȣ�� �����ϰ��ֱ� ����
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


	//����¡ ó�� �Լ�
	public boolean nextPage(int pageNumber) {


		String nextpageSql = "select * from reviewtable where review_no < ? and review_available = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(nextpageSql);
			pstmt.setInt(1, getNext() - (pageNumber -1) * 10); // getNext()�Լ��� ���� �ۿ� ���� ��ȣ�� �����ϰ��ֱ� ����
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}


	//Ư�� ���信 ���� �� ������ ����Լ�
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


	//���� �� ����
	public int delete(int review_no) {
		String sql = "update reviewtable set review_available = 0 where review_no =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_no);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����

	}



}
