import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;


// ���� Ŭ���� : ȭ�� ����
public class ManagerGUI {
	// ������ �����
	Frame frame;
	// �ǳ�
	Panel[] panel;
	// ��(ȸ�� ������ ����� �͵�)
	Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
	TextField tfName, tfHeight, tfAge, tfWeight;
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
	List list;
	Checkbox chMale, chFemale;
	CheckboxGroup chGroup;

	// �������ڸ��� ������ �ߵ���
	public ManagerGUI() {
		frame = new Frame("ȸ������");
		// �ǳ� 13�� �غ��ϱ�
		panel = new Panel[13];
		for (int i = 0; i < panel.length; i++) {
			// i�� �����ϸ鼭 ���ο� �ǳ� �ڸ��� �����ȴ�
			panel[i] = new Panel();
		}
		lblTitle = new Label("ȸ������", Label.CENTER);
		// ��Ʈ ����
		Font font = new Font("dialog", Font.BOLD, 20);
		// ��Ʈ ������ �� Ÿ��Ʋ�� ���̱�
		lblTitle.setFont(font);
		lblTitle.setForeground(new Color(139, 54, 32));
		lblName = new Label("�̸�");
		lblAge = new Label("����");
		lblHeight = new Label("Ű");
		lblWeight = new Label("ü��");
		lblSex = new Label("����");
		// �ϴܿ� ��ġ��ų ���� ǥ��â
		// ó������ ����� ������ ������ ����ְ� ǥ��
		lblStatus = new Label("");
		lblStatus.setBackground(Color.LIGHT_GRAY);
		tfName = new TextField("");
		tfHeight = new TextField("");
		tfWeight = new TextField("");
		tfAge = new TextField("");

		// ��ư ���� �� ��ư�� ����
		btnSave = new Button("����");
		btnSearch = new Button("�˻�");
		btnDelete = new Button("����");
		btnUpdate = new Button("����");
		btnReset = new Button("�����");

		// �׷� ��ü�����ϱ�
		chGroup = new CheckboxGroup();
		// ("��ư��", �׷�ǥ��, �⺻��-false�� �Ǿ��ִٸ� üũ ���� ���� �⺻)
		chMale = new Checkbox("Male", chGroup, false);
		chFemale = new Checkbox("Female", chGroup, false);
		
		// ����Ʈ�� �⺻ �� �ֱ�
		list = new List(7, false);

		// ������ â�� ������ �������� �ǵ��� ����
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		/*
		 �ۼ� 2
		 1. MemberGUI�� �Է��� �����͸�
		 MemberDAO Ŭ������ insert �޼ҵ忡 �Ѱ��ش�
		 2. MemberDAO���� DB�� member ���̺� insert���� �̿��ؼ� �Էµ����͸� ����
		 3. MemberGUI���� �����Ų �����ͱ��� �����Ͽ� ������ ��½�Ű�� ����
		 	displayAll()�޼ҵ带 ȣ��
		 */
		// insert����ϱ� ���� �ۼ�, ��ư�� ��� �����ϱ�
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String height = tfHeight.getText();
				String weight = tfWeight.getText();
				
				String sex = "��";
				// �������� ��ư�� ������������  ������ true
				if(chMale.getState()) { sex = "��";	}
				
				MemberDAO dao = new MemberDAO();
				dao.insert(name, age, height, weight, sex);
				displayAll();
			}
		});
		
		// �ۼ� 3. ����� ��ư�� ������ �Է��ϴ� ������ ��� �������� �Ѵ�.
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText(" ");
				tfAge.setText(" ");
				tfHeight.setText(" ");
				tfWeight.setText(" ");
			}
		});
		
		// �ۼ� 4. ����Ʈ�� �ִ� ���� ������ �ؽ�Ʈ�ʵ忡 �ٽ� ä�����Բ� ����
		// ����Ʈ�� ������ �����ϴ� ������
		list.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// ����Ʈ�� ������� String���� str�� ���
				String str = list.getSelectedItem();
				StringTokenizer st = new StringTokenizer(str);
				tfName.setText(st.nextToken());
				tfAge.setText(st.nextToken());
				tfWeight.setText(st.nextToken());
				tfHeight.setText(st.nextToken());
				
				String sex = st.nextToken();
				if(sex.equals("��")) {
					chFemale.setState(true);
				} else {
					chMale.setState(true);
				}
			}
		});
		
		// �ۼ� 5. tfName �ʿ� ������ �̸��� �ۼ��ϸ� ����Ʈ�� �ִ� �ش� ȸ�� ������ ����
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				
				MemberDAO dao = new MemberDAO();
				dao.delete(name);
				displayAll();
			}
		});
		
		// �ۼ� 6. ȸ������ �����ϱ�, �̸��� �޾Ƽ� ������ ���̴�.
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String height = tfHeight.getText();
				String weight = tfWeight.getText();
				
				String sex = "��";
				// �������� ��ư�� ������������  ������ true
				if(chMale.getState()) { sex = "��";	}
				
				MemberDAO dao = new MemberDAO();
				dao.update(name, age, height, weight, sex);
				displayAll();
			}
		});
		
		// �ۼ� 7. �˻���ư
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1. �⺻�ۼ�
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
//				if(sex.equals("��")) {
//					chFemale.setState(true);
//				} else {
//					chMale.setState(true);
//				}
//				displayAll();
				
				//2. �˻��� �ش� �����Ͱ� �������� �������� ����ó��
				// RecordNotFoundException Ŭ���� ����
				// DAO �� isExist �޼ҵ� ���� ��
				String name = tfName.getText();
				
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				
				try {
					dto = dao.search(name);
				} catch (RecordNotFoundException e1) {
					// ���ܰ� �߻��ϸ� ���� ���â�� ��� ���̴�
					final Dialog dialog = new Dialog(frame, "���");
					
					dialog.setLayout(new FlowLayout());
					dialog.setSize(300, 80);
					// ������ ������ �����޼����� �����´�
					dialog.setTitle(e1.getMessage());
					
					Button btnOk = new Button("Ȯ��");
					btnOk.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Ȯ�ι�ư ������ ���â ���������
							// â �ϳ��� �����Ű�� ��
							dialog.dispose();
						}
					});
					// ��ư ������ dialog�� ���̰ڴ�
					dialog.add(btnOk);
					dialog.setVisible(true);
				}
				
				tfName.setText( dto.getName() );
				tfAge.setText( Integer.toString(dto.getAge()) );
				tfHeight.setText( Integer.toString(dto.getHeight()) );
				tfWeight.setText( Integer.toString(dto.getWeight()) );
				
				String sex = Character.toString( (dto.getSex()) );
				if(sex.equals("��")) {
					chFemale.setState(true);
				} else {
					chMale.setState(true);
				}
				displayAll();
			}
		});
	}

	// ȭ���� �����ϴ� �޼ҵ�
	private void launchFrame() {
		// 1�� �ǳ��� 2�� 1��¥�� Grid�� ����
		panel[1].setLayout(new GridLayout(2, 1));
		// "�̸�" "Ű" ��� ���� ����
		panel[1].add(lblName);
		panel[1].add(lblHeight);

		// 2�� �ǳڵ� 2�� 1��¥�� Grid�� ����
		panel[2].setLayout(new GridLayout(2, 1));
		// �Է��� �� �ִ� textField�� ������
		panel[2].add(tfName);
		panel[2].add(tfHeight);

		// �������� ������� ��ġ��ų ���ΰ�
		panel[3].setLayout(new BorderLayout());
		// �ǳ� 1���� ���ʿ� ����, �ǳ� 2���� �߾ӿ� ����, ���ʿ��� ������ �߰�
		panel[3].add(panel[1], "West");
		panel[3].add(panel[2], "Center");
		panel[3].add(new Label(""), "East");

		
		// �ݺ�
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
		panel[10].add(new Label("�� �� "));
		panel[10].add(new Label("�� �� "));
		panel[10].add(new Label("ü �� "));
		panel[10].add(new Label(" Ű "));
		panel[10].add(new Label("�� �� "));
		
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
		// â ������ �������� �����
		frame.setResizable(false);
		
		
		// ȭ���� ���̵��� �ϱ�
		frame.setSize(350, 500);
		frame.setVisible(true);
		
		// select * from �� �� �޼ҵ�
		displayAll();
		// insert ����ϴ� �޼ҵ� �ҷ�����
		
	}
	
	// �ۼ� 1
	// ȭ�� ���ڸ��� DB�� select * from �� �ؼ�
	// ȸ�������� ȭ�鿡 ���̵��� �� ��
	private void displayAll() {
		// ����Ʈ�� ����ִ°� �ϴ� �� ������
		list.removeAll();
		// DAO Ŭ������ ����
		MemberDAO dao = new MemberDAO();
		// select * from ����ϴ� �޼ҵ� ȣ�� �� ArrayList<MemberDTO>�� �ֱ�
		ArrayList<MemberDTO> allData = dao.select();
		
		// dto�� �ִ� �� �����ͼ� ���
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
		// ȭ�� �����ϴ� �޼ҵ� ȣ��
		mem.launchFrame();
	}
}
