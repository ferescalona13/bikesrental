package com.escalona.bikesrental.model;

public class Client {
	
	private String nroDoc;
	private String name;
	
	public Client(String nroDoc, String name) {
		super();
		this.setNroDoc(nroDoc);
		this.name = name;
	}	

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
