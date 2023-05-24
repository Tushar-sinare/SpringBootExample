package com.app.batch.reader;

import java.text.ParseException;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

public class DataReader implements ItemReader<String> {
String []message= {"Hii","Hello","Are you Fine"};
int index=0;

public String read()throws Exception,UnexpectedInputException ,ParseException , NonTransientResourceException{
	if(index<message.length) {
		return message[index++];
	}else
	{
		index=0;
	}
	return null;
}
}
