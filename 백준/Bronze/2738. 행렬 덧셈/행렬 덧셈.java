import java.util.*;
public class Main{
    public static int[][] setArr(Scanner sc, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        return arr;
    }
    
    public static int[][] plusArr(int [][] firstArr, int[][] secondArr) {
        int[][] resultArr = new int[firstArr.length][firstArr[0].length];
        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[0].length; j++) {
                resultArr[i][j] = firstArr[i][j] + secondArr[i][j];
            }
        }
        
        return resultArr;
    }
    
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
        int[][] firstArr = new int[n][m];
        int[][] secondArr = new int[n][m];

        
        setArr(sc, firstArr);
        setArr(sc, secondArr);
        int[][] resultArr = plusArr(firstArr, secondArr);
        
        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[0].length; j++) {
                System.out.print(resultArr[i][j] + " ");
            }
            System.out.println();
        }
        


	}
}