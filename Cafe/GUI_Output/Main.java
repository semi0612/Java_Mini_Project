public class Main extends JFrame {
	// 불러올 이미지 경로
	ImageIcon i = new ImageIcon("C:\\Users\\82107\\Desktop\\program\\JAVA_SYUDY2\\Personal_Project\\src\\gui_test\\img\\brigitte-tohm-EAay7Aj4jbc-unsplash.jpg");
	Image img = i.getImage();
	
	public Main() {
		setTitle("메인 화면");
		// 폰트 설정
		Font font = new Font("바탕", Font.PLAIN, 45);
		
		// 그림 판넬 생성
		MyPanel panel = new MyPanel();
		panel.setLayout(new FlowLayout());
		
		// 버튼 생성
		JButton btIn = new JButton("매장 주문");
		btIn.addActionListener(new ActionListener() {
			// 매장주문 버튼을 누르면 실행되는 것
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cafe1();
			}
		});
		// 버튼 외각선 없어지게 하기
		btIn.setBorderPainted(false);
		btIn.setFocusPainted(false);
		// 버튼 내용 색 없어지게 하기
		btIn.setContentAreaFilled(false);
		// 외각선을 없애니 크기 지정 안해도 된다고 생각했지만
		// setSize 안해주면 아예 보이질 않는다
		btIn.setSize(250, 200);
		// 적당한 곳에 위치를 지정
		btIn.setLocation(50, 700);
		btIn.setFont(font);
		
		
		
		JButton btOut = new JButton("포장 주문");
		btOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cafe2();
			}
		});
		btOut.setBorderPainted(false);
		btOut.setFocusPainted(false);
		btOut.setContentAreaFilled(false);
		btOut.setSize(250, 200);
		btOut.setLocation(300, 700);
		btOut.setFont(font);
		
		
		getContentPane().add(btIn);
		getContentPane().add(btOut);
		getContentPane().add(panel);
	}
	
	// 뒷 배경으로 그림을 불러올 꺼니까
	// 그림 붙여놓을 판넬 클래스 생성
	class MyPanel extends JPanel{		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	
	// 출력
	public static void main(String[] args) {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(625, 1000);
		main.setVisible(true);
	}
}
