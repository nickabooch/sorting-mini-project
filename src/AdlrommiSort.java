class AdlrommiSort {

  private static final int MINRUN = 32;

  // Median-of-three pivot selection for potentially better balancing
  private static int medianOfThree(int[] arr, int left, int right) {
    int mid = left + (right - left) / 2;
    if (arr[left] > arr[mid]) {
      swap(arr, left, mid);
    }
    if (arr[left] > arr[right]) {
      swap(arr, left, right);
    }
    if (arr[mid] > arr[right]) {
      swap(arr, mid, right);
    }
    return mid;
  }

  public void timsort(int[] arr) {
    int runs = 0;
    int currentRunStart = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) { // Detect run boundary
        int pivot = medianOfThree(arr, currentRunStart, i - 1); // Median pivot selection
        quickSort(arr, currentRunStart, i - 1, pivot); // Quicksort for small runs (optional)
        runs++;
        currentRunStart = i;
      }
    }
    if (currentRunStart != arr.length) {
      insertionSort(arr, currentRunStart, arr.length - 1);
      runs++;
    }

    // Merge remaining runs (similar logic as before, but in-place)
    while (runs > 1) {
      int mergedRuns = 0;
      for (int i = 0; i < runs; i += 2) {
        if (i + 1 < runs) {
          merge(arr, i, i + 1); // Merge in-place within arr
        }
        mergedRuns++;
      }
      runs = mergedRuns;
    }
  }

  private void insertionSort(int[] arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= left && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  private void merge(int[] arr, int left, int right) {
    int mid = left + (right - left) / 2;
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        arr[k++] = arr[i++];
      } else {
        arr[k++] = arr[j++];
      }
    }
    while (i <= mid) {
      arr[k++] = arr[i++];
    }
    while (j <= right) {
      arr[k++] = arr[j++];
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Optional Quicksort for potentially faster small run sorting
  private void quickSort(int[] arr, int left, int right, int pivot) {
    if (left < right) {
      int partitionIndex = partition(arr, left, right, pivot);
      quickSort(arr, left, partitionIndex - 1, arr[partitionIndex]);
      quickSort(arr, partitionIndex + 1, right, arr[partitionIndex]);
    }
  }

  private int partition(int[] arr, int left, int right, int pivot) {
    swap(arr, pivot, right); // Move pivot to the end
    int storeIndex = left;
    for (int i = left; i < right; i++) {
      if (arr[i] <= arr[right]) {
        swap(arr, i, storeIndex);
        storeIndex++;
      }
    }
    swap(arr, right, storeIndex); // Move pivot to its final position
    return storeIndex;
  }
}
