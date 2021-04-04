public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 매장주문

		Manager m1 = new Manager();
		Manager1 m2 = new Manager1();
		int act, act1;
		boolean flag = true;

		// 실행시 메인화면
		System.out.println("-------------");
		System.out.println("카페 관리 프로그램");
		System.out.println("-------------");
		System.out.println("1.매장 주문 | 2.포장주문");
		// 사용자에게 번호를 입력받아 변수 act에 저장합니다
		System.out.print(">>");
		act = Integer.parseInt(br.readLine());


		while (flag) {
			switch (act) {
			case 1:
				System.out.println();
				System.out.println("1.커피 | 2. 스무디 | 3. 에이드");
				System.out.print(">>");
				act1 = Integer.parseInt(br.readLine());

				if (act1 == 1) {
					System.out.println("1. 카페라떼 | 2. 바닐라라떼 | 3.카페모카");
					System.out.print(">>");
					act = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m1.coffeeInput(new Latte());
						flag = m1.flag;
						break;
					} else if (act1 == 2) {
						m1.coffeeInput(new Vanilla());
						flag = m1.flag;
						break;
					} else if (act1 == 3) {
						m1.coffeeInput(new Mocha());
						flag = m1.flag;
						break;
					} else {
						continue;
					}
				} else if (act1 == 2) {
					System.out.println("1. 요거트 | 2. 복숭아 | 3. 자두");
					System.out.print(">>");
					act1 = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m1.smoothieInput(new Yogurt());
						flag = m1.flag;
						break;
					} else if (act1 == 2) {
						m1.smoothieInput(new Peach());
						flag = m1.flag;
						break;
					} else if (act1 == 3) {
						m1.smoothieInput(new Plum());
						flag = m1.flag;
						break;
					} else {
						continue;
					}
				} else if (act1 == 3) {
					System.out.println("1. 청포도 | 2. 딸기 | 3. 레몬 ");
					System.out.print(">>");
					act1 = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m1.adeInput(new Grape());
						flag = m1.flag;
						break;
					} else if (act1 == 2) {
						m1.adeInput(new Strawberry());
						flag = m1.flag;
						break;
					} else if (act1 == 3) {
						m1.adeInput(new Lemon());
						flag = m1.flag;
						break;
					} else {
						continue;
					}
				} else {
				}

			case 2:
				System.out.println();
				System.out.println("포장주문은 메뉴 당 500원 추가됩니다");
				System.out.println("1.커피 | 2. 스무디 | 3. 에이드");
				System.out.print(">>");
				act1 = Integer.parseInt(br.readLine());

				if (act1 == 1) {
					System.out.println("1. 카페라떼 | 2. 바닐라라떼 | 3.카페모카");
					System.out.print(">>");
					act1 = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m2.coffeeInput1(new Latte());
						flag = m2.flag;
						break;
					} else if (act1 == 2) {
						m2.coffeeInput1(new Vanilla());
						flag = m2.flag;
						break;
					} else if (act1 == 3) {
						m2.coffeeInput1(new Mocha());
						flag = m2.flag;
						break;
					} else {
						continue;
					}
				} else if (act1 == 2) {
					System.out.println("1. 요거트 | 2. 복숭아 | 3. 자두");
					System.out.print(">>");
					act1 = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m2.smoothieInput1(new Yogurt());
						flag = m2.flag;
						break;
					} else if (act1 == 2) {
						m2.smoothieInput1(new Peach());
						flag = m2.flag;
						break;
					} else if (act1 == 3) {
						m2.smoothieInput1(new Plum());
						flag = m2.flag;
						break;
					} else {
						continue;
					}
				} else if (act1 == 3) {
					System.out.println("1. 청포도 | 2. 딸기 | 3. 레몬 ");
					System.out.print(">>");
					act = Integer.parseInt(br.readLine());
					if (act1 == 1) {
						m2.adeInput1(new Grape());
						flag = m2.flag;
						break;
					} else if (act1 == 2) {
						m2.adeInput1(new Strawberry());
						flag = m2.flag;
						break;
					} else if (act1 == 3) {
						m2.adeInput1(new Lemon());
						flag = m2.flag;
						break;
					} else {
						continue;
					}
				} else {
				}
			}

		}
		int hap1 = m1.allCoffeeCnt + m1.allAdeCnt + m1.allSmoothieCnt;
		int hap2 = m2.allCoffeeCnt1 + m2.allAdeCnt1 + m2.allSmoothieCnt1;

		if (act == 1) {
			System.out.println("-------------------");
			System.out.println("구매하신 음료 수 : " + hap1);
			System.out.println("결제하실 금액 : " + (int) m1.money + "원");
			System.out.println("누적 포인트 : " + (int) m1.point + " point");
			System.out.println("구매해주셔서 감사합니다");
			br.close();
			System.exit(0);
		} else {
			System.out.println("-------------------");
			System.out.println("구매하신 음료 수 : " + hap2);
			System.out.println("결제하실 금액 : " + (int) m2.money + "원");
			System.out.println("누적 포인트 : " + (int) m2.point + " point");
			System.out.println("구매해주셔서 감사합니다");
			br.close();
			System.exit(0);

		}
	}
}
