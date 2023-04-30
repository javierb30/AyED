package tp04.ejercicio5;
import tp02.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	/*
	 * Método iterativo para calcular el nivel con más retardo de envío promedio
	 * Se utiliza un recorrido por niveles
	 * */
	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> aux;
		
		cola.encolar(arbol);
		cola.encolar(null);
		int cant=0;
		int suma = 0;
		int prom = 0;
		int promMax = -1;
		
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				suma += aux.getDato().getTransmision();
				cant++;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
			else {
				prom = suma / cant;
				if(prom > promMax)
					promMax = prom;
				cant = 0; suma = 0;
				if(!cola.esVacia()) 
					cola.encolar(null);
			}
		}	
		return promMax;
	}
	
}