package tp03.ejercicio3;
import tp03.ejercicio1.*;
import tp02.ejercicio2.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> a;

	public ContadorArbol(ArbolBinario<Integer> a) {
		this.a = a;
	}
	
	private ListaEnlazadaGenerica<Integer> contarParesInOrden(ListaEnlazadaGenerica<Integer> L, ArbolBinario<Integer> arbol){
		if (arbol.tieneHijoIzquierdo()) 
			L = contarParesInOrden(L, arbol.getHijoIzquierdo());
		if((arbol.getDato()%2)==0) 
			L.agregarFinal(arbol.getDato());
		if (arbol.tieneHijoDerecho()) 
			L = contarParesInOrden(L, arbol.getHijoDerecho());
		return L;
	}
	
	private ListaEnlazadaGenerica<Integer> contarParesPostOrden(ListaEnlazadaGenerica<Integer> L, ArbolBinario<Integer> arbol){
		if (arbol.tieneHijoIzquierdo()) 
			L = contarParesPostOrden(L, arbol.getHijoIzquierdo());
		if (arbol.tieneHijoDerecho()) 
			L = contarParesPostOrden(L, arbol.getHijoDerecho());
		if((arbol.getDato()%2)==0) 
			L.agregarFinal(arbol.getDato());
		return L;
	}
	public ListaEnlazadaGenerica<Integer> numerosPares() {
		ListaEnlazadaGenerica<Integer> L = new ListaEnlazadaGenerica<Integer>();
		return contarParesInOrden(L, this.a); //contarParesPostOrden puede ser tambien
	}
}
