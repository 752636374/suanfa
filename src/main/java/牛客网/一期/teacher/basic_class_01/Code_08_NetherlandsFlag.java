package 牛客网.一期.teacher.basic_class_01;

public class Code_08_NetherlandsFlag {

	/**
	 *
	 * @param arr 数组
	 * @param l 左边界
	 * @param r 右边界
	 * @param p 对比值
	 * @return
	 */
	public static int[] partition(int[] arr, int l, int r, int p) {
		//左边界
		int less = l - 1;
		//右边界
		int more = r + 1;
		while (l < more) {
			if (arr[l] < p) {
				//交换至
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				//
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
