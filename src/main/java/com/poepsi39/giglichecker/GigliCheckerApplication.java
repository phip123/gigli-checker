package com.poepsi39.giglichecker;

import com.poepsi39.giglichecker.model.GigliStatus;
import com.poepsi39.giglichecker.model.User;
import com.poepsi39.giglichecker.repository.GigliRepository;
import com.poepsi39.giglichecker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class GigliCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GigliCheckerApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, GigliRepository gigliRepository) {
        return args -> {
            if (!userRepository.findUserByNameContainingIgnoreCase("fillipp").isPresent()) {
                userRepository.save(User.UserBuilder.anUser().name("fillipp").seen(false).build());
            }

            if (gigliRepository.count() == 0) {
                gigliRepository.save(GigliStatus.GigliStatusBuilder.aGigliStatus().status(false).build());
            }
        };
    }

}
