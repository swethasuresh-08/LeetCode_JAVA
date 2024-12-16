/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/


class Solution {
    public void setZeroes(int[][] matrix) {

        int N=matrix.length;
        int M=matrix[0].length;
        //Col Array == matrix[0][..]
        //Row Array == matrix[..][0]
        int colj0=1;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(matrix[i][j]==0)
                {
                    //Make entry in ith row
                    matrix[i][0]=0;
                    //Make entry in jth column
                    if(j!=0)
                    matrix[0][j]=0;
                    else
                    colj0=0;//When j is zeroth column
                }
            }
        }
        //Now iterate rest all and check its row and col array and convert to zero
        for(int i=1;i<N;i++)
        {
            for(int j=1;j<M;j++)
            {
                if(matrix[0][j]==0||matrix[i][0]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        //Now check for row and col array
        if(matrix[0][0]==0)
        {
            for(int j=1;j<M;j++)
            matrix[0][j]=0;
        }
        if(colj0==0)
        {
            for(int i=0;i<N;i++)
            matrix[i][0]=0;
        }
    }
}
/*      int N=matrix.length;
        int M=matrix[0].length;
        int[] col=new int[M];
        int[] row=new int[N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++){
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(row[i]==1||col[j]==1)
                matrix[i][j]=0;
            }
        }*/
