package org.atomiv.template.core.application.commands.products;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class UnlistProductCommand implements Command<UnlistProductCommandResponse> {
	@Getter
	@Setter
	private UUID id;
}
