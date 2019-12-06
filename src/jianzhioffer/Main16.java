package jianzhioffer;

/**
 * 构建乘积函数
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Main16 {

    public int[] multiply(int[] A) {
        if(A == null || A.length < 2){
            return null;
        }

        int len = A.length;
        int[] B = new int[len];
        for(int i=0, temp=1; i<len; temp *= A[i], ++i){
            B[i] = temp;
        }
        for(int i=len-1, temp=1; i>=0; temp *= A[i], --i){
            B[i] *= temp;
        }

        return B;
    }

}
/**
 * 解题思路：
 * 分析：B[i] 可以看作如下矩阵第 i 行的乘积
 *  1   A[2] A[3] ... A[n-3] A[n-2] A[n-1]
 * A[1]  1   A[3] ... A[n-3] A[n-2] A[n-1]
 * A[1] A[2]  1   ... A[n-3] A[n-2] A[n-1]
 * A[1] A[2] A[3] ...   1    A[n-2] A[n-1]
 * A[1] A[2] A[3] ... A[n-3]   1    A[n-1]
 * A[1] A[2] A[3] ... A[n-3] A[n-2]   1
 *
 * 所以先赋值给 B[i] 每行左边的乘积，再乘右边的数，既是结果
 */