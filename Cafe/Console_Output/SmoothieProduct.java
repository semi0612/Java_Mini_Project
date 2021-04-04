public class SmoothieProduct {
	int price;
	double point;
	int smoothieCnt = 0;

	public SmoothieProduct() {
	};

	public SmoothieProduct(int price) {
		this.price = price;
		this.point = (price * 0.1);
	}
}




class Yogurt extends SmoothieProduct {
	public Yogurt() {
		super(4400);
	}

	@Override
	public String toString() {
		return "플레인 요거트 스무디";
	}
}

class Plum extends SmoothieProduct {
	public Plum() {
		super(3800);
	}

	@Override
	public String toString() {
		return "자두 스무디";
	}
}

class Peach extends SmoothieProduct {
	public Peach() {
		super(4000);
	}

	@Override
	public String toString() {
		return "복숭아 스무디";
	}
}
