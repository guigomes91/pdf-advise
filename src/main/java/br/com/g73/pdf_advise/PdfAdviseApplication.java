package br.com.g73.pdf_advise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfAdviseApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/g7e");
		SpringApplication.run(PdfAdviseApplication.class, args);
	}

}
