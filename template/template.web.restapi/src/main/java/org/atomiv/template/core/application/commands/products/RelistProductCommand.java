package org.atomiv.template.core.application.commands.products;

import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

public class RelistProductCommand implements Command<RelistProductCommandResponse>{
	@Getter @Setter private UUID id;
}
