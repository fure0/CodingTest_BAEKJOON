public class lowerUpper2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4, 4, 4, 6, 7, 7, 9 };
		int key = 4;
		System.out.println(lowerBound(arr, key));
		System.out.println(upperBound(arr, key));
    }

    private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {

			int mid = (lo + hi) / 2; // 중간위치를 구한다.

			if (arr[mid] >= key) { //key가 mid보다 작거나 같음
                hi = mid;
			} else { //key가 mid보다 크음
                lo = mid + 1;
			}

		}

		return hi;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {

			int mid = (lo + hi) / 2; // 중간위치를 구한다.

			// key값이 중간 위치의 값보다 작을 경우
			if (arr[mid] <= key) { //key가 미드보다 크거나 같음
                lo = mid + 1;
				
			} else { //key가 mid보다 작음
				hi = mid;
			}

		}

		return hi;
	}
}
