package moding.ingeniero;

import moding.ingeniero.modelo.*;
import moding.ingeniero.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class IngenieroApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }

}
