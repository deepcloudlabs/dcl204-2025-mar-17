package com.example.lottery.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var lotteryService = new StandardLotteryService();
		var services = ServiceLoader.load(RandomNumberService.class);
		var properties = new Properties();
		properties.load(new FileInputStream(new File("src","application.properties")));
		var qualityLevel = QualityLevel.valueOf(properties.getProperty("quality.level"));
		for (var service: services) {
			var clazz = service.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
				if (serviceQuality.value().equals(qualityLevel)) {
					lotteryService.setRandomNumberService(service);
					break;
				}
			}
		}
		lotteryService.draw(60, 6, true)
		              .forEach(System.out::println);
	}

}
