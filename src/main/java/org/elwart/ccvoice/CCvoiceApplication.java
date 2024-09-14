package org.elwart.ccvoice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.elwart.ccvoice.Com.Chat.Mapper")
public class CCvoiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CCvoiceApplication.class, args);
	}

}
