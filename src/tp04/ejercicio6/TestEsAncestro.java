package tp04.ejercicio6;

import tp04.ejercicio1.ArbolGeneral;

public class TestEsAncestro {
	public static void main(String[] args) {
		ArbolGeneral<Integer> a1= new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a2= new ArbolGeneral<Integer>(15);
		a1.agregarHijo(a2);
		ArbolGeneral<Integer> a3= new ArbolGeneral<Integer>(3);
		a1.agregarHijo(a3);
		ArbolGeneral<Integer> a4= new ArbolGeneral<Integer>(20);
		a1.agregarHijo(a4);
		ArbolGeneral<Integer> a5= new ArbolGeneral<Integer>(6);
		a3.agregarHijo(a5);
		ArbolGeneral<Integer> a6= new ArbolGeneral<Integer>(7);
		a5.agregarHijo(a6);
		
		System.out.println(a1.esAncestro2(3,7));
	}
}
