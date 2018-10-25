package br.com.solutis.main;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsBlockchainJavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WsBlockchainJavaApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		Application app = new Application();
		app.showWelcomeMsg();
		app.startBlockchain();
		app.printBlockchain();
	}
}
