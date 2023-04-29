package tp04.ejercicio5;

public class AreaEmpresa {
	private String area;
	private int transmision;
	
	public AreaEmpresa(String a,int t) {
		area = a;
		transmision = t;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getTransmision() {
		return transmision;
	}

	public void setTransmision(int transmision) {
		this.transmision = transmision;
	}
	
}
