package metodos_de_ordenacao.Metodos_sort;
import java.util.Arrays;
import java.util.Random;

public class testetrabalhoestruturadedados{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar1 = new int[100000];
		int[] ar2 = new int[1000000];
//		int[] ar3= {1,66,88,4,3,5,44,5,3,4,543,2,4,534,5,435,25235,453,2423,4,552,532,534,32,4235,3453,3534};
		
		Metodos_de_ordenacao ord = new Metodos_de_ordenacao();
		bucketsort buk = new bucketsort();
	
		Random rand = new Random();
		
		for (int i = 0; i < ar1.length; i++) {
			ar1[i]=rand.nextInt(500000);
		}
		for (int i = 0; i < ar2.length; i++) {
			ar2[i]=rand.nextInt(500000);
		}
		
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		
			
		for (int i = 0; i < ar1.length; i++) {
			ar1[i] = ar1[ar1.length-i-1];
		}
		for (int i = 0; i < ar2.length; i++) {
			ar2[i] = ar2[ar2.length-i-1];
		}
		
//		for(int num:ar1) {
//		System.out.print(num+" ");
//		}
		
//		for(int num:ar2) {
//			System.out.print(num+" ");
//		}
		
		
//		System.out.println("array antes");
//		for (int i = 0; i < ar1.length; i++) {
//			System.out.println(ar1[i]+' ');
//		}
		
		long inicio=System.nanoTime();
//		int[]arr1=buk.bucketsort(ar1);
		buk.bucketSort(ar1);
		//Marca o tempo de execucao do sistema
		long fim = System.nanoTime();
		double tempoexecucao =(fim-inicio)/1000000.0;
		
		
		System.out.println("comparações: "+buk.getComp());
		System.out.println("trocas: "+buk.getTro());
		System.out.println("Tempo de execução 100.000: "+tempoexecucao+"ms");
		
//		for(int num:arr1) {
//			System.out.print(num+" ");
//		}
		
//		System.out.println("array depois");
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.println(arr1[i]+' ');
//		}
		
		
//		long inicio1=System.nanoTime();
//		
//		ord.sort(ar2);
//		
//		//Marca o tempo de execucao do sistema
//		long fim1 = System.nanoTime();
//		double tempoexecucao1 =(fim1-inicio1)/1000000.0;
//		
////		System.out.println("comparações: "+ord.getComp());
////		System.out.println("trocas: "+ord.getTro());
//		System.out.println("Tempo de execução 1,000.000: "+tempoexecucao1+"ms");
		
	}

}
