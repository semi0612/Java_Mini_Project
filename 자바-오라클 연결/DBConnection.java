/* 자바-DB 연결시키기
 
 오라클 드라이버를 자바 파일에 넣어주어야한다.
 	-> jdbc(자바 데이터베이스 커넥션) ≒ 오라클 드라이버
 	-> 설치된 곳에서 JRE system Library -> Build path -> Configure Build path -> add External ARGs -> 가져올 jdbc 선택 -> apply and close */

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// 사용할 DB는 오라클
	String driver = "oracle.jdbc.driver.OracleDriver";
	// IP 나 로컬호스트로 연결하는데, 이번에는 로컬로 연결
	// @호스트 이름 : 포트번호 : SID
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "오라클 DB에서 설정한 아이디";
	String passwd = "오라클 DB에서 설정한 비밀번호";

	public DBConnection() {
		try {
			// OracleDriver 클래스를 자바에서 이용하기 위해서 JVM에 올려주기
			Class.forName(driver);
			System.out.println("드라이브 연결 성공함");
			
			// connection으로 정보 넘겨주고 연결 하기
			DriverManager.getConnection(url, userid, passwd);
			System.out.println("오라클 연결 성공함");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 연결 실패함");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패함");
			e.printStackTrace();
		}
	}
}
