public class CoffeeProduct {
	int price;
	double point;
	int coffeeCnt = 0;

	public CoffeeProduct() {
	};

	public CoffeeProduct(int price) {
		this.price = price;
		this.point = (price * 0.1);
	}
}



class Latte extends CoffeeProduct {
	public Latte() {
		super(3200);
	}

	@Override
	public String toString() {
		return "카페라떼";
	}
}

class Vanilla extends CoffeeProduct {
	public Vanilla() {
		super(3700);
	}

	@Override
	public String toString() {
		return "바닐라 라떼";
	}
}

class Mocha extends CoffeeProduct {
	public Mocha() {
		super(4200);
	}

	@Override
	public String toString() {
		return "카페 모카";
	}
}
