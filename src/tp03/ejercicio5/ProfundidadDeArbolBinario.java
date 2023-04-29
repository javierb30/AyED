package tp03.ejercicio5;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.*;
public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> a;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> a) {
		this.a = a;
	}
	
	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		int nivelAct = 0;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux;
		cola.encolar(a);
		cola.encolar(null);
		while (!cola.esVacia() && nivelAct <= p) {
			aux = cola.desencolar();
			if (aux != null) {
				if(nivelAct == p)
					suma += aux.getDato();
				else {
					if(aux.tieneHijoIzquierdo())
						cola.encolar(aux.getHijoIzquierdo());
					if(aux.tieneHijoDerecho())
						cola.encolar(aux.getHijoDerecho());
				}
			}
			else {
				if (!cola.esVacia()) {
					nivelAct++;
					cola.encolar(null);
				}
				else if (nivelAct < p)
					suma = -1;
			}
		}
		return suma;
	}
}
