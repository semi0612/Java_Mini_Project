public class Cafe2 extends JFrame {
	int count = 0;
	String show = "";
	double point = 0;

	public Cafe2() {
    // 처음 출력될 팝업창
		JOptionPane.showMessageDialog(null, "포장 주문은 메뉴당 500원 추가됩니다");
		// 디자인단
		// 프레임 설정단
		JFrame frame = new JFrame("음료 선택");
		frame.setBounds(0, 0, 625, 1000);
		frame.setBackground(Color.black);

		// 폰트
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// 북쪽
		Panel pNorth = new Panel();
		pNorth.setBackground(new Color(233, 218, 201));
		pNorth.setLayout(null);
		pNorth.setSize(0, 500);
		pNorth.setFont(font);

		// 배열 설정 부분
		String menu[] = { "카페 라떼", "초코 라떼", "카페 모카", "로즈힙 티", "오렌지 차", "복숭아 차", "녹차 라떼", "딸기 라떼" };
		int price[] = { 3700, 4200, 4700, 4900, 4300, 4500, 5000, 4900 };
		JButton bt[] = new JButton[menu.length];
		TextField num[] = new TextField[menu.length];
		Button minus[] = new Button[menu.length];
		Button plus[] = new Button[menu.length];
		JButton ok[] = new JButton[menu.length];
		Label l[] = new Label[menu.length];
		ImageIcon icon[] = new ImageIcon[menu.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu.length; i++) {
			// 메뉴 버튼
			bt[i] = new JButton(menu[i]);
			if (i < 4) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}

			icon[i] = new ImageIcon(
					"C:\\Users\\82107\\Desktop\\program\\JAVA_SYUDY2\\Personal_Project\\src\\gui_test\\img\\" + (i + 1)
							+ ".jpg");
			bt[i].setIcon(icon[i]);

			// 숫자 txt 버튼
			num[i] = new TextField("0");
			num[i].setBackground(Color.white);
			num[i].setEditable(false);
			num[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

			// "-" 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(bt[i].getX(), num[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			// "+" 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), num[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			// 가격
			l[i] = new Label(price[i] + "원");
			l[i].setBounds(bt[i].getX() + 20, num[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), num[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			pNorth.add(bt[i]);
			pNorth.add(num[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}

		// 중앙
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setText("   상품명        단가        수량        합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// 남쪽
		Panel pSouth = new Panel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(196, 168, 127));

		Button bt1 = new Button("주문");
		Button bt2 = new Button("초기화");
		Button bt3 = new Button("닫기");
		Button bt4 = new Button("이전");
		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);
		pSouth.add(bt4);

		// 주문버튼
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "\n주문되었습니다 \n이용해주셔서 감사합니다\n누적 포인트 : " + (int) point);
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}
		});

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}
		});

		// bt3 닫기버튼

		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "\n이용해주셔서 감사합니다");
				System.exit(0);
			}
		});

		// bt4 메인돌아가기
		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.dispose();
			}
		});

		// 컴포넌트
		frame.add(pNorth, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(pSouth, BorderLayout.SOUTH);
		frame.setVisible(true);

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						num[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					num[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();
					ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "원" + "\n");
					point += price[j] * count * 0.1;
					ok[j].setEnabled(false);
				}
			});
		}

		// 끄기
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 메인
	// public static void main(String[] args) {
	// new Cafe2();
	// }
}
