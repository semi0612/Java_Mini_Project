// 매장 주문 관리용

public class Manager {
	boolean flag = true;
	// 총 매출액
	int money;
	double point;
	// 횟수 세기
	int allCoffeeCnt = 0, allSmoothieCnt = 0, allAdeCnt = 0;
	int coffeeCnt = 0, smoothieCnt = 0, adeCnt = 0;
	// 객체 생성
	CoffeeProduct[] cp = new CoffeeProduct[allCoffeeCnt];
	SmoothieProduct[] sp = new SmoothieProduct[allSmoothieCnt];
	AdeProduct[] ap = new AdeProduct[allAdeCnt];

	// 입력 받기
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 커피 관리 메소드
	void coffeeInput(CoffeeProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		coffeeCnt = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		cp = new CoffeeProduct[coffeeCnt];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allCoffeeCnt += coffeeCnt;

		int cPoint = (int) (coffeeCnt * p.point);
		point += (p.point * coffeeCnt);
		money += (p.price * coffeeCnt);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, coffeeCnt, cPoint);
		System.out.println();
		System.out.println("---------------------");
		System.out.println("계속 주문 하시겠습니까? (Y/N)");
		String check = br.readLine();
		if (check.equals("N")) {
			this.flag = false;
		} else {
			this.flag = true;
		}
	}

	// 스무디 관리 메소드
	void smoothieInput(SmoothieProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		smoothieCnt = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		sp = new SmoothieProduct[smoothieCnt];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allSmoothieCnt += smoothieCnt;

		int sPoint = (int) (smoothieCnt * p.point);
		point += (p.point * smoothieCnt);
		money += (p.price * smoothieCnt);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, smoothieCnt, sPoint);
		System.out.println();
		System.out.println("---------------------");
		System.out.println("계속 주문 하시겠습니까? (Y/N)");
		String check = br.readLine();
		if (check.equals("N")) {
			this.flag = false;
		} else {
			this.flag = true;
		}
	}

	// 스무디 관리 메소드
	void adeInput(AdeProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		adeCnt = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		ap = new AdeProduct[adeCnt];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allAdeCnt += adeCnt;

		int aPoint = (int) (adeCnt * p.point);
		point += (p.point * adeCnt);
		money += (p.price * adeCnt);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, smoothieCnt, aPoint);
		System.out.println();
		System.out.println("---------------------");
		System.out.println("계속 주문 하시겠습니까? (Y/N)");
		String check = br.readLine();
		if (check.equals("N")) {
			this.flag = false;
		} else {
			this.flag = true;
		}
	}
}
