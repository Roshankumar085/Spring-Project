package com.way2learnonline.service;

import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	public void sendMail(String toAddress, String fromAddress, String content) {
		System.out.println("Mail Sent");

	}

}
