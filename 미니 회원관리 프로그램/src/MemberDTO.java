/*
 �ڹ�-DB �����Ű��
 1. ����Ŭ����  Member ��� ����� ������ ���̺� ����
 2. ����Ŭ ����̹��� �ڹٿ� �ֱ�
 	-> jdbc(�ڹ� �����ͺ��̽� Ŀ�ؼ�) �� �ʿ�
 	-> ��ġ�� ������ JRE system Library -> Build path -> Configure Build path -> add External ARGs -> ������ jdbc ���� -> apply and close
 3. ȸ�� ���� �ڷḦ �����ϴ� Ŭ���� (MemberDTO)
 4. ������ ���̽��� ������ ������ �ְ�޴� Ŭ���� (MemberDAO) 
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
