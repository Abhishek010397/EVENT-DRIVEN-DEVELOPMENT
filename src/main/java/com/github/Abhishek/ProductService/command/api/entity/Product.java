package com.github.Abhishek.ProductService.command.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="PRODUCT")
public class Product  {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
