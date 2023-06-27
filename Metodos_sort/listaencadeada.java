package metodos_de_ordenacao.Metodos_sort;

public class listaencadeada {
	
	private Nodo inicio;
	private long comp;
	private double tro;
	
	
	public long getComp() {
		return comp;
	}

	public void setComp(long comp) {
		this.comp = comp;
	}

	public double getTro() {
		return tro;
	}

	public void setTro(double tro) {
		this.tro = tro;
	}

	//construtor
	public listaencadeada() {
		inicio=null;
		comp=0;
		tro=0;
	}
	
	public boolean estavazia() {
		return inicio==null;
	}
	
	public Nodo getinicio() {
		return inicio;
	}
	
	public void inserirordenado(int dado) {
		Nodo novonodo=new Nodo(dado);
		if(estavazia()) {
			inicio=novonodo;
			comp++;
			return;
		}
		if(dado<=inicio.getDado()) {
			novonodo.setProx(inicio);
			inicio=novonodo;
			tro++;
			comp++;
			return;
		}
		
		Nodo atual=inicio;
		Nodo anterior=null;
		
		while(atual!=null && dado>atual.getDado()) {
			anterior=atual;
			atual=atual.getProx();
			comp++;
		}
		novonodo.setProx(atual);
		anterior.setProx(novonodo);
		tro++;
		return;
	}
	
}
