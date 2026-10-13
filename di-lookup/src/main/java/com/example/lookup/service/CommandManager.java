package com.example.lookup.service;

import org.springframework.beans.factory.annotation.Lookup;

import org.springframework.stereotype.Component;
@Component
public abstract class CommandManager {
	public void process() {
        PrototypeCommand command = createCommand();   // lookup!
        command.execute();
    }
	
	  @Lookup
	    protected abstract PrototypeCommand createCommand();
}
