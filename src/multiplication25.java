import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class multiplication25 {
	
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
		//a=-I
		int a = fieldmultnegative(marr, x);
		int b = fieldmultiply(marr, 25, fieldmultcubed(marr, x));
		//d=-SR25
		int d = fieldmultnegative(marr, b);
		int k = fieldmultnined(marr, x);
		int e = fieldmultiply(marr, 24, k);
		//f=-SSR24
		int f = fieldmultnegative(marr, e);
		//g=-I-SR25
		int g = fieldadd(addarr, a, d);
		int h = fieldadd(addarr, g, f);
		return(h);
	}
	
	public static int Q(int[][] marr, int[][] addarr, int x){
		int a = fieldmultnined(marr, x);
		//b=-SS
		int b = fieldmultnegative(marr, a);
		int c = fieldmultiply(marr, fieldmultcubed(marr, x), 10);
		//d=-SR10
		int d = fieldmultnegative(marr, c);
		int e = fieldmultiply(marr, x, 4);
		//f=-R4
		int f = fieldmultnegative(marr, e);
		//g=-SS-SR10
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
	
	public static int albertMultiplication(int[][] marr, int[][] addarr, int x, int y){
		int a = fieldmultiply(marr, P(marr, addarr, x), SQ(marr, addarr, y));
		int b = fieldmultiply(marr, SP(marr, addarr, x), Q(marr, addarr, y));
		int c = fieldmultiply(marr, 25, b);
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
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		File inputFile = new File("Alb.txt");
		File inputFile2 = new File("alb2.txt");
		Scanner in = new Scanner(inputFile);
		Scanner in2 = new Scanner (inputFile2);
		PrintWriter out = new PrintWriter("result25.txt");
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
		// Read the input and write the output for addition
		for(int i=0; i<27; i++){
			String line = in2.nextLine();
			String[] numbers = line.split(" ");
			for(int j = 0; j<27 ; j++){
				addarr[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		//Print Albert's Division Ring
		for(int i=0; i< 27; i++){
			out.print(i + ":");
			for(int j=0; j<27; j++){
				out.print(albertMultiplication(marr, addarr, i, j) + " ");
			}
			out.println();
		}
		in.close();
		out.close();/*
		System.out.println("What would you like to multiply?");
		int x = s.nextInt();
		System.out.println("What would you like to multiply?");
		int y = s.nextInt();
		System.out.println(albertMultiplication(marr, addarr, x, y));
		for(int i=0; i<27; i++){
			System.out.println(i + ":" + albertMultiplication(marr, addarr, i,i));
		}
		for(int i=0; i<27; i++){
			for(int j=0; j<27; j++){
				System.out.println(j + ":" + albertMultiplication(marr, addarr, i,j)
				+ "and" + albertMultiplication(marr, addarr, j, i));
			}
			System.out.println("for" + (i+1));
		}  */
		for(int i=0; i<27; i++){
			int k = albpowerfour(marr, addarr, i);
			if(k==i){
				System.out.println(i);
			}
		}
		System.out.println("pick your number 1");
		int k = s.nextInt();
		System.out.println("pick your number 2");
		int j = s.nextInt();
		System.out.println(albertMultiplication(marr, addarr, k, j));
	}

}
