package org.glsid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource(locations = {"classpath:/spring-beans.xml"})
//@ImportResource("spring-beans.xml")
public class GestBanqueSpringBootJpaHibernateRestfulSoapRmiAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestBanqueSpringBootJpaHibernateRestfulSoapRmiAngularApplication.class, args);

	}

}
