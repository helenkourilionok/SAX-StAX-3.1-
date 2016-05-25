package by.training.task3.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.training.task3.entity.Dishes;
import by.training.task3.handler.SAXHandler;


public class SAXParserService implements IParser {

	private List<Dishes> listDishes;
	public SAXParserService()
	{
		listDishes = new ArrayList<Dishes>();
	}
	@Override
	public void parse(String xmlPath) {
		// TODO Auto-generated method stub
		 try {
	            XMLReader x = XMLReaderFactory.createXMLReader();
	            SAXHandler s = new SAXHandler();
	            x.setContentHandler(s);
	            x.parse(new InputSource(xmlPath));
	            listDishes = s.getDishes();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	public List<Dishes> getDishes()
	{
		return listDishes;
	}
}
