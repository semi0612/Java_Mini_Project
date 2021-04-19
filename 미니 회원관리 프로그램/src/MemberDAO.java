import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// DB와 연결하기
public class MemberDAO {
	// 사용할 DB는 오라클
	String driver = "oracle.jdbc.driver.OracleDriver";
	// IP 나 로컬호스트로 연결하는데, 이번에는 로컬로 연결
	// @호스트 이름 : 포트번호 : SID
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// 계정의 아이디와 비밀번호를 넣어서 로그인하기
	String userid = "System";
	String passwd = "hb0317vd";

	public MemberDAO() {
		try {
			// 오라클을 자바에서 이용하기 위해 JVM에 올려준것
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 컬렉션으로 리턴을 하는 select문 생성
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		// connection 맺을거 선언 및 초기화
		Connection con = null;
		// PreparedStatement 선언 및 초기화
		// : SQL문을 한번만 작성하고 데이터만 나중에 추가로 설정하면 작업을 할 수 있는 API
		// : 새로운 레코드를 여러번 저장하는 경우, 한번만 insert문을 생성하면 되기 때문에 중복 코드가 제거되니 성능이 뛰어나고
		// : ''을 직접 지정하지 않기 때문에 예외발생율이 적어진다
		PreparedStatement pstmt = null;
		// 결과 받아올꺼 선언 및 초기화
		ResultSet rs = null;

		try {
			// 연결 하기
			con = DriverManager.getConnection(url, userid, passwd);

			// DB에 보낼 SQL문 만들기
			String query = "select * from member";
			pstmt = con.prepareStatement(query);

			// pstmt로 보낸 문장을 실행하고 결과를 rs에 저장
			rs = pstmt.executeQuery();

			// rs에 저장된 그니까 리턴 된 자료가 있다면 가져오기
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				// columnIndex : 가져올 컬럼 명
				// 을 문자형으로 가져와서(getString)
				// dto의 setName()에 넣어줘라
				dto.setName(rs.getString("name"));

				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				// 성별을 char로 설정해줬기 때문에 charAt(0) 해주기
				dto.setSex(rs.getString("sex").charAt(0));

				// 자료를 list에 더하기
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		// 예외 상관없이 필수 실행
		} finally {
			try {
				if (rs != null) {	rs.close(); }
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
		return list;
	} // end select()


	// MemberGUI에 입력한 데이터를 MemberDAO 클래스의 insert 메소드에 넘겨준다
	public void insert(String name, String age, String height, String weight, String sex ) {
         Connection con = null;
         PreparedStatement pstmt  = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// 넘겨줄 것
	        String query = "insert into member(name, age, height, weight, sex) values (?, ?, ?, ?, ?) ";
			pstmt = con.prepareStatement(query);

			// ? 채우기
			// (첫번째 인덱스에, 이름을 넣겠다)
			pstmt.setString(1, name);
			// (두번째 인덱스에, 나이를 넣겠다)
			pstmt.setInt(2, Integer.parseInt(age));
			pstmt.setInt(3, Integer.parseInt(height));
			pstmt.setInt(4, Integer.parseInt(weight));
			pstmt.setString(5, sex);
			
			// 자바에서 실행할 때
			// : 검색은 executeQuery()
			// : 삽입, 삭제, 수정은 executeUpdate()
			
			// 삽입한 자료의 '갯수'가 리턴되니 int로 받음
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
	
	// delete문 작성
	public void delete(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String query = "delete from member where name=? ";
			pstmt = con.prepareStatement(query);
			
			// ? 채우기
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

	// 수정하기
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
			
			// 삽입한 자료의 '갯수'가 리턴되니 int로 받음
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {	}
		finally {
			try {
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
	}

	
	// 검색하기
	public MemberDTO search(String name) throws RecordNotFoundException {
		// 추가 작성(예외처리)
		if( !isExist(name)) throw new RecordNotFoundException("찾는 사람이 없습니다");
		
		// 기본 작성
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
			
			// 리턴 된 자료가 있다면 가져오기
			while (result.next()) {
				dto.setName( result.getString("name"));
				dto.setAge( result.getInt("age"));
				dto.setHeight( result.getInt("height"));
				dto.setWeight( result.getInt("weight"));
				dto.setSex( result.getString("sex").charAt(0));
			}
		} catch (SQLException e) {	}
		// 예외 상관없이 필수 실행
		finally {
			try {
				if (result != null) { result.close(); }
				if (pstmt != null) { pstmt.close();	}
				if (con != null) {	con.close();	}
			} catch (SQLException e) {	e.printStackTrace(); }
		}
		return dto;
	}

	// 예외처리 : DB에 해당 이름이 존재하는지 찾아보기
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
