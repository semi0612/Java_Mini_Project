// 포장 주문 관리

public class Manager1 {
	boolean flag = true;
	// 총 매출액
	int money;
	double point;
	// 횟수 세기
	int allCoffeeCnt1 = 0, allSmoothieCnt1 = 0, allAdeCnt1 = 0;
	int coffeeCnt1 = 0, smoothieCnt1 = 0, adeCnt1 = 0;
	// 객체 생성
	CoffeeProduct[] ac1 = new CoffeeProduct[allCoffeeCnt1];
	SmoothieProduct[] sp1 = new SmoothieProduct[allSmoothieCnt1];
	AdeProduct[] ap1 = new AdeProduct[allAdeCnt1];
	
	// 입력 받기
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 커피 관리 메소드 매장
	void coffeeInput1(CoffeeProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		coffeeCnt1 = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		ac1 = new CoffeeProduct[coffeeCnt1];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allCoffeeCnt1 += coffeeCnt1;

		int cPoint = (int) (coffeeCnt1 * p.point);
		point += (p.point * coffeeCnt1);
		money += ((p.price + 500) * coffeeCnt1);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, coffeeCnt1, cPoint);
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
	void smoothieInput1(SmoothieProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		smoothieCnt1 = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		sp1 = new SmoothieProduct[smoothieCnt1];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allSmoothieCnt1 += smoothieCnt1;

		int sPoint = (int) (smoothieCnt1 * p.point);
		point += (p.point * smoothieCnt1);
		money += ((p.price + 500) * smoothieCnt1);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, smoothieCnt1, sPoint);
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

	// 에이드 관리 메소드
	void adeInput1(AdeProduct p) throws IOException {
		// 판매 관리
		System.out.println("몇 잔 구매하시겠습니까?");
		System.out.print(">>");
		adeCnt1 = Integer.parseInt(br.readLine());
		// 판매 개수를 배열로 넣어주기
		ap1 = new AdeProduct[adeCnt1];
		// 판매 개수 누적하기 -> 전체 판매 개수를 합쳐야 하니까
		allAdeCnt1 += adeCnt1;

		int aPoint = (int) (adeCnt1 * p.point);
		point += (p.point * adeCnt1);
		money += ((p.price + 500) * adeCnt1);

		System.out.printf("선택하신 제품 : %s | 구매 수량 : %d | 예상 누적 포인트 : %d", p, smoothieCnt1, aPoint);
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
