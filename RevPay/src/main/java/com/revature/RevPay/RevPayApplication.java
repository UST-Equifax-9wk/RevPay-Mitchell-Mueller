package com.revature.RevPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.revature.RevPay.entities.*;
import com.revature.RevPay.services.*;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.revature.RevPay.controllers",
"com.revature.RevPay.repositories",
"com.revature.RevPay.services"})
public class RevPayApplication {

	public static void main(String[] args) {
		ApplicationContext iocContainer = SpringApplication.run(RevPayApplication.class, args);
		System.out.println("Hello");
//		PersonalUser user = new PersonalUser("mmueller", "password", "mmueller@gmail.com");
//		PersonalUserService service = iocContainer.getBean(PersonalUserService.class);
//		service.saveOrUpdate(user);
	}

}
