import java.util.List;

import by.training.task3.entity.Dishes;
import by.training.task3.entity.KindParser;
import by.training.task3.factory.ParserFactory;
import by.training.task3.service.SAXParserService;
import by.training.task3.service.StAXParserService;

public class SAX_StAX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Dishes> dishes;
		KindParser kind = KindParser.StAX;
		StAXParserService stax = (StAXParserService)ParserFactory.getParser(kind);
		stax.parse("D:\\menu.xml");
		dishes = stax.getDishes();
		System.out.println("StAX");
		for(Dishes d1:dishes)
		{
			System.out.println(d1.toString());
		}
		kind = KindParser.SAX;
		SAXParserService sax = (SAXParserService)ParserFactory.getParser(kind);
		sax.parse("D:\\menu.xml");
		dishes = sax.getDishes();
		System.out.println("SAX");
		for(Dishes d1:dishes)
		{
			System.out.println(d1.toString());
		}
	}

}
