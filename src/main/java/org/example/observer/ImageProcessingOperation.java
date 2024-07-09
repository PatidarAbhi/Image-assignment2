package org.example.observer;

import org.example.decorator.ImageOperation;

import java.util.ArrayList;
import java.util.List;

public class ImageProcessingOperation implements OperationSubject {
    private List<OperationObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(OperationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OperationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String operation, String status) {
        for (OperationObserver observer : observers) {
            observer.update(operation, status);
        }
    }

    public void executeOperation(ImageOperation operation) {
        operation.performOperation();
        notifyObservers("Operation", "Completed");
    }
}
