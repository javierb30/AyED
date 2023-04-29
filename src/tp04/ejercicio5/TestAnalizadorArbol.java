package tp04.ejercicio5;

import tp04.ejercicio1.ArbolGeneral;
import tp04.ejercicio5.*;

public class TestAnalizadorArbol {
	public static void main(String[] args) {
		ArbolGeneral<AreaEmpresa> a1= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("a",9));
		ArbolGeneral<AreaEmpresa> a2= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("b",15));
		a1.agregarHijo(a2);
		ArbolGeneral<AreaEmpresa> a3= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("c",3));
		a1.agregarHijo(a3);
		ArbolGeneral<AreaEmpresa> a4= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("d",20));
		a1.agregarHijo(a4);
		ArbolGeneral<AreaEmpresa> a5= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("e",5));
		a4.agregarHijo(a5);
		ArbolGeneral<AreaEmpresa> a6= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("f",6));
		a3.agregarHijo(a6);
		ArbolGeneral<AreaEmpresa> a7= new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("g",7));
		a6.agregarHijo(a7);
		
		
		AnalizadorArbol aa1 = new AnalizadorArbol();
		System.out.println(aa1.devolverMaximoPromedio(a1));
	}
}
