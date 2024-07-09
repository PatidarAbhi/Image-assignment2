package org.example.decorator;


import org.example.command.Command;

public class CommandLoggingDecorator implements ImageOperation {
    private Command command;

    public CommandLoggingDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void performOperation() {
        System.out.println("Performing operation: " + command.getClass().getSimpleName());
        command.execute();
    }
}
