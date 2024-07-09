package org.example.observer;
public interface OperationSubject {
    void addObserver(OperationObserver observer);
    void removeObserver(OperationObserver observer);
    void notifyObservers(String operation, String status);
}