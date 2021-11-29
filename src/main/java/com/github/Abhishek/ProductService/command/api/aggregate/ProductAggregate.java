package com.github.Abhishek.ProductService.command.api.aggregate;


import com.github.Abhishek.ProductService.command.api.commands.AddProductCommand;
import com.github.Abhishek.ProductService.command.api.events.ProductAddedEvents;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;

    //Constructor
    @CommandHandler
    public ProductAggregate(AddProductCommand addProductCommand) {
        //perform all validation operation
        ProductAddedEvents productaddedEvents = new ProductAddedEvents();
        //Instead of going with Builder approach make use of BeanUtils
        BeanUtils.copyProperties(addProductCommand,productaddedEvents);

        AggregateLifecycle.apply(productaddedEvents);
    }

    public ProductAggregate() {
    }

    //Create EventSourcing Handler To Update the State of The Aggregate whenever new scenerio/command comes in
    @EventSourcingHandler
    public void on(ProductAddedEvents productAddedEvents){
        this.productId = productAddedEvents.getProductId();
        this.productName = productAddedEvents.getProductName();
        this.productPrice = productAddedEvents.getProductPrice();
        this.productQuantity = productAddedEvents.getProductQuantity();
    }
}
