package com.example.University2;

import com.example.University2.db.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class University2Application implements CommandLineRunner {
	private static Logger LOG = LoggerFactory
			.getLogger(University2Application.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(University2Application.class, args);
		Menu menu=new Menu();
		menu.menuItem();
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}

}
