package tp04.ejercicio3;
import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.*;
public class RecorridosAG {
	
	/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	pasados como parámetros, recorrido en preorden.*/
	//PreOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.numerosImparesMayoresQuePreOrden(a,n,l);
		return l;
	}
	
	private void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if(! a.esVacio()) {
			if ((a.getDato() > n) && (a.getDato() % 2 != 0))
				l.agregarFinal(a.getDato());
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				while(!hijos.fin())
					numerosImparesMayoresQuePreOrden(hijos.proximo(),n,l);
			}
		}
	}
	//InOrden
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.numerosImparesMayoresQueInOrden(a,n,l);
		return l;
	}
	
	private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		hijos.comenzar();
		if(!hijos.esVacia())
			numerosImparesMayoresQueInOrden(hijos.proximo(),n,l);
		if ((a.getDato() > n) && (a.getDato() % 2 != 0))
			l.agregarFinal(a.getDato());
		while(!hijos.fin())
			numerosImparesMayoresQueInOrden(hijos.proximo(),n,l);
	}
	//PostOrden
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		this.numerosImparesMayoresQuePostOrden(a,n,l);
		return l;
	}
	
	private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if(a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin())
				numerosImparesMayoresQuePostOrden(hijos.proximo(),n,l);
		}
		if ((a.getDato() > n) && (a.getDato() % 2 != 0))
			l.agregarFinal(a.getDato());
	}
	
	public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if( aux != null) {
				if(aux.getDato() > n && aux.getDato() % 2 != 0){
					l.agregarFinal(aux.getDato());
				}
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
			else {
				if(!cola.esVacia())
					cola.encolar(null);
			}
		}
		return l;
	}
	
}
