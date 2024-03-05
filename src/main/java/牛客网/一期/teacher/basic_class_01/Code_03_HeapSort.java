package 牛客网.一期.teacher.basic_class_01;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			//设置父节点为最大值
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);//size长度减一
		while (size > 0) {
			//设置 0 个为最大值
			heapify(arr, 0, size);
			//交换 0 与 最后一个
			swap(arr, 0, --size);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		/**
		 * 将父节点设置为最大值
		 */
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	/**
	 * 保持树有序，
	 * @param arr
	 * @param index
	 * @param size
	 */
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			//1、找出最大值：找出当前节点，左叶子节点，右叶子节点 三个中最大的值，并与当前节点值交换
			//选出左右节点中的大值：对比左节点 与 右节点
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//选出父子节点中的大值：对比 父节点 与 子节点
			largest = arr[largest] > arr[index] ? largest : index;
			//当前节点为最大值则跳出循环
			if (largest == index) {
				break;
			}
			//将当前 根节点 设置为最大的值
			swap(arr, largest, index);

			//2、设置需要设置最大值的下标
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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

	// for test
	public static void main(String[] args) {
		int testTime = 500;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			int[] arr3 = new int[]{1,2,5,1,4,10,21,10,11,8};
			heapSort(arr3);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
