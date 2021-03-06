package com.example.reservationservice;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {


    @Bean
    CommandLineRunner runner (ReservationRepository rr){
        return args -> {
            Arrays.asList("Reservation", "Service").forEach(x -> rr.save(new Reservation(x)));
        rr.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

}
