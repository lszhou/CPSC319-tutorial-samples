package T09;

/*implements quick sorting algorithm;*/
public class quickSort {

	private static int partition(sampleObj arr[], int left, int right) {
		int i = left, j = right;
		sampleObj tmp;
		sampleObj pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0)
				i++;
			while (arr[j].compareTo(pivot) > 0)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void quick(sampleObj arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quick(arr, left, index - 1);
		if (index < right)
			quick(arr, index, right);
	}

}
