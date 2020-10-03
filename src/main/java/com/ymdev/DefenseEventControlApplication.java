package com.ymdev;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ymdev.service.IFileStorageService;


@SpringBootApplication
public class DefenseEventControlApplication implements CommandLineRunner{
	
	@Resource
	  IFileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(DefenseEventControlApplication.class, args);
	}
	
	 @Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }

	

}
