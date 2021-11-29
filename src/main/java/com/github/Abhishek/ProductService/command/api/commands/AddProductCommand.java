package com.github.Abhishek.ProductService.command.api.commands;


import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class AddProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
