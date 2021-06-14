package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CsDTO;
import dto.UserDTO;


public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;



	public UserDAO() {



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








	//ȸ������ �޼ҵ�
	public int join(UserDTO user) {


		try {


			String sql = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getCus_id());
			pstmt.setString(2, user.getCus_pw());
			pstmt.setString(3, user.getCus_name());
			pstmt.setString(4, user.getCus_add());
			pstmt.setString(5, user.getCus_phone());
			pstmt.setString(6, user.getCus_email());

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}//end join


	//�α��� �޼ҵ�
	public int login(String cus_id, String cus_pw) {
		String sql = "SELECT cus_pw FROM CUSTOMER WHERE cus_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(cus_pw)) {
					return 1;//�α��� ����
				} else {
					return 0; //��й�ȣ ����ġ
				}

			}
			return -1;//���̵� ����

		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
	}//end login


	//ȸ��Ż�� �޼ҵ�
	public int deleteMember(String cus_id) {
		String sql = "delete FROM CUSTOMER WHERE cus_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1; //�����ͺ��̽� ����
	}//end deleteMember	


	//ȸ������ ���� �޼ҵ�
	public int updateMember(String cus_pw, String cus_name, String cus_add, String cus_phone, String cus_email, String cus_id) {

		String sql = "update customer set cus_pw = ?, cus_name = ?, cus_add = ?, cus_phone = ?, cus_email = ? where cus_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_pw);
			pstmt.setString(2, cus_name);
			pstmt.setString(3, cus_add);
			pstmt.setString(4, cus_phone);
			pstmt.setString(5, cus_email);
			pstmt.setString(6, cus_id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //db����
	}//end updateMember


	//�������� ����ϱ� ���� �Լ�
	public ArrayList<UserDTO> getUsers() {
		String sql = "select * from customer";
		ArrayList<UserDTO> ulist = new ArrayList<UserDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				UserDTO userDTO = new UserDTO();

				userDTO.setCus_id(rs.getString(1));
				userDTO.setCus_pw(rs.getString(2));
				userDTO.setCus_name(rs.getString(3));
				userDTO.setCus_add(rs.getString(4));
				userDTO.setCus_phone(rs.getString(5));
				userDTO.setCus_email(rs.getString(6));
				ulist.add(userDTO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return ulist;
	}


















}
