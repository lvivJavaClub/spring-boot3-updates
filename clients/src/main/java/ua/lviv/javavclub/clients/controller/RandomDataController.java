package ua.lviv.javavclub.clients.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.javavclub.clients.model.ApplianceData;
import ua.lviv.javavclub.clients.model.User;
import ua.lviv.javavclub.clients.repository.UserRepository;
import ua.lviv.javavclub.clients.service.RandomDataClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/random")
public class RandomDataController {

    private final RandomDataClient randomDataClient;

    @GetMapping("/appliance")
    public ResponseEntity<ApplianceData> randomAppliance(){
        var appliance = randomDataClient.randomAppliance();
        return ResponseEntity.ok(appliance);
    }
}
