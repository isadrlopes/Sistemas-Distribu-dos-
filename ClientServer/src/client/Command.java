package client;

import java.io.Serializable;

public class Command implements Serializable {
	
	private static final long serialVersionUID = 1;
	public int key;
	public String value;
	public int ncommand;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getNcommand() {
		return ncommand;
	}
	public void setNcommand(int ncommand) {
		this.ncommand = ncommand;
	}
	public Command(int ncommand, int key, String value ) {
		this.key = key;
		this.value = value;
		this.ncommand = ncommand;
		
	}
}
