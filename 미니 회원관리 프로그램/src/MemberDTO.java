/*
 자바-DB 연결시키기
 1. 오라클에서  Member 라는 사용할 데이터 테이블 생성
 2. 오라클 드라이버를 자바에 넣기
 	-> jdbc(자바 데이터베이스 커넥션) 이 필요
 	-> 설치된 곳에서 JRE system Library -> Build path -> Configure Build path -> add External ARGs -> 가져올 jdbc 선택 -> apply and close
 3. 회원 정보 자료를 관리하는 클래스 (MemberDTO)
 4. 데이터 베이스와 연결해 정보를 주고받는 클래스 (MemberDAO) 
 */
public class MemberDTO {
	String name;
	int age;
	int height;
	int weight;
	char sex;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	public int getWeight() { return weight; }
	public void setWeight(int weight) {	this.weight = weight; }
	
	public char getSex() { return sex; }
	public void setSex(char sex) {	this.sex = sex; }
}
