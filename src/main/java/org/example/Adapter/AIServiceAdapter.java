package org.example.Adapter;

import org.example.service.ThirdPartyAIService;

public class AIServiceAdapter implements AIService {
    private ThirdPartyAIService service;

    public AIServiceAdapter(ThirdPartyAIService service) {
        this.service = service;
    }

    @Override
    public void extendImage(String image, String direction, int pixels) {
        service.extendImage(image, direction, pixels);
    }
}