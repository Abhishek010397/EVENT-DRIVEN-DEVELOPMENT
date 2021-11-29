package com.github.Abhishek.ProductService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddedEvents {

    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
