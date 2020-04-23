package arraysort;

/**
 * leetcodes
 * øÏÀŸ≈≈–Ú
 * @author lzz
 * @date 2020/4/23
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1,3,8,7,5,9,2,6,4,0};
        array = quickSort.quickSort(array);
        for (int num : array){
            System.out.println(num);
        }
    }

    public int[] quickSort(int[] array){
        return quickSort(array, 0, array.length-1);
    }

    private int[] quickSort(int[] array, int start, int end){
        if(array.length<=1 || start >= end || start < 0 || end >= array.length){
            return array;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start){
            quickSort(array, start, smallIndex - 1);
        }

        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int temp = array[pivot];
        int resultIndex = pivot;

        while(start < end){
            while(array[end] > temp && start < end){
                end--;
            }
            if(start < end){
                array[resultIndex] = array[end];
                resultIndex = end;
            }
            while(array[start] <= temp && start < end){
                start++;
            }
            if(start < end){
                array[resultIndex] = array[start];
                resultIndex = start;
            }
        }

        array[resultIndex] = temp;

        return resultIndex;
    }

}
