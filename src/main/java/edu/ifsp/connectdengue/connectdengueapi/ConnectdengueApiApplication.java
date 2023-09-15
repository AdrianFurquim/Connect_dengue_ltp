package edu.ifsp.connectdengue.connectdengueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectdengueApiApplication {

	public static void main(String[] args) {
		DatabaseRelato.init();
		DatabaseDenuncia.init();
		DatabaseSintomas.init();
		DatabaseDengueShow.init();
		SpringApplication.run(ConnectdengueApiApplication.class, args);
	}
}