package app.car_rental.config;

import app.car_rental.data.entities.User;
import app.car_rental.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@carrental.com");
            admin.setPassword(passwordEncoder.encode("test"));
            admin.setRoles(new HashSet<>(Set.of("ROLE_ADMIN")));
            userRepository.save(admin);
            System.out.println("[DataInitializer] Utilisateur admin créé (admin / test)");
        }
    }
}
