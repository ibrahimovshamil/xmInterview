package com.xm.xmInterview;

import com.xm.xmInterview.helper.csv.impl.MultipleCSVFileCryptoReader;
import com.xm.xmInterview.service.impl.CryptoCalculatorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootApplication
public class XmInterviewApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(XmInterviewApplication.class, args);

//		CryptoCalculator cryptoCalculator = new CryptoCalculatorImpl(new CSVCryptoReader("XRP_values.csv"));
//
//		System.out.println("----");
//		cryptoCalculator.getMax().ifPresent(System.out::println);
//		cryptoCalculator.getMin().ifPresent(System.out::println);
//		cryptoCalculator.getNewest().ifPresent(System.out::println);
//		cryptoCalculator.getOldest().ifPresent(System.out::println);
//
//		System.out.println("******");
//
//		cryptoCalculator.setCryptoReader(new CSVCryptoReader("BTC_values.csv"));
//
//		System.out.println("----");
//		cryptoCalculator.getMax().ifPresent(System.out::println);
//		cryptoCalculator.getMin().ifPresent(System.out::println);
//		cryptoCalculator.getNewest().ifPresent(System.out::println);
//		cryptoCalculator.getOldest().ifPresent(System.out::println);

//		CryptoService service = new CryptoService();
//		service.readAll();
//		service.getStatsForAll().forEach((k, v) -> System.out.println( k + " : " + v));

//		 System.out.println(LocalDate.ofInstant(Instant.ofEpochMilli(1643374800000L), TimeZone.getDefault().toZoneId()));
	}

}
