package metodos_de_ordenacao.Metodos_sort;

public class bucketsort {
	
	private double tro;
	private
	
	long comp;
	
	public  double getTro() {
		return tro;
	}

	public  void setTro(double tro) {
		this.tro = tro;
	}

	public  long getComp() {
		return comp;
	}

	public  void setComp(long comp) {
		this.comp = comp;
	}

	public  void gets (listaencadeada[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			if(buckets[i]!=null){
				tro+=buckets[i].getTro();
			}
		}
		for (int i = 0; i < buckets.length; i++) {
			if(buckets[i]!=null){
				comp+=buckets[i].getComp();
			}
		}
	}
	
	public  void bucketSort(int [] array) {
		if (array.length <= 1) {
			return;
		}
		
		//criação dos bucktes
		listaencadeada[] buckets = new listaencadeada[array.length];
		
		//maior valor
		int maiorValor = array[0];
		for (int i: array) {
			if (i > maiorValor) 
				maiorValor = i;
		}
		
		//Distribuição dos elementos nos buckets
		for (int i=0;i<array.length;i++) {
			int indiceBucket = array[i] / array.length;
			if (buckets[indiceBucket] == null) {
				buckets[indiceBucket] = new listaencadeada();
				buckets[indiceBucket].inserirordenado(array[i]);
			}else
				buckets[indiceBucket].inserirordenado(array[i]);
		}
		//Combinar os elementos dos buckets em uma única lista ordenada
		int index = 0;
		for (int i=0;i<array.length;i++) {
			if (buckets[i] != null) {
				Nodo aux = buckets[i].getinicio();
				while (aux != null) {
					array[index++] = aux.getDado();
					aux = aux.getProx();
				}
			}
		}
		gets(buckets);
	}
//	public static void main(String[] args) {
//		int[] array = {18,64,92,28,49,83,56,70,38,44};
//		
//		System.out.println("Array antes da ordenação");
//		for (int num : array) {
//			System.out.print(num+" ");
//		}
//		bucketSort(array);
//		
//		System.out.println("\nArray depois da ordenação");
//		for (int num : array) {
//			System.out.print(num+" ");
//		}
//
//	}
//	
	
	
//	public int[] sort(int[] array) {
//		int max = Max(array);
//		int numBuckets = (int) Math.sqrt(array.length);
//		List<List<Integer>> buckets = new ArrayList<>();
//
//		// Inicializar os bukets.
//		for (int i = 0; i < numBuckets; i++) {
//			buckets.add(new ArrayList<>());
//		}
//
//		// Distribuir os elementos nos buckets.
//		for (int valor : array) {
//			int indiceBalde = valor * numBuckets / (max + 1);
//			buckets.get(indiceBalde).add(valor);
//		}
//
//		// Ordenar cada bucket e mistura-los.
//		int indice = 0;
//		for (List<Integer> bucket : buckets) {
//			Collections.sort(bucket);
//			for (int valor : bucket) {
//				array[indice++] = valor;
//			}
//		}
//		return array;
//	}
//
//	private static int Max(int[] arr) {
//		int max = arr[0];
//		for (int valor : arr) {
//			if (valor > max) {
//				max = valor;
//			}
//		}
//		return max;
//	}
	
	
	
    
//	  public Integer[] bucketSort(Integer[] arr, int n) {
//	    if (n <= 0)
//	      return arr;
//	    @SuppressWarnings("unchecked")
//	    int[] bucket = new int[n];
//
//	    // Create empty buckets
//	    for (int i = 0; i < n; i++)
//	    	int[] ss = new int[1];
//	      bucket[i] = new ArrayList<Integer>();
//
//	    // Add elements into the buckets
//	    for (int i = 0; i < n; i++) {
//	      int bucketIndex = arr[i] * n;
//	      bucket[bucketIndex]=arr[i];
//	    }
//
//	    // Sort the elements of each bucket
//	    for (int i = 0; i < n; i++) {
//	      Collections.sort((bucket[i]));
//	    }
//
//	    // Get the sorted array
//	    int index = 0;
//	    for (int i = 0; i < n; i++) {
//	      for (int j = 0, size = bucket[i].size(); j < size; j++) {
//	        arr[index++] = bucket[i].get(j);
//	      }
//	    }
//	    return arr;
//	  }
	}