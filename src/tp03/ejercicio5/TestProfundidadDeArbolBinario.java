package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class TestProfundidadDeArbolBinario {

	public static void main(String[] args) {
		ArbolBinario<Integer> a1= new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> a2= new ArbolBinario<Integer>(2);
		a1.agregarHijoIzquierdo(a2);
		ArbolBinario<Integer> a3= new ArbolBinario<Integer>(3);
		a1.agregarHijoDerecho(a3);
		ArbolBinario<Integer> a4= new ArbolBinario<Integer>(4);
		a2.agregarHijoIzquierdo(a4);
		ArbolBinario<Integer> a5= new ArbolBinario<Integer>(5);
		a3.agregarHijoIzquierdo(a5);
		ArbolBinario<Integer> a6= new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> a7= new ArbolBinario<Integer>(7);
		a3.agregarHijoDerecho(a6);
		a4.agregarHijoDerecho(a7);
		
		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(a1);
		System.out.print(prof.sumaElementosProfundidad(2));

	}
}
