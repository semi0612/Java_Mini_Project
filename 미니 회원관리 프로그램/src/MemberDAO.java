import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DB�� �����ϱ�
public class MemberDAO {
	// ����� DB�� ����Ŭ
	String driver = "oracle.jdbc.driver.OracleDriver";
	// IP �� ����ȣ��Ʈ�� �����ϴµ�, �̹����� ���÷� ����
	// @ȣ��Ʈ �̸� : ��Ʈ��ȣ : SID
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// ������ ���̵�� ��й�ȣ�� �־ �α����ϱ�
	String userid = "System";
	String passwd = "hb0317vd";

	public MemberDAO() {
		try {
			// ����Ŭ�� �ڹٿ��� �̿��ϱ� ���� JVM�� �÷��ذ�
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// �ۼ� ���� �� �÷������� ������ �ϴ� select�� ����
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		// connection ������ ���� �� �ʱ�ȭ
		Connection con = null;
		// PreparedStatement ���� �� �ʱ�ȭ
		// : SQL���� �ѹ��� �ۼ��ϰ� �����͸� ���߿� �߰��� �����ϸ� �۾��� �� �� �ִ� API
		// : ���ο� ���ڵ带 ������ �����ϴ� ���, �ѹ��� insert���� �����ϸ� �Ǳ� ������ �ߺ� �ڵ尡 ���ŵǴ� ������ �پ��
		// : ''�� ���� �������� �ʱ� ������ ���ܹ߻����� ��������
		PreparedStatement pstmt = null;
		// ��� �޾ƿò� ���� �� �ʱ�ȭ
		ResultSet rs = null;

		try {
			// ���� �ϱ�
			con = DriverManager.getConnection(url, userid, passwd);

			// DB�� ���� SQL�� �����
			String query = "select * from member";
			pstmt = con.prepareStatement(query);

			// pstmt�� ���� ������ �����ϰ� ����� rs�� ����
			rs = pstmt.executeQuery();

			// rs�� ����� �״ϱ� ���� �� �ڷᰡ �ִٸ� ��������
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				// columnIndex : ������ �÷� ��
				// �� ���������� �����ͼ�(getString)
				// dto�� setName()�� �־����
				dto.setName(rs.getString("name"));

				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				// ������ char�� ��������� ������ charAt(0) ���ֱ�
				dto.setSex(rs.getString("sex").charAt(0));

				// �ڷḦ list�� ���ϱ�
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		// ���� ������� �ʼ� ����
		} finally {
			try {
				if (rs != null) {	rs.close(); }
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
		return list;
	} // end select()


	// �ۼ����� �� MemberGUI�� �Է��� �����͸� MemberDAO Ŭ������ insert �޼ҵ忡 �Ѱ��ش�
	public void insert(String name, String age, String height, String weight, String sex ) {
         Connection con = null;
         PreparedStatement pstmt  = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// �Ѱ��� ��
	        String query = "insert into member(name, age, height, weight, sex) values (?, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(query);

			// ? ä���
			// (ù��° �ε�����, �̸��� �ְڴ�)
			pstmt.setString(1, name);
			// (�ι�° �ε�����, ���̸� �ְڴ�)
			pstmt.setInt(2, Integer.parseInt(age));
			pstmt.setInt(3, Integer.parseInt(height));
			pstmt.setInt(4, Integer.parseInt(weight));
			pstmt.setString(5, sex);
			
			// �ڹٿ��� ������ ��
			// : �˻��� executeQuery()
			// : ����, ����, ������ executeUpdate()
			
			// ������ �ڷ��� '����'�� ���ϵǴ� int�� ����
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
	}
	
	// delete�� �ۼ�
	public void delete(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String query = "delete from member where name=? ";
			pstmt = con.prepareStatement(query);
			
			// ? ä���
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
		}finally {
			try {
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
	}

	// �����ϱ�
	public void update(String name, String age, String height, String weight, String sex) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String query = "UPDATE member SET age=?, height=?, weight=?, sex=? WHERE name=?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(age));
			pstmt.setInt(2, Integer.parseInt(height));
			pstmt.setInt(3, Integer.parseInt(weight));
			pstmt.setString(4, sex);
			pstmt.setString(5, name);
			
			// ������ �ڷ��� '����'�� ���ϵǴ� int�� ����
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {	}
		finally {
			try {
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
	}

	
	// �˻��ϱ�
	public MemberDTO search(String name) throws RecordNotFoundException {
		// �߰� �ۼ�(����ó��)
		if( !isExist(name)) throw new RecordNotFoundException("ã�� ����� �����ϴ�");
		
		// �⺻ �ۼ�
		MemberDTO dto = new MemberDTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String query = "select * from member WHERE name=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			
			result = pstmt.executeQuery();
			
			// ���� �� �ڷᰡ �ִٸ� ��������
			while (result.next()) {
				dto.setName( result.getString("name"));
				dto.setAge( result.getInt("age"));
				dto.setHeight( result.getInt("height"));
				dto.setWeight( result.getInt("weight"));
				dto.setSex( result.getString("sex").charAt(0));
			}
		} catch (SQLException e) {	}
		// ���� ������� �ʼ� ����
		finally {
			try {
				if (result != null) { result.close(); }
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
		return dto;
	}

	// ����ó�� : DB�� �ش� �̸��� �����ϴ��� ã�ƺ���
	public boolean isExist(String name) {
		boolean result = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String query = "select * from member where name=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	result = true;	}
		} catch (SQLException e) {	}
		finally {
			try {
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
		return result;
	}
}
