package ua.lviv.javavclub.clients.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ua.lviv.javavclub.clients.model.ApplianceData;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RandomDataClient {

    private final RestClient restClient;


    public ApplianceData randomAppliance() {
        return restClient.get()
                .uri("/appliances")
                .retrieve()
                .body(ApplianceData.class);
    }
}
