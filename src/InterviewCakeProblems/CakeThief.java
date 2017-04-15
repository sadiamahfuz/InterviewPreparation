package InterviewCakeProblems;

import java.util.LinkedList;
import java.util.List;

/*
 * You are a renowned thief who has recently switched from stealing
 * precious metals to stealing cakes because of the insane profit margins.
 * You end up hitting the jackpot, breaking into the world's largest
 * privately owned stock of cakes—the vault of the Queen of England.
 *
 * While Queen Elizabeth has a limited number of types of cake,
 * she has an unlimited supply of each type.
 *
 * Each type of cake has a weight and a value, stored in a tuple with two indices:
 *   An integer representing the weight of the cake in kilograms
 *   An integer representing the monetary value of the cake in British pounds
 *
 * You brought a duffel bag that can hold limited weight,
 * and you want to make off with the most valuable haul possible.
 *
 * Write a function max_duffel_bag_value() that takes a list of cake type tuples
 * and a weight capacity, and returns the maximum monetary value the duffel bag can hold.
 */
public class CakeThief {

	public int maxDuffelBagValue(List<Cake> cakes, int capacity) {
		int[] result = new int[capacity + 1];

		for (int currentCapacity = 0; currentCapacity <= capacity; currentCapacity++) {
			int currentMax = 0;
			for (Cake cake: cakes) {
				if (cake.weight <= currentCapacity) {
					int remainingCapacity = currentCapacity - cake.weight;
					int maxUsingCake = cake.price + result[remainingCapacity];
					currentMax = Math.max(currentMax, maxUsingCake);
				}
				result[currentCapacity] = currentMax;
			}
		}

		for (int i = 1; i < capacity + 1; i++) {
			if (result[i] != 0) {
				System.out.println(i + ": " + result[i]);
			}
		}

		return result[capacity];
	}

	public static void main(String[] args) {
		CakeThief c = new CakeThief();

		List<Cake> cakes = new LinkedList<Cake>();
		cakes.add(new Cake(7, 160));
		cakes.add(new Cake(3, 90));
		cakes.add(new Cake(2, 15));

		System.out.println(c.maxDuffelBagValue(cakes, 20));
	}
}
