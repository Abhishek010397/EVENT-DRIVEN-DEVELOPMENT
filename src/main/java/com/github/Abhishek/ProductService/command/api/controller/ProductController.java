package com.github.Abhishek.ProductService.command.api.controller;


import com.github.Abhishek.ProductService.command.api.commands.AddProductCommand;
import com.github.Abhishek.ProductService.command.api.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private CommandGateway commandGateway;


    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductModel productModel){

        AddProductCommand addProductCommand = AddProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .productName(productModel.getProductName())
                .productPrice(productModel.getProductPrice())
                .productQuantity(productModel.getProductQuantity())
                .build();
        String result =commandGateway.sendAndWait(addProductCommand);
        System.out.println("Result is"+result);

        return result;
    }
}
