package org.example.decorator;
public class BaseImageOperation implements ImageOperation {
    private String image;

    public BaseImageOperation(String image) {
        this.image = image;
    }

    @Override
    public void performOperation() {
    }
}