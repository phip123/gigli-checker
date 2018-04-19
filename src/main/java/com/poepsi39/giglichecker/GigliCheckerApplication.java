package com.poepsi39.giglichecker;

import com.poepsi39.giglichecker.model.User;
import com.poepsi39.giglichecker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GigliCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GigliCheckerApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            if (!userRepository.findUserByNameContainingIgnoreCase("fillipp").isPresent()) {
                userRepository.save(User.UserBuilder.anUser().name("fillipp").seen(false).build());
            }
        };
    }

}
