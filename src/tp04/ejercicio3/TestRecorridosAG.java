package tp04.ejercicio3;
import tp04.ejercicio1.*;

public class TestRecorridosAG {
	public static void main(String[] args) {
		ArbolGeneral<Integer> a1= new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a2= new ArbolGeneral<Integer>(2);
		a1.agregarHijo(a2);
		ArbolGeneral<Integer> a3= new ArbolGeneral<Integer>(3);
		a1.agregarHijo(a3);
		ArbolGeneral<Integer> a4= new ArbolGeneral<Integer>(4);
		a1.agregarHijo(a4);
		ArbolGeneral<Integer> a5= new ArbolGeneral<Integer>(5);
		a2.agregarHijo(a5);
		ArbolGeneral<Integer> a6= new ArbolGeneral<Integer>(6);
		a4.agregarHijo(a6);
		ArbolGeneral<Integer> a7= new ArbolGeneral<Integer>(7);
		a4.agregarHijo(a7);
		
		RecorridosAG r1 = new RecorridosAG();
		System.out.println("PreOrden:");
		System.out.println(r1.numerosImparesMayoresQuePreOrden(a1, 4));
		System.out.println("InOrden:");
		System.out.println(r1.numerosImparesMayoresQueInOrden(a1, 4));
		System.out.println("PostOrden:");
		System.out.println(r1.numerosImparesMayoresQuePostOrden(a1, 4));
		System.out.println("PorNiveles:");
		System.out.println(r1.numerosImparesMayoresQuePorNiveles(a1, 4));
	}
}
