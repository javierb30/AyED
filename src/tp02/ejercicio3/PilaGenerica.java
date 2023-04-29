package tp02.ejercicio3;
import tp02.ejercicio2.*;
//import tp03.ejercicio1.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
private ListaEnlazadaGenerica<T> dato;
	
	public PilaGenerica() {
		this.dato = new ListaEnlazadaGenerica<T>();
	}
	//public ListaGenerica<T> dato = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elemento) {
		this.dato.agregarFinal(elemento);
	}
	
	public T desapilar() {
		T elemento = this.tope();
		this.dato.eliminar(elemento);
		return elemento;
	}
	
	public T tope() {
		T elemento = null;
		this.dato.comenzar();
		while(! this.dato.fin()) {
			elemento = this.dato.proximo();
		}
		return elemento;
	}
	
	public boolean esVacia() {
		return this.dato.esVacia();
	}
	
	
}
