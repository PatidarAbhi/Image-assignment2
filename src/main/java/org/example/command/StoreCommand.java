package org.example.command;
public class StoreCommand implements Command {
    private String service;
    private String path;
    private String image;

    public StoreCommand(String service, String path, String image, String img) {
        this.service = service;
        this.path = path;
        this.image = image;
    }

    @Override
    public void execute() {
        System.out.println("Storing " + image + " to " + service + " at " + path);
    }
}