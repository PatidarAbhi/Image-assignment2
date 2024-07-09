package org.example.observer;

public class OperationLogger implements OperationObserver {
    @Override
    public void update(String operation, String status) {
        System.out.println("Observer: " + operation + " - " + status);
    }
}
