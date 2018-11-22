package ensa.messagerie.model;

import java.io.Serializable;

public class Message implements Serializable {
private String sender;
	

	private String texte;
	

	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Message(String sender, String texte) {
		super();
		this.sender = sender;
		
		this.texte = texte;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
