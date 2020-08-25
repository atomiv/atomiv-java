package org.atomiv.framework.core.domain;

import java.util.UUID;

public class GuidIdentity extends Identity<UUID> {

	private static UUID DEFAULT_VALUE = new UUID(0L, 0L);
	
	public GuidIdentity(UUID value) {
		super(value, DEFAULT_VALUE);
	}

}
