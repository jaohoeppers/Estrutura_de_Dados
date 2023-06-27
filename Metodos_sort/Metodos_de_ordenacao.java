package metodos_de_ordenacao.Metodos_sort;

import java.util.Stack;

public class Metodos_de_ordenacao {
	
	public int[] comb(int[] input) {
		long comp=0;
		long tro=0;
	    int gap = input.length;
	    boolean swapped = true;
	    while (gap > 1 || swapped) {
	        if (gap > 1) {
	            gap = (int) (gap / 1.247330950103979);
	        }
	        int i = 0;
	        swapped = false;
	        while (i + gap < input.length) {
	        	comp++;
	            if (input[i] > input[i + gap]) {
	            	tro++;
	                int t = input[i];
	                input[i] = input[i + gap];
	                input[i + gap] = t;
	                swapped = true;
	            }
	            i++;
	        }
	    }
	    System.out.println("comparaçoes: "+comp);
	    System.out.println("trocas: "+tro);
	    return input;
	}

	public int[] bubblesort(int array[]) {
		int temp = 0;
		int comp=0;
		double tro=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				comp++;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					tro++;
				}
			}
		}
		System.out.println("comparações: "+comp);
		System.out.println("trocas: "+tro);
		
		return array;
	}

	public int[] bubblesort2(int array[]) {
		int temp = 0;
		boolean val1=false;
		int xx=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			for (int x = 0; x < array.length; x++) {
				if(array[x]>=array[x+1]) {
					val1=true;
					xx=x;
				}
				else {
					val1=false;
					xx=x;
					}
			}
			if(val1 && xx==array.length) {
				return array;
			}
			xx=0;
		}
		return array;
	}

	public int[] selectionsort(int array[]) {
		long comp=0;
		double tro=0;
		int min, temp;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i+1; j < array.length; j++) {
				comp++;
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if(min!=i) {
				tro++;
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		System.out.println("comparações: "+comp);
		System.out.println("trocas: "+tro);
		
		return array;
	}
	
	public int[] insertionsort(int array[]) {
		long comp=0;
		double tro=0;
		int pivo, j;
		for (int i = 0; i < array.length; i++) {
			pivo=array[i];
			j=i-1;
			comp++;
//			System.out.println(comp);
			while(j>0&&array[j]>pivo) {
				array[j+1]=array[j];
				j=j-1;
				tro++;
				
			}
			array[j+1]=pivo;
		}
		System.out.println("comparações: "+comp);
		System.out.println("trocas: "+tro);
		
		return array;
	}
	
	public int[] insertionsort2(int array[],int min, int max) {
		int pivo,j;
		for (int i = min+1; i < max; i++) {
			pivo=array[i];
			j=i-1;
			while(j>0&&array[j]>pivo&&j>=min) {
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=pivo;
		}
		return array;
	}
	
	public boolean verord(int[]array) {
		int jj=0;
		for (int i = 0; i < array.length; i++) {
			jj=array[i];
		}
		if (array[0]<jj){
			return(true);
		}
		else {
			return(false);
		}
	}
	long comp=0;
	double tro=0;

	public int[] mergeSort(int array[],int inicio, int fim){
		int meio;
		if (inicio<fim){
			meio = (inicio+fim)/2;
			mergeSort(array,inicio,meio);
			mergeSort(array,meio+1,fim);
			merge(array,inicio,meio,fim);
	     }
		System.out.println("comparações: "+comp);
		System.out.println("trocas: "+tro);
		
		return array;
	}
	
	private void merge(int array[],int inicio,int meio, int fim){
		int aux[] = new int[array.length];
		
		for (int i = inicio; i <=meio; i++) {
			aux[i] = array[i];
		}
		for (int j = meio+1; j <=fim; j++) {
			aux[fim+meio+1-j] = array[j];
		}
		int i = inicio;
		int j = fim;
		comp++;
		for (int k = inicio; k <=fim; k++) {
			comp++;
			if (aux[i]<=aux[j]){
				array[k] = aux[i];
				i=i+1;
				tro++;
			}else{
				array[k] = aux[j];
				j=j-1;
				tro++;
			}
		}
	}
	    
	public void quickSort(int X[], int inicio, int fim){
		Stack<Integer> pilha = new Stack<>();
	    pilha.push(inicio);
	    pilha.push(fim);
	    
	    while (!pilha.isEmpty()) {
	        fim = pilha.pop();
	        inicio = pilha.pop();
	        
	        int q = particao(X, inicio, fim);
	        
	        if (inicio < q) {
	            pilha.push(inicio);
	            pilha.push(q);
	        }
	        
	        if (q + 1 < fim) {
	            pilha.push(q + 1);
	            pilha.push(fim);
	        }
	    }
	}
	
	private int particao(int X[],int inicio, int fim){
		int pivo, i, j, aux;
		pivo = X[(int) (inicio+fim)/2];
		i = inicio-1;
		j = fim+1;
		while (i < j){
			do{
				j = j-1;
				comp++;
			}while (X[j] > pivo);
			do{
				i = i+1;
				comp++;
			}while (X[i] < pivo);
			
			if(i < j){
				aux = X[i];
				X[i] = X[j];
				X[j] = aux;
				tro++;
			}	
		}
		return j;
	}
}
