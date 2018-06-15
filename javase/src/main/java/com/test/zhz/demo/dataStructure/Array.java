package com.test.zhz.demo.dataStructure;/**
 * Created by zhz on 18/6/14.
 */

import lombok.Data;

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/14 上午10:36
 */

public class Array {
    @Data
    public class SortArray{
        private int[] array;
        /**二分法查找有序不重复数组  https://blog.csdn.net/u012152619/article/details/41774325 */
        public int find(int target){
            int lowerIndex = 0;
            int upperIndex = array.length-1;
            while (true){
                int index = (lowerIndex+upperIndex)/2;
                if(target==array[index]){
                    return index;
                }
                //不存在会死循环
                // 在当前下标与搜索段的最小下标重合时，代表搜索段中只包含1个或2个元素
                if(index==lowerIndex){
                    if(target == array[upperIndex]){
                        return upperIndex;
                    }else {
                        return -1;
                    }
                }
                if (target>array[index]){
                    lowerIndex = index;
                }else {
                    upperIndex = index;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortArray sortArray = new Array().new SortArray();
        sortArray.setArray(new int[]{1,2,3});
        System.out.println(sortArray.find(0));
    }

}
