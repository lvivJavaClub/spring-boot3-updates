package ua.com.lvivjavavclub.crac;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CracRestartApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CracRestartApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hello from the CRaC application ");
	}
}
