package org.example.command;

import org.example.Adapter.BackgroundRemovalService;

public class RemoveBackgroundCommand implements Command {
    private final String imageName;
    private final BackgroundRemovalService backgroundRemovalService;

    public RemoveBackgroundCommand(String imageName, BackgroundRemovalService backgroundRemovalService) {
        this.imageName = imageName;
        this.backgroundRemovalService = backgroundRemovalService;
    }

    @Override
    public void execute() {
        backgroundRemovalService.removeBackground(imageName);
    }
}
