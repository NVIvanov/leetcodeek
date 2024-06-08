import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = 0, k = 0;
        boolean needPositive = true;
        while (i < nums.length || j < nums.length) {
            boolean found = false;
            if (needPositive) {
                while (i < nums.length && !found) {
                    if (nums[i] > 0) {
                        result[k++] = nums[i];
                        found = true;
                    }
                    i++;
                }
                needPositive = false;
            } else {
                while (j < nums.length && !found) {
                    if (nums[j] < 0) {
                        result[k++] = nums[j];
                        found = true;
                    }
                    j++;
                }
                needPositive = true;
            }
        }
        return result;
    }
    /*
        O(N), O(N)
        первый указатель на положительные числа, второй указатель на отрицательные числа.
        признак, указывающий на то, какое число нужно, положительное или отрицательное
        результат - массив с числами, новый.

        3,1,-2,-5,2,-4
        i = 0
        j = 0
        need_positive = true;

        i = 0 // 3
        res = [3]
        i++;
        need_positive = false;

        j = 0, 1, 2 // -2
        res = [3, -2]
        j++
        need_positive = true

        i = 1 // 1
        res = [3, -2, 1]
        i++
        need_positive = false

        j = 3 // -5
        res = [3, -2, 1, -5]
        j++
        need_positive = true

        i = 2, 3, 4 // 2
        res = [3, -2, 1, -5, 2]
        i++ / 5
        need_positive = false

        j = 4, 5
        res = [3, -2, 1, -5, 2, -4]
        j++ / 6
        need_positive = true

        i = 5, 6

        пока (i < len и j < len) {
            если нужно положительное {
                проходим по i, пока i < len и не найден элемент
                    если нашли положительное
                        добавляем в массив по индексу k++
                        элемент найден
                    i++
            } иначе {
                проходим по j, пока j < len и не найден элемент
                    если нашли отрицательное
                        добавляем в массив по индексу k++
                        элемент найден
                    j++
            }
        }

     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }
}
