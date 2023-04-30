package tp04.ejercicio1;

import tp02.ListaEnlazadaGenerica;
import tp02.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	/* devuelve la altura del árbol, es decir, la longitud del camino más largo
	desde el nodo raíz hasta una hoja*/
	public Integer altura() {
		int altura = -1;
		if(this.esHoja())
			return 0;
		else {
			if(this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) 
					altura = Math.max(altura, hijos.proximo().altura());
			}
		}
		return altura+1;
	}
	/*devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
		es la longitud del único camino de la raíz al nodo.*/
	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		int nivelAct = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if(aux.getDato() == dato)
					return nivelAct;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin() ) 
						cola.encolar(hijos.proximo());
				}
			}
			else if (!cola.esVacia()) {
					nivelAct++;
					cola.encolar(null);
			}
		}
		return -1;
	}

	/*la amplitud (ancho) de un árbol se define como la cantidad de nodos que
	se encuentran en el nivel que posee la mayor cantidad de nodos.*/
	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		int nivelAct = 0;
		int cantMax = -1;
		int cant = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cant++;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin() ) 
						cola.encolar(hijos.proximo());
				}
			}
			else {
				if(cant > cantMax)
					cantMax = cant;
				cant = 0;
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivelAct++;
				}
			}
		}
		return cantMax;
	}
	//Mas complejo
	public Boolean esAncestro (T a,T b) {
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<T>();
		lista.agregarInicio(this.getDato());
		esAncestro (a,b,lista,camino);
		if ((camino.incluye(a)) && (camino.incluye(b))){
			return true;
		}
		return false;	
	}
	
	private void clonar(ListaGenerica<T> lista,ListaGenerica<T> camino) {
		lista.comenzar();
		while (!lista.fin()) {
			camino.agregarFinal(lista.proximo());
		}
	}

	private void esAncestro(T a, T b,ListaGenerica<T> lista,ListaGenerica<T> camino) {
		if (this.getDato() == b) 
			clonar(lista,camino);
		if (camino.esVacia()){
			ListaGenerica<ArbolGeneral<T>> lhijos = this.getHijos();
			lhijos.comenzar();
			while ((!lhijos.fin()) && (camino.esVacia())){
					ArbolGeneral<T> aux = lhijos.proximo();
					lista.agregarFinal(aux.getDato());
					aux.esAncestro(a,b,lista,camino);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	//Mas del estilo que se venia trabajando
	public Boolean esAncestro2 (T a,T b) {
		return buscarA(a,b,this);
	}
	
	private Boolean buscarA (T a, T b, ArbolGeneral<T> arbol) {
		Boolean ok = false;
		if (arbol.getDato() == a) {
			if (arbol.tieneHijos()) {
				ListaGenerica <ArbolGeneral<T>> l = arbol.getHijos();
				l.comenzar();
				while((!l.fin())&& (!ok)) 
					ok = buscarB(a,b,l.proximo());
			}
		}
		else{if (arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> l = arbol.getHijos();
			l.comenzar();
			while((!l.fin())&& (!ok)) 
				ok = buscarA(a,b,l.proximo());	
		}}
	 return ok;
    }
	
	private Boolean buscarB (T a, T b, ArbolGeneral<T> arbol) {
		Boolean ok = false;
		if (arbol.getDato() == b)
			return true;
		if (arbol.tieneHijos()) {
			ListaGenerica <ArbolGeneral<T>> l = arbol.getHijos();
			l.comenzar();
			while((!l.fin())&& (!ok)) 
				ok = buscarB(a,b,l.proximo());
		}
	return ok;	
	}
	
	
	
	/*public boolean esAncestro(T a,T b) {
		boolean encontre = false;
		if(this.getDato() == a) {
			encontre= true;
			if(this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) 
					encontre = hijos.proximo().esAncestro(a, b);
			}
		}
		else {
			if(this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) 
					encontre = hijos.proximo().esAncestro(a, b);
			}
		}
		//Acomodar
		return true;
	}*/
}