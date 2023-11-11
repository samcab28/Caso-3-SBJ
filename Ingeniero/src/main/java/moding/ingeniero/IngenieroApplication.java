package moding.ingeniero;


import moding.ingeniero.models.User;
import moding.ingeniero.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IngenieroApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public IngenieroApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(IngenieroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User newUser = new User("ben", "Farz");
            userRepository.save(newUser);
            System.out.println("New user saved: " + newUser);
        }


        User newUser = new User("ben", "Farz");
        userRepository.save(newUser);
        System.out.println("New user saved: " + newUser);
        System.out.println("All users in the database:");
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
    }

}
