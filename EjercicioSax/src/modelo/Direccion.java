package modelo;

import java.io.Serializable;

public class Direccion implements Serializable {
	private String calle;
	private String provinvia;
	
	public Direccion() {
		super();
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getProvinvia() {
		return provinvia;
	}

	public void setProvinvia(String provinvia) {
		this.provinvia = provinvia;
	}
	
	
}
