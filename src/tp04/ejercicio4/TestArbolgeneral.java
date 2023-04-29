package tp04.ejercicio4;

import tp04.ejercicio1.ArbolGeneral;

public class TestArbolgeneral {
	public static void main(String[] args) {
		ArbolGeneral<Integer> a1= new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a2= new ArbolGeneral<Integer>(2);
		a1.agregarHijo(a2);
		ArbolGeneral<Integer> a3= new ArbolGeneral<Integer>(3);
		a1.agregarHijo(a3);
		ArbolGeneral<Integer> a4= new ArbolGeneral<Integer>(4);
		a1.agregarHijo(a4);
		ArbolGeneral<Integer> a5= new ArbolGeneral<Integer>(5);
		a4.agregarHijo(a5);
		ArbolGeneral<Integer> a6= new ArbolGeneral<Integer>(6);
		a3.agregarHijo(a6);
		ArbolGeneral<Integer> a7= new ArbolGeneral<Integer>(7);
		a6.agregarHijo(a7);
		
		System.out.println("Altura: ");
		System.out.println(a1.altura());
		System.out.println("Nivel ");
		System.out.println(a1.nivel(6));
		System.out.println("Ancho: ");
		System.out.println(a1.ancho());
		
	}
}
