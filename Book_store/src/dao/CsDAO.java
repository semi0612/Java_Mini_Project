package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.CsDTO;


public class CsDAO {

	private Connection conn;
	private ResultSet rs;



	public CsDAO() {



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
		String sql = "select cs_no from customerservice order by cs_no desc";
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
	public int write(String cs_title, String cus_id, String ask) {
		String sql = "insert into customerservice values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, cs_title);
			pstmt.setString(3, cus_id);
			pstmt.setString(4, getDate());
			pstmt.setString(5, ask);
			pstmt.setInt(6, 1);

			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}

	//���� ����ϱ� ���� �Լ�
	public ArrayList<CsDTO> getList(int pageNumber) {
		String sql = "select * from customerservice where cs_no < ? and cs_available = 1 order by cs_no desc limit 10";
		ArrayList<CsDTO> list = new ArrayList<CsDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // getNext()�Լ��� �������� �ۼ��� �ۿ� ���� ��ȣ�� �����ϰ��ֱ� ����
			rs = pstmt.executeQuery();

			while(rs.next()) {
				CsDTO csDTO = new CsDTO();

				csDTO.setCs_no(rs.getInt(1));
				csDTO.setCs_title(rs.getString(2));
				csDTO.setCus_id(rs.getString(3));
				csDTO.setCs_date(rs.getString(4));
				csDTO.setAsk(rs.getString(5));
				csDTO.setCs_available(rs.getInt(6));
				list.add(csDTO);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	//����¡ ó�� �Լ�
	public boolean nextPage(int pageNumber) {


		String sql = "select * from customerservice where cs_no < ? and cs_available = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
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


	public CsDTO getDTO(int cs_no) {


		String sql = "select * from customerservice where cs_no = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				CsDTO csDTO = new CsDTO();
				csDTO.setCs_no(rs.getInt(1));
				csDTO.setCs_title(rs.getString(2));
				csDTO.setCus_id(rs.getString(3));
				csDTO.setCs_date(rs.getString(4));
				csDTO.setAsk(rs.getString(5));
				csDTO.setCs_available(rs.getInt(6));
				return csDTO;

			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;



	}

	//������ �� ����
	public int update(int cs_no, String cs_title, String ask) {
		String sql = "update customerservice set cs_title =?, ask = ? where cs_no =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs_title);
			pstmt.setString(2, ask);
			pstmt.setInt(3, cs_no);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}

	//������ �� ����
	public int delete(int cs_no) {
		String sql = "update customerservice set cs_available = 0 where cs_no =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_no);
			return pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����

	}






}
