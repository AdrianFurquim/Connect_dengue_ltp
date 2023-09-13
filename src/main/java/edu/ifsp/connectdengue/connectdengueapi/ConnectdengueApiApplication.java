package edu.ifsp.connectdengue.connectdengueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectdengueApiApplication {

	public static void main(String[] args) {
		DatabaseRelato.init();
		SpringApplication.run(ConnectdengueApiApplication.class, args);
	}

}
