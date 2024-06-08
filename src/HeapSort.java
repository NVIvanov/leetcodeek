import java.util.Arrays;

public class HeapSort {

    public static void heapify(int[] arr, int i, int heapSize) {
        int l = 2*(i+1) - 1; //fix
        int r = 2*(i+1);
        int largest = i;
        //проверяем, на самом ли деле i-й элемент самый большой
        if (l < heapSize && arr[l] > arr[i]) {
            largest = l;
        }
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, largest, heapSize); // продолжаем опускать элемент вниз пирамиды
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // проходимся по массиву как по пирамиде снизу вверх, начиная с листов, представляя их деревьями
            // и постепенно строя из них невозрастающую пирамиду
            heapify(arr, i, arr.length);
        }
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;
        for (int i = arr.length-1; i > 0; i--) {
            // отправляем в конец наибольшее число, то есть первый узел пирамиды
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            //так как первый элемент теперь часть отсортированного массива, уменьшаем размер пирамиды
            heapSize--;
            //равновесие может нарушиться, так что нужно сделать heapify для новой вершины
            heapify(arr, 0, heapSize);
        }
    }

    public static int heapMax(int[] arr) {
        return arr[0];
    }

    public static int extractMax(int[] arr, int heapSize) {
        if (heapSize == 0) {
            throw new RuntimeException("queue is empty");
        }
        int max = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        heapify(arr, 0, heapSize);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
        int heapSize = arr.length;
        for (int i = 0; i < 2; i++) {
            System.out.println(extractMax(arr, heapSize));
            heapSize--;
        }
    }
}
