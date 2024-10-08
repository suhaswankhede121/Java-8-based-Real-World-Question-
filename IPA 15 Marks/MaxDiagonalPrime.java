public class MaxDiagonalPrime {

    static boolean isPrime(int no){
        if(no<=1) return false;
        for(int i=2;i<=Math.sqrt(no);i++){
            if(i%no==0){
                return false;
            }
        }
        return true;
    }
    static int maxPrime(int matrix[][]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j){
                    if(matrix[i][j]>max){
                        max=matrix[i][j];
                    }
                }
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int matrix[][]={
            {3,8,9},
            {4,5,6},
            {1,2,7}
        };
        System.out.println(maxPrime(matrix));
    }
}
