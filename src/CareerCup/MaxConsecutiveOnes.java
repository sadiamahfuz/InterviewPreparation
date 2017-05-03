package CareerCup;

public class MaxConsecutiveOnes {

	public int maxOnes(int[] nums, int flips) {

		if (nums.length <= flips) {
			return nums.length;
		}

		int zeroCount = 0;
		int max = 0;

		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			}

			while(zeroCount > flips) {
				if (nums[j] == 0) {
					zeroCount--;
				}
				j++;
			}

			max = Math.max(max, i+1 - j);
		}


		return max;
	}



	public static void main(String[] args) {
		int[] nums = {0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1};

		MaxConsecutiveOnes m = new MaxConsecutiveOnes();
		System.out.println(m.maxOnes(nums, 2));
	}

}
