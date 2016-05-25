package by.training.task3.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.training.task3.entity.Dishes;
import by.training.task3.entity.DishesTagName;
import by.training.task3.entity.Food;

public class StAXParserService implements IParser {

 	private List<Dishes> listDishes;
 	private Dishes dishes;
 	private Food food;
	private DishesTagName dtn;
 	public StAXParserService()
 	{
 		dishes = new Dishes();
 		food = new Food();
 		listDishes = new ArrayList<Dishes>();
 	}
	@Override
	public  void parse(String xmlPath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            InputStream input  = new FileInputStream(xmlPath);
            XMLStreamReader reader = factory.createXMLStreamReader(input);
            listDishes = process(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	private  List<Dishes> process(XMLStreamReader reader) throws XMLStreamException
	{
		while(reader.hasNext())
		{
			int type = reader.next();
			switch(type)
			{

			case XMLStreamConstants.START_ELEMENT:
			{
				dtn = DishesTagName.getElementTagName(reader.getLocalName());
				startElement(reader);
			}break;
			case XMLStreamConstants.CHARACTERS:
			{
				String text = reader.getText().trim();
				if(text.isEmpty())
				{
					break;
				}
				characters(text);
			}break;
			case XMLStreamConstants.END_ELEMENT:
			{
				dtn = DishesTagName.getElementTagName(reader.getLocalName());
				endElement();
			}break;
			}
		}
		return listDishes;
	}
	
	private void startElement(XMLStreamReader reader)
	{
		switch(dtn)
		{
			case LIST_DISHES:
			{
			     dishes = new Dishes();
	             dishes.setId(reader.getAttributeValue(null,"id"));
	             dishes.setNameListDishes(reader.getAttributeValue(null,"nameListDishes"));
	             listDishes.add(dishes);
			}break;
			case FOOD:
			{
				food = new Food();
				food.setId(reader.getAttributeValue(null,"id"));
			}break;
		default:
			break;
		}
	}
	
	private void characters(String text)
	{
			switch (dtn) {
	        case PRICE:
	            food.setPrice(Integer.parseInt(text));
	            break;
	        case PORTION:
	            food.setPortion(text);
	            break;
	        case DESCRIPTION:
	            food.setDescription(text);
	            break;
	        case NAME:
	            food.setName(text);
	            break;
	        default:break;
	    }
	}
	
	private void endElement()
	{
		switch(dtn)
		{
			case LIST_DISHES:
			{
				dishes = null;
			}break;
			case FOOD:
			{
				dishes.addFood(food);
				food = null;
			}break;
			default:break;
		}
	}
	
    public List<Dishes> getDishes() {
        return listDishes;
    }
}
