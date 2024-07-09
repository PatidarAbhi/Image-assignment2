package org.example.command;
public class ResizeCommand implements Command {
    private String image;
    private int width;
    private int height;

    public ResizeCommand(String image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        System.out.println("Resizing image " + image + " to width " + width + " and height " + height);
    }
}