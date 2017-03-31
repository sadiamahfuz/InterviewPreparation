package InterviewCakeProblems;

/*
 * Writing programming interview questions hasn't made me rich.
 * Maybe trading Apple stocks will.
 *
 * Suppose we could access yesterday's stock prices as an array, where:
 * The values are the price in dollars of Apple stock.
 * A higher index indicates a later time.
 * So if the stock cost $500 at 10:30am and $550 at 11:00am, then:
 *
 * stockPricesYesterday[60] = 500;
 * Write an efficient function that takes stockPricesYesterday and returns
 * the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
 *
 * For example:
 * int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
 * getMaxProfit(stockPricesYesterday);
 * returns 6 (buying for $5 and selling for $11)
 *
 * No "shorting"—you must buy before you sell.
 * You may not buy and sell in the same time step (at least 1 minute must pass).
 */
public class StockPrices {

	public int getMaxProfit(int[] prices) {
		int maxProfit = 0;

		int sum = 0;
		if (prices.length > 1) {
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i-1];
				if (sum + diff < 0) {
					sum = 0;
				}
				else {
					sum += diff;
				}
				maxProfit = Math.max(maxProfit, sum);
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		StockPrices s = new StockPrices();
		int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
		System.out.println(s.getMaxProfit(stockPricesYesterday));
	}

}
