package jianzhioffer;

/**
 * �����˻�����
 *
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 * ����ʹ�ó�����
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
 * ����˼·��
 * ������B[i] ���Կ������¾���� i �еĳ˻�
 *  1   A[2] A[3] ... A[n-3] A[n-2] A[n-1]
 * A[1]  1   A[3] ... A[n-3] A[n-2] A[n-1]
 * A[1] A[2]  1   ... A[n-3] A[n-2] A[n-1]
 * A[1] A[2] A[3] ...   1    A[n-2] A[n-1]
 * A[1] A[2] A[3] ... A[n-3]   1    A[n-1]
 * A[1] A[2] A[3] ... A[n-3] A[n-2]   1
 *
 * �����ȸ�ֵ�� B[i] ÿ����ߵĳ˻����ٳ��ұߵ��������ǽ��
 */