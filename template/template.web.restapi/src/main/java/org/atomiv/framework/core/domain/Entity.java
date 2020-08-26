package org.atomiv.framework.core.domain;

public class Entity<TIdentity> {
	
	private TIdentity id;
	
	public Entity(TIdentity id) {
		
		if(id == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		
		this.id = id;
	}
	
	public TIdentity getId() {
		return id;
	}
	
}
