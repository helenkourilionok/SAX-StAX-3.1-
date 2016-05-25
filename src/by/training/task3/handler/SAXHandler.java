package by.training.task3.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

import by.training.task3.entity.*;

public class SAXHandler extends DefaultHandler {
	private List<Dishes> listDishes = new ArrayList<Dishes>();
	private Dishes dishes;
	private Food food;
	private StringBuilder text; 
	public void startDocument()
	{
		System.out.println("Parsing started.");
	}
	public void endDocument()
	{
		System.out.println("Parsing ended.");
	}
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	text = new StringBuilder();
    	DishesTagName dtn = DishesTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (dtn) {
            case LIST_DISHES:
                dishes = new Dishes();
                dishes.setId(attributes.getValue("id"));
                dishes.setNameListDishes(attributes.getValue("nameListDishes"));
            	listDishes.add(dishes);
                break;
            case FOOD:
                food = new Food(); 
                food.setId(attributes.getValue("id"));
                break;
            default:break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      text.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	DishesTagName dtn = DishesTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (dtn) {
            case PRICE:
                food.setPrice(Integer.parseInt(text.toString()));
                break;
            case PORTION:
                food.setPortion(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case NAME:
                food.setName(text.toString());
                break;
            case FOOD:
                dishes.addFood(food);
                food = null;
                break;
            case LIST_DISHES:
            	dishes = null;
                break;
            default:break;
        }

    }
    
    public List<Dishes> getDishes() {
        return listDishes;
    }
}
