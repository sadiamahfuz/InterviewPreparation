package InterviewCakeProblems;

public class Cake {

	public final int weight;
	public final int price;

	public Cake(int a, int b) {
		this.weight = a;
		this.price = b;
	}

	public boolean equals(Cake c) {
		if (c.weight == this.weight && c.price == this.price) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Weight: " + this.weight + " Price: " + this.price;
	}

}
