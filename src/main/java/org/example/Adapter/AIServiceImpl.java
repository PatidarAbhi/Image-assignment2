package org.example.Adapter;
public class AIServiceImpl implements AIService {
    @Override
    public void extendImage(String image, String direction, int pixels) {
        System.out.println("Extending image " + image + " to the " + direction + " by " + pixels + " pixels using AI service");
    }
}