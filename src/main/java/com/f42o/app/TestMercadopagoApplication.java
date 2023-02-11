package com.f42o.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.mercadopago.MercadoPagoConfig;

@SpringBootApplication
public class TestMercadopagoApplication {
	public static void main(String[] args) {

		SpringApplication.run(TestMercadopagoApplication.class, args);
		
	}
	

} 
