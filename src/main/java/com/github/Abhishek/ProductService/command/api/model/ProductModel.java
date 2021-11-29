package com.github.Abhishek.ProductService.command.api.model;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Builder
public class ProductModel {

    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
