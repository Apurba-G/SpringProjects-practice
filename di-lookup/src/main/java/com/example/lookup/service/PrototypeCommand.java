package com.example.lookup.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeCommand {
	public PrototypeCommand() {
        System.out.println("PrototypeCommand created: " + this.hashCode());
    }

    public void execute() {
        System.out.println("Command executed by instance: " + this.hashCode());
    }
}
