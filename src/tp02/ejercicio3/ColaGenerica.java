package tp02.ejercicio3;
//import tp02.ejercicio2.*;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class ColaGenerica<T> {
	//public ListaGenerica<T> dato = new ListaEnlazadaGenerica<T>();
	private ListaEnlazadaGenerica<T> dato;
	
	public ColaGenerica(){
		this.dato = new ListaEnlazadaGenerica<T>();
	}
	public void encolar(T dato) {
		this.dato.agregarFinal(dato);
	}
	
	public T desencolar() {
		if (this.esVacia())
			return null;
		T elem = this.dato.elemento(1);
		this.dato.eliminarEn(1);
		return elem;
	}
	
	public T tope() {
		T x= null;
			if (!this.esVacia()) x= this.dato.elemento(1);
		return x;
	}
	
	public boolean esVacia() {
		return this.dato.tamanio()==0;
	}
}