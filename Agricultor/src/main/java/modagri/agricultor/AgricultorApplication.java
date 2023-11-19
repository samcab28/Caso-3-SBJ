package modagri.agricultor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class AgricultorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AgricultorApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}