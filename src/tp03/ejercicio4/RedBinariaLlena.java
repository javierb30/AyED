package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena<T> {
	private ArbolBinario<Integer> a;
	public RedBinariaLlena(ArbolBinario<Integer> a) {
		this.a=a;
	}
	
	public int retardoReenvio() {
		return retardoReenvio(a);
	}
	
	private int retardoReenvio(ArbolBinario<Integer> a) {
		if(a.esHoja())
			return a.getDato();
		int valorHI = retardoReenvio(a.getHijoIzquierdo());
		int valorHD = retardoReenvio(a.getHijoDerecho());
		return Math.max(valorHI, valorHD) + a.getDato(); 
	}
}
