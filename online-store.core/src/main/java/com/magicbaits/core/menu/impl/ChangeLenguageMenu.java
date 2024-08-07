package com.magicbaits.core.menu.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.magicbaits.Main;
import com.magicbaits.core.menu.Menu;


public class ChangeLenguageMenu implements Menu{
	
	private ResourceBundle rb;
	{
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		loop:while(true) {
			printMenuHeader();
			
			System.out.println(rb.getString("lenguage.options"));
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();
			
			if(userInput.equalsIgnoreCase(Main.EXIT_COMMAND)) {
				System.exit(0);
			}else if(userInput.equalsIgnoreCase("menu")) {
				break;
			}else if(!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println(rb.getString("option.not.exist.error.msg"));
				continue;
			}else {
				int commandNumber = Integer.parseInt(userInput);
				
				switch(commandNumber) {
				case 1:
					Locale.setDefault(new Locale("en_US"));
					break loop;
				case 2: 
					Locale.setDefault(new Locale("es_CL"));
					break loop;
				}
				
			}
		}
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(rb.getString("change.lenguage.header"));
		System.out.println(rb.getString("select.or.main"));
		
	}

}
