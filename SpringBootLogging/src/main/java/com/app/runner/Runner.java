package com.app.runner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Apache log4j
		Logger log = LogManager.getLogger(Runner.class);
		log.info("Console Runner Starter");
		int a = 10, b = 20, c = -1;
		log.info("Data init.. done");

		if (a > 0 && b > 0) {
			c = a + b;
			log.info("if block executed");
		} else {
			c = a - b;
			log.info("else block executed");
		}
		log.debug("Final Result is: " + c);
		if (c > 0)
			try {
				throw new RuntimeException("Hello Sample");
			} catch (Exception e) {
				e.printStackTrace();
				// oa.error("Problem found..." +e);
			}
		// stop server
		System.exit(0);
	}

}
