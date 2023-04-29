package tp03.ejercicio1;

public class TestArbolBinario {
	public static void main(String[] args) {
		ArbolBinario<Integer> a1= new ArbolBinario<Integer>(1);
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
		
		/*a1.imprimir();
		System.out.println();
		a1.espejo().imprimir();
		System.out.println();
		System.out.print(a1.contarHojas()); */
		//a1.entreNiveles(1,2);
		a1.porNiveles();

	}
}
