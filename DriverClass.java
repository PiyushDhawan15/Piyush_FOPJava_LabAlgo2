package main;

	import java.util.Scanner;

	import java.util.Arrays;

	public class DriverClass {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter number of Transactions");
				int noOfTrans = sc.nextInt();
				int[] transValues = new int[noOfTrans];
				int[] cumulativeValues = new int[noOfTrans];
				System.out.print("Enter the values of the transactions: ");
	// [23, 67, 98, 12, 64]
	// [23, 100, 198, 210, 274]
	// [300, 9, 3, 400]
	// [300, 309, 312, 712]
				for (int i = 0;i < noOfTrans; i++) {
					transValues[i] = sc.nextInt();
					cumulativeValues[i] = ((i == 0) ? 0: cumulativeValues[i-1]) + transValues[i]; 
				}
				System.out.println("cumulative values:"+Arrays.toString(cumulativeValues));
				System.out.print("Enter total no of targets that need to be achieved: ");
				int noOfTargets = sc.nextInt();
				for (int i = 0; i < noOfTargets; i++) {
					System.out.print("Enter the value of target "+(i+1)+": ");
					int target = sc.nextInt();
					int noOfTransForTarget = getTransactionsForTarget(cumulativeValues, 0, noOfTrans-1, target);
					System.out.println(noOfTransForTarget < 0? "target is not achievable":"target achieved in " + noOfTransForTarget + " transactions");
				}
			}
		}
		private static int getTransactionsForTarget(int[] cumulativeValues, int low, int high, int target) {
			// TODO Auto-generated method stub
			if (cumulativeValues[cumulativeValues.length-1] < target) {
				return -1;
			}
			if (cumulativeValues[0] > target) {
				return 1;
			}
			if (low > high) {	// should not happen since boundary condition checked separately
				return -1;
			}
			int mid = (low + high) / 2;
			if (target <= cumulativeValues[mid]) {
				return target > cumulativeValues[mid-1] ? mid + 1 : getTransactionsForTarget(cumulativeValues, low, mid - 1, target);
			}
			return getTransactionsForTarget(cumulativeValues, mid + 1, high, target);
		}
	}


