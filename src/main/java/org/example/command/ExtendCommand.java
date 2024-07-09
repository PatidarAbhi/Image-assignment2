package org.example.command;

import org.example.Adapter.AIService;

public class ExtendCommand implements Command {
    private final String imageName;
    private final String direction;
    private final int pixels;
    private final AIService aiService;

    public ExtendCommand(String imageName, String direction, int pixels, AIService aiService) {
        this.imageName = imageName;
        this.direction = direction;
        this.pixels = pixels;
        this.aiService = aiService;
    }

    @Override
    public void execute() {
        aiService.extendImage(imageName, direction, pixels);
    }
}
