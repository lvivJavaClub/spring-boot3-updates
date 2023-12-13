package ua.com.lvivjavavclub.ssl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping
    public ResponseEntity<Map<String, String>> greetings(){
        return ResponseEntity.ok(Map.of("msg","Hello, dear community"));
    }

    @GetMapping("/secured")
    public ResponseEntity<Map<String, String>> greetings(Principal principal){
        return ResponseEntity.ok(Map.of("msg","Hello, dear " + principal.getName()));
    }
}
