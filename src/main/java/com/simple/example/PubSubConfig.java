package com.simple.example;

import com.simple.example.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class PubSubConfig {
    @Bean("input")
    public Consumer<Product> input() {
        return product -> System.out.println("Received: " + product);
    }

    @Bean("output")
    public Supplier<String> output() {
        return ()-> "This is a test: ";
    }

    @Bean("processor")
    public Function<Product, Product> calculatePrice() {
        return product -> {
            product.setPrice(product.getPrice() - 2);
            System.out.println("Processor: " + product);
            return product;
        };
    }
}
