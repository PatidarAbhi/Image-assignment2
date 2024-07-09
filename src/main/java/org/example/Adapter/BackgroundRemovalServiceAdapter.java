package org.example.Adapter;

import org.example.service.ThirdPartyBackgroundRemovalService;

public class BackgroundRemovalServiceAdapter implements BackgroundRemovalService {
    private ThirdPartyBackgroundRemovalService service;

    public BackgroundRemovalServiceAdapter(ThirdPartyBackgroundRemovalService service) {
        this.service = service;
    }

    @Override
    public void removeBackground(String image) {
        service.removeBackground(image);
    }
}