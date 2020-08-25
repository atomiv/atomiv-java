package org.atomiv.framework.infrastructure.jpa;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Record<TId> {
	
	@Id
	private TId id;
	
	public Record() {
		
	}
	
	public Record(TId id) {
		this.id = id;
	}
	
	public TId getId() {
		return id;
	}
	
	public void setId(TId id) {
		this.id = id;
	}
}
