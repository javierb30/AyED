package tp03.ejercicio3;

import tp03.ejercicio1.ArbolBinario;
import tp02.ejercicio2.ListaEnlazadaGenerica;
public class TestContadorArbol {

	public static void main(String[] args) {
		ArbolBinario<Integer> a1= new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> a2= new ArbolBinario<Integer>(2);
		a1.agregarHijoIzquierdo(a2);
		ArbolBinario<Integer> a3= new ArbolBinario<Integer>(3);
		a1.agregarHijoDerecho(a3);
		ArbolBinario<Integer> a4= new ArbolBinario<Integer>(4);
		a2.agregarHijoIzquierdo(a4);
		ArbolBinario<Integer> a5= new ArbolBinario<Integer>(5);
		a2.agregarHijoDerecho(a5);
		ArbolBinario<Integer> a6= new ArbolBinario<Integer>(6);
		a3.agregarHijoIzquierdo(a6);
		ArbolBinario<Integer> a7= new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> a8= new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> a9= new ArbolBinario<Integer>(9);
		a5.agregarHijoIzquierdo(a7);
		a5.agregarHijoDerecho(a8);
		a4.agregarHijoIzquierdo(a9);
		
		ContadorArbol ca=new ContadorArbol(a1);
		ListaEnlazadaGenerica<Integer> L = new ListaEnlazadaGenerica<Integer>();
		L= ca.numerosPares();
		L.comenzar();
		while (!L.fin())
			System.out.print(L.proximo());
	}

}
