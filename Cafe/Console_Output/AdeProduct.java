public class AdeProduct {
	int price;
	double point;
	int adeCnt = 0;

	public AdeProduct() {
	};

	public AdeProduct(int price) {
		this.price = price;
		this.point = (price * 0.1);
	}
}




class Grape extends AdeProduct {
	public Grape() {
		super(4500);
	}

	@Override
	public String toString() {
		return "청포도 에이드";
	}
}

class Strawberry extends AdeProduct {
	public Strawberry() {
		super(4400);
	}

	@Override
	public String toString() {
		return "딸기 에이드";
	}
}

class Lemon extends AdeProduct {
	public Lemon() {
		super(4200);
	}

	@Override
	public String toString() {
		return "레몬 에이드";
	}
}
