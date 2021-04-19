import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 현재 클래스 : 화면 설계
public class ManagerGUI {
	// 프레임 만들기
	Frame frame;
	// 판넬
	Panel[] panel;
	// 라벨(회원 관리에 사용할 것들)
	Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
	TextField tfName, tfHeight, tfAge, tfWeight;
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
	List list;
	Checkbox chMale, chFemale;
	CheckboxGroup chGroup;

	// 시작하자마자 윈도우 뜨도록
	public ManagerGUI() {
		frame = new Frame("회원관리");
		// 판넬 13개 준비하기
		panel = new Panel[13];
		for (int i = 0; i < panel.length; i++) {
			// i가 증가하면서 새로운 판넬 자리가 생성된다
			panel[i] = new Panel();
		}
		lblTitle = new Label("회원관리", Label.CENTER);
		// 폰트 설정
		Font font = new Font("dialog", Font.BOLD, 20);
		// 폰트 설정을 라벨 타이틀에 붙이기
		lblTitle.setFont(font);
		lblTitle.setForeground(new Color(139, 54, 32));
		lblName = new Label("이름");
		lblAge = new Label("나이");
		lblHeight = new Label("키");
		lblWeight = new Label("체중");
		lblSex = new Label("성별");
		// 하단에 위치시킬 상태 표시창
		// 처음에는 저장된 내용이 없으니 비어있게 표시
		lblStatus = new Label("");
		lblStatus.setBackground(Color.LIGHT_GRAY);
		tfName = new TextField("");
		tfHeight = new TextField("");
		tfWeight = new TextField("");
		tfAge = new TextField("");

		// 버튼 생성 및 버튼명 설정
		btnSave = new Button("저장");
		btnSearch = new Button("검색");
		btnDelete = new Button("삭제");
		btnUpdate = new Button("수정");
		btnReset = new Button("지우기");

		// 그룹 객체생성하기
		chGroup = new CheckboxGroup();
		// ("버튼명", 그룹표시, 기본값-false로 되어있다면 체크 안한 것이 기본)
		chMale = new Checkbox("Male", chGroup, false);
		chFemale = new Checkbox("Female", chGroup, false);
		
		// 리스트에 기본 값 주기
		list = new List(7, false);

		// 윈도우 창을 닫으면 정상종료 되도록 설정
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		/*
		 작성 2
		 1. MemberGUI에 입력한 데이터를
		 MemberDAO 클래스의 insert 메소드에 넘겨준다
		 2. MemberDAO에서 DB의 member 테이블에 insert문을 이용해서 입력데이터를 저장
		 3. MemberGUI에서 저장시킨 데이터까지 포함하여 내용을 출력시키기 위해
		 	displayAll()메소드를 호출
		 */
		// insert사용하기 위한 작성, 버튼에 기능 연결하기
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String height = tfHeight.getText();
				String weight = tfWeight.getText();
				
				String sex = "여";
				// 남자쪽의 버튼이 눌러져있으면  이쪽이 true
				if(chMale.getState()) { sex = "남";	}
				
				MemberDAO dao = new MemberDAO();
				dao.insert(name, age, height, weight, sex);
				displayAll();
			}
		});
		
		// 작성 3. 지우기 버튼을 누르면 입력하던 내용이 모두 지워져야 한다.
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText(" ");
				tfAge.setText(" ");
				tfHeight.setText(" ");
				tfWeight.setText(" ");
			}
		});
		
		// 작성 4. 리스트에 있는 값을 누르면 텍스트필드에 다시 채워지게끔 구현
		// 리스트가 눌린걸 감지하는 리스터
		list.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 리스트의 내용들이 String으로 str에 담김
				String str = list.getSelectedItem();
				StringTokenizer st = new StringTokenizer(str);
				tfName.setText(st.nextToken());
				tfAge.setText(st.nextToken());
				tfWeight.setText(st.nextToken());
				tfHeight.setText(st.nextToken());
				
				String sex = st.nextToken();
				if(sex.equals("여")) {
					chFemale.setState(true);
				} else {
					chMale.setState(true);
				}
			}
		});
		
		// 작성 5. tfName 쪽에 삭제할 이름을 작성하면 리스트에 있는 해당 회원 정보가 삭제
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				
				MemberDAO dao = new MemberDAO();
				dao.delete(name);
				displayAll();
			}
		});
		
		// 작성 6. 회원정보 수정하기, 이름을 받아서 수정할 것이다.
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String height = tfHeight.getText();
				String weight = tfWeight.getText();
				
				String sex = "여";
				// 남자쪽의 버튼이 눌러져있으면  이쪽이 true
				if(chMale.getState()) { sex = "남";	}
				
				MemberDAO dao = new MemberDAO();
				dao.update(name, age, height, weight, sex);
				displayAll();
			}
		});
		
		// 작성 7. 검색버튼
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1. 기본작성
//				String name = tfName.getText();
//				
//				MemberDTO dto = new MemberDTO();
//				MemberDAO dao = new MemberDAO();
//				dto = dao.search(name);
//				tfName.setText( dto.getName() );
//				tfAge.setText( Integer.toString(dto.getAge()) );
//				tfHeight.setText( Integer.toString(dto.getHeight()) );
//				tfWeight.setText( Integer.toString(dto.getWeight()) );
//				
//				String sex = Character.toString( (dto.getSex()) );
//				if(sex.equals("여")) {
//					chFemale.setState(true);
//				} else {
//					chMale.setState(true);
//				}
//				displayAll();
				
				//2. 검색시 해당 데이터가 존재하지 않을때의 예외처리
				// RecordNotFoundException 클래스 생성
				// DAO 에 isExist 메소드 생성 후
				String name = tfName.getText();
				
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				
				try {
					dto = dao.search(name);
				} catch (RecordNotFoundException e1) {
					// 예외가 발생하면 따로 경고창을 띄울 것이다
					final Dialog dialog = new Dialog(frame, "경고");
					
					dialog.setLayout(new FlowLayout());
					dialog.setSize(300, 80);
					// 제목은 설정한 에러메세지를 가져온다
					dialog.setTitle(e1.getMessage());
					
					Button btnOk = new Button("확인");
					btnOk.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// 확인버튼 누르면 경고창 사라지도록
							// 창 하나만 종료시키는 것
							dialog.dispose();
						}
					});
					// 버튼 내용을 dialog에 붙이겠다
					dialog.add(btnOk);
					dialog.setVisible(true);
				}
				
				tfName.setText( dto.getName() );
				tfAge.setText( Integer.toString(dto.getAge()) );
				tfHeight.setText( Integer.toString(dto.getHeight()) );
				tfWeight.setText( Integer.toString(dto.getWeight()) );
				
				String sex = Character.toString( (dto.getSex()) );
				if(sex.equals("여")) {
					chFemale.setState(true);
				} else {
					chMale.setState(true);
				}
				displayAll();
			}
		});
	}

	// 화면을 조립하는 메소드
	private void launchFrame() {
		// 1번 판넬을 2행 1열짜리 Grid로 제작
		panel[1].setLayout(new GridLayout(2, 1));
		// "이름" "키" 라는 라벨을 붙임
		panel[1].add(lblName);
		panel[1].add(lblHeight);

		// 2번 판넬도 2행 1열짜리 Grid로 제작
		panel[2].setLayout(new GridLayout(2, 1));
		// 입력할 수 있는 textField가 생성됨
		panel[2].add(tfName);
		panel[2].add(tfHeight);

		// 동서남북 어느곳에 위치시킬 것인가
		panel[3].setLayout(new BorderLayout());
		// 판넬 1번을 서쪽에 부착, 판넬 2번은 중앙에 부착, 동쪽에는 공백을 추가
		panel[3].add(panel[1], "West");
		panel[3].add(panel[2], "Center");
		panel[3].add(new Label(""), "East");

		
		// 반복
		panel[4].setLayout(new GridLayout(2, 1));
		panel[4].add(lblAge);
		panel[4].add(lblWeight);

		panel[5].setLayout(new GridLayout(2, 1));
		panel[5].add(tfAge);
		panel[5].add(tfWeight);
		
		panel[6].setLayout(new BorderLayout());
		panel[6].add(panel[4], "West");
		panel[6].add(panel[5], "Center");
		panel[6].add(new Label(""), "East");

		panel[7].setLayout(new GridLayout(1, 2));
		panel[7].add(panel[3]);
		panel[7].add(panel[6]);
		
		panel[8].add(lblSex);
		panel[8].add(chMale);
		panel[8].add(chFemale);
		
		panel[9].setLayout(new BorderLayout());
		panel[9].add(lblTitle, "North");
		panel[9].add(panel[7], "Center");
		panel[9].add(panel[8], "South");
		
		panel[10].setLayout(new GridLayout(1, 5));
		panel[10].setBackground(Color.black);
		panel[10].setForeground(Color.white);
		panel[10].add(new Label("이 름 "));
		panel[10].add(new Label("나 이 "));
		panel[10].add(new Label("체 중 "));
		panel[10].add(new Label(" 키 "));
		panel[10].add(new Label("성 별 "));
		
		panel[11].setLayout(new BorderLayout());
		panel[11].add(panel[10], "North");
		panel[11].add(list, "Center");
		
		panel[0].add(btnSave);
		panel[0].add(new Label(" "));
		panel[0].add(btnSearch);
		panel[0].add(new Label(" "));
		panel[0].add(btnDelete);
		panel[0].add(new Label(" "));
		panel[0].add(btnUpdate);
		panel[0].add(new Label(" "));
		panel[0].add(btnReset);
		
		panel[12].setLayout(new BorderLayout());
		panel[12].add(panel[9], "North");
		panel[12].add(panel[11], "Center");
		panel[12].add(panel[0], "South");
		
		frame.add(panel[12], "Center");
		frame.add(lblStatus, "South");
		
		frame.pack();
		// 창 사이즐르 고정으로 만들기
		frame.setResizable(false);
		
		
		// 화면이 보이도록 하기
		frame.setSize(350, 500);
		frame.setVisible(true);
		
		// select * from 을 할 메소드
		displayAll();
		// insert 사용하는 메소드 불러오기
		
	}
	
	// 작성 1
	// 화면 뜨자마자 DB에 select * from 을 해서
	// 회원정보를 화면에 보이도록 할 것
	private void displayAll() {
		// 리스트에 들어있는걸 일단 다 지워라
		list.removeAll();
		// DAO 클래스와 연결
		MemberDAO dao = new MemberDAO();
		// select * from 기능하는 메소드 호출 후 ArrayList<MemberDTO>에 넣기
		ArrayList<MemberDTO> allData = dao.select();
		
		// dto에 있는 걸 가져와서 담기
		for(MemberDTO dto : allData) {
			String name = dto.getName();
			int age = dto.getAge();
			int height = dto.getHeight();
			int weight = dto.getWeight();
			char sex = dto.getSex();
			list.add(name+"          "+age+"                  "+weight+"                  "+height+"                  "+sex);
		}
	}

	public static void main(String[] args) {
		ManagerGUI mem = new ManagerGUI();
		// 화면 조립하는 메소드 호출
		mem.launchFrame();
	}
}
