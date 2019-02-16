package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 * Created by shenke on 2018/12/11.
 */
public class InsertSort {

    public static void sort(int[] arr, boolean ascending){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
        }
    }

    @Test
    public void insertSortTest(){
        int[] arr = new int[]{2,1,3,7,9,4,6,5,8};
        sort(arr, true);
        System.out.printf("ascending sort : %s\n", Arrays.toString(arr));
    }

}
