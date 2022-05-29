public class lowerUpper1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 4, 4, 4, 6, 7, 7, 9 };
		int key = 4;
		System.out.println("{1, 2, 2, 4, 4, 4, 6, 7, 7, 9}");
		System.out.println(lowerBound(arr, key));
		System.out.println(upperBound(arr, key));
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) { //같지 않은 동안 루프

			int mid = (lo + hi) / 2; // 중간위치를 구한다.
			System.out.println("lowerBound mid = " + mid + " lo = " + lo + " hi = " + hi);
			if (key <= arr[mid]) {
				System.out.print("key("+key+")가 mid("+arr[mid]+")보다 작거나 같음 ");
				hi = mid;
				System.out.println("hi("+hi+") => mid("+mid+")");
			} else {
				System.out.print("key("+key+")가 mid("+arr[mid]+")보다 큼 ");
				lo = mid + 1;
				System.out.println("lo("+lo+") => mid + 1 = " + (mid+1));
			}
			
		}

		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {

			int mid = (lo + hi) / 2; // 중간위치를 구한다.
			System.out.println("upperBound mid = " + mid + " lo = " + lo + " hi = " + hi);
			if (key < arr[mid]) {
				System.out.print("key("+key+")가 mid("+arr[mid]+")보다 작음 ");
				hi = mid;
				System.out.println("hi("+hi+") => mid("+mid+")");
			} else {
				System.out.print("key("+key+")가 mid("+arr[mid]+")보다 크거나 같음 ");
				lo = mid + 1;
				System.out.println("lo("+lo+") => mid + 1 = " + (mid+1));
			}
		}

		return lo;
	}
}
