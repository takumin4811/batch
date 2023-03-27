package com.example.webbatch;

import java.io.IOException;
//import jp.co.nri.tstar.com.lib.logic.SimeSyriKankyoHensuGetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebbatchApplication {	

	// private static final String PROPERTY_FILE_NAME = "application-sime.properties";
	
	public static void main(String[] args) throws IOException {
		// setJVMEnv();
		// Properties properties = new Properties();
		// try (InputStream in = WebbatchApplication.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);) {
		// 	// プロパティファイルロード
		// 	properties.load(in);
		// }
		
		SpringApplication.run(WebbatchApplication.class, args);
	}
}
