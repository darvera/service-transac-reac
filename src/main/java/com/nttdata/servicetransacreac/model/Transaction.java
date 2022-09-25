package com.nttdata.servicetransacreac.model;

import java.math.BigDecimal;
import java.sql.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "transaction")
public class Transaction {
	 	@Id
	    private String id;

	   // private Date dateMovement;

	    private String type;

	    private BigDecimal amount;

	    private String ProductId;
	    
	    private String ClientId;
	    
	    private int status;
	    
}
