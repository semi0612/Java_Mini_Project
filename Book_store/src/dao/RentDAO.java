package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.RentDTO;


public class RentDAO {


	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;



	public RentDAO() {



		try {

			//데이터베이스 정보
			String url = "jdbc:mysql://localhost:3307/bookstore";
			String userId="root";
			String userPw="1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, userPw);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}




	//대여정보를 출력하기 위한 함수
	public ArrayList<RentDTO> getRents(String cus_id) {
		String sql = "select r_catagory, r_name, r_author, r_descriptionproduct from rent where cus_id = ?";
		ArrayList<RentDTO> rlist = new ArrayList<RentDTO>();
		try {
			RentDTO rentDTO = new RentDTO();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				rentDTO.setCus_id(rs.getString(1));
				rentDTO.setR_catagory(rs.getString(2));
				rentDTO.setR_name(rs.getString(3));
				rentDTO.setR_author(rs.getString(4));
				rentDTO.setR_descriptionproduct(rs.getString(5));
				
				rlist.add(rentDTO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return rlist;
	}



}
