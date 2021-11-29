package com.github.Abhishek.ProductService.command.api.events;
import com.github.Abhishek.ProductService.command.api.entity.Product;
import com.github.Abhishek.ProductService.command.api.entity.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class ProductEventHandler {


    @Autowired
    @Lazy
    private ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductAddedEvents productAddedEvents){
        Product product = new Product();

        BeanUtils.copyProperties(productAddedEvents,product);
        productRepository.save(product);
    }
    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
