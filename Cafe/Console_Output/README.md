## ☕
연결 클래스 이름 - 관리 메소드 이름 - 제품 누적할 변수 명
제품 클래스명 / 제품명(가격)
포인트는 가격의 10%

CoffeeProduct - coffeeInput - coffeeCnt
1. Latte 카페라떼 (3200)
2. Vanilla 바닐라 라떼 (3700)
3. Mocha 카페 모카(4200)

SmoothieProduct - smoothieInput - smoothieCnt
1. Yogurt 플레인 요거트 스무디 (4400)
2. Plum 자두 스무디 (3800)
3. Peach 복숭아 스무디(4000)

AdeProduct - adeInput - adeCnt
1. Grape 청포도에이드 (4500)
2. Strawberry 딸기에이드(4400)
3. Lemon 레몬에이드(4200)

<hr>

## Feedback
1. 사용자가 구매를 종료하고 싶을 때, 꼭 대문자로 'N'만을 입력해야한다는 점이 아쉽습니다. <br>
 -> 넵. N 뿐만 아니라 n 또는 no 같이 선택지를 여러개 줬어도 좋았을거 같은데 해당 기능을 추가하지 못했습니다. 피드백 감사드립니다. <br>
 
2. 누적 포인트를 일시적으로 보이지 않고 구매 종료시 사용자 별로 진짜 누적 포인트가 쌓였으면 어떨까요. <br>
 -> DB를 연동하지 않은 기본적인 프로그램 작성이 목표였기 때문에, 사용자별로 누적하는 건 구현하지 못 했습니다. <br>
    저희도 추후에 DB와 연동해 구현해보고 싶은 기능입니다. 감사합니다. <br>
