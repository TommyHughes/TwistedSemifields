
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class multiplication {
	
	public static int fieldmultiply(int[][] marr,int x, int y){
		return(marr[x][y]);
	}
	
	public static int fieldmultcubed(int[][] marr, int x){
		return(fieldmultiply(marr, fieldmultiply(marr, x, x), x));
	}
	
	public static int fieldmultnined(int[][] marr, int x){
		return(fieldmultcubed(marr, fieldmultcubed(marr, x)));
	}
	
	public static int fieldadd(int[][] addarr, int x, int y){
		return(addarr[x][y]);
	}
	public static int fieldmultnegative(int[][] marr, int x){
		return(fieldmultiply(marr, 2, x));
	}
	public static int P(int[][] marr, int[][] addarr, int x){
		int a = fieldmultnegative(marr, x);
		int b = fieldmultiply(marr, 3, fieldmultcubed(marr, x));
		int d = fieldmultnegative(marr, b);
		int k = fieldmultnined(marr, x);
		int e = fieldmultiply(marr, 17, k);
		int f = fieldmultnegative(marr, e);
		int g = fieldadd(addarr, a, d);
		int h = fieldadd(addarr, g, f);
		return(h);
	}
	public static int Q(int[][] marr, int[][] addarr, int x){
		int a = fieldmultnined(marr, x);
		int b = fieldmultnegative(marr, a);
		int c = fieldmultiply(marr, fieldmultcubed(marr, x), 26);
		int d = fieldmultnegative(marr, c);
		int e = fieldmultiply(marr, x, 15);
		int f = fieldmultnegative(marr, e);
		int g = fieldadd(addarr, b, d);
		int h = fieldadd(addarr, g, f);
		return(h);
		
	}
	
	public static int SQ(int[][] marr, int[][] addarr, int x){
		return(fieldmultcubed(marr, Q(marr, addarr, x)));
	}
	
	public static int SP(int[][] marr, int[][] addarr, int x){
		return(fieldmultcubed(marr, P(marr, addarr, x)));
	}
	
	public static int albertMultiplication(int[][] marr, int[][]addarr, int x, int y){
		int a = fieldmultiply(marr, P(marr, addarr, x), SQ(marr, addarr, y));
		int b = fieldmultiply(marr, SP(marr, addarr, x), Q(marr, addarr, y));
		int c = fieldmultiply(marr, 3, b);
		int d = fieldmultnegative(marr, c);
		int e = fieldadd(addarr, a, d);
		return(e);
	}
	
	public static int albpowerfour(int[][] marr, int[][] addarr, int x){
		int z = albertMultiplication(marr, addarr, x, x);
		int zz = albertMultiplication(marr, addarr, z, z);
		return(zz);
	}
	
	public static void main(String[] args)throws FileNotFoundException {
//Construct Scanner and PrintWriter objects for reading and writing
Scanner s = new Scanner(System.in);
File inputFile = new File("Alb.txt");
File inputFile2 = new File("alb2.txt");
Scanner in = new Scanner(inputFile);
Scanner in2 = new Scanner (inputFile2);
PrintWriter out = new PrintWriter("result.txt");
PrintWriter out2 = new PrintWriter("result2.txt");
PrintWriter out3 = new PrintWriter("result3.txt");
int[][] marr = new int[27][27];
int[][] addarr = new int[27][27];

//Read the input and write the output for multiplication
for(int i=0; i<27; i++){
	String line = in.nextLine();
	String[] numbers = line.split(" ");
	for(int j = 0; j<27 ; j++){
		marr[i][j] = Integer.parseInt(numbers[j]);
	}
}
for(int i=0; i<27; i++){
	for(int j=0; j<27; j++){
		out.print(marr[i][j] + " ");
	}
	out.println();
}
// Read the input and write the output for addition
for(int i=0; i<27; i++){
	String line = in2.nextLine();
	String[] numbers = line.split(" ");
	for(int j = 0; j<27 ; j++){
		addarr[i][j] = Integer.parseInt(numbers[j]);
	}
}
for(int i=0; i<27; i++){
	for(int j=0; j<27; j++){
		out2.print(addarr[i][j] + " ");
	}
	out2.println();
}
//Print Albert's Division Ring
for(int i=0; i< 27; i++){
	out3.print(i + ":");
	for(int j=0; j<27; j++){
		out3.print(albertMultiplication(marr, addarr, i, j) + " ");
	}
	out3.println();
}
in.close();
out.close();
in2.close();
out2.close();
out3.close();
/*
System.out.print("what would you like to input in Alberts Ring 1?");
int x = s.nextInt();
System.out.print("what would you like to input in Alberts Ring 2?");
int y = s.nextInt();
System.out.println(albertMultiplication(marr, addarr, x, y));
for(int i=0; i<27; i++){
	for(int j=0; j<27; j++){
		System.out.println(j + ":" + albertMultiplication(marr, addarr, i,j)
		+ "and" + albertMultiplication(marr, addarr, j, i));
	}
	System.out.println("for" + (i+1));
}
for(int i=0; i<27; i++){
	int k = albpowerfour(marr, addarr, i);
	if(k==i){
		System.out.println(i);
	}
}
*/


System.out.println("pick your number 1");
int k = s.nextInt();
System.out.println("pick your number 2");
int j = s.nextInt();
System.out.println(albertMultiplication(marr, addarr, k, j));




/*
System.out.println("which number would you like to square in the semifield?");
int k = s.nextInt();
System.out.println(albertMultiplication(marr, addarr, k, k));
*/


/* Finding Squares
int[] temp = new int[27];
int[] temp2 = new int[27];
for(int i=0 ; i<27; i++){
	temp[i] = albertMultiplication(marr, addarr, i, i);
	for(int j=0; j<27; j++){
		int z = 0;
		for(int k=0; k<27; k++){
			if(temp[k] == j){
				z=z+1;
			}
		temp2[j] = z;
		}
	}
}
for(int i=0; i<27; i++){
	System.out.println(i + ":" + temp2[i]);
}
*/
	}
}
