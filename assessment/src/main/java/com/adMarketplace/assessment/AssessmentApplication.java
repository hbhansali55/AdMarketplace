package com.adMarketplace.assessment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adMarketplace.service.Connections;

@SpringBootApplication
public class AssessmentApplication {
	
	//read filepath from application properties
	@Value("${adMarketplace.assessment.filepath}")
    private String filepath;

    private static String FILEPATH_STATIC;

    @Value("${adMarketplace.assessment.filepath}")
    public void setFilepathStatic(String filepath){
    	AssessmentApplication.FILEPATH_STATIC = filepath;
    }
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(AssessmentApplication.class, args);
		
		boolean test1 = Connections.getConnection("seattle", "Chicago", FILEPATH_STATIC);
		if(test1) 
			System.out.println("Connected");
		else
			System.out.println("Not Connected");
		
		
		
		
		boolean test2 = Connections.getConnection("charlotte", "charlotte", FILEPATH_STATIC);
		if(test2) 
			System.out.println("Connected");
		else 
			System.out.println("Not Connected");
	
	}

}
