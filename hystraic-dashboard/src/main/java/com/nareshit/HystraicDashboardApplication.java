package com.nareshit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystraicDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystraicDashboardApplication.class, args);
	}
}
