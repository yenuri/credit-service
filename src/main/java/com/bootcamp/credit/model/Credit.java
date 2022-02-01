package com.bootcamp.credit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "credit")
public class Credit {

    private String id;
    private CreditType creditType;
    private Customer customer;
    private String numberCard;
    private Double creditLimit;
    private Double balance;
    private Date paymentDate;
    private Date cutoffDate;
    private Date paymentDeadline;
    private Long numQuotas;
    private String status;
}
