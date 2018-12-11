package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by shenke on 2018/12/11.
 */
public class SelectSort {

    public static void sort(int[] arr, boolean ascending){
        for (int i = 0; i < arr.length; i ++){
            int key = arr[i];
            int index = i;
            for(int j = i + 1; j < arr.length; j ++){
                // 找到小于当前元素且最小的元素,记录值和下标
                if(ascending){
                    if(arr[j] < key){
                        key = arr[j];
                        index = j;
                    }
                } else{
                    // 找到大于当前元素且最大的元素,记录值和下标
                    if(arr[j] > key){
                        key = arr[j];
                        index = j;
                    }
                }
            }
            // 和当前元素交换位置,index = i保证了当前元素就是最小/最大的情况下正好就是当前位置
            arr[index] = arr[i];
            arr[i] = key;
        }
    }

    @Test
    public void selectSortTest(){
        int[] arr = new int[]{9,4,3,8,2,5,1,6,7};
        sort(arr, true);
        System.out.printf("ascending sort : %s\n", Arrays.toString(arr));
        sort(arr, false);
        System.out.printf("descending sort : %s\n", Arrays.toString(arr));
    }

}
