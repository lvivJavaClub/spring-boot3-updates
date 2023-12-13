package ua.com.lvivjavavclub.crac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckpointsController {

    @GetMapping("checkpoint")
    public String checkpoint(){
        return "Hello from CRaC application";
    }
}
