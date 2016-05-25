package by.training.task3.factory;

import by.training.task3.entity.KindParser;
import by.training.task3.service.IParser;
import by.training.task3.service.SAXParserService;
import by.training.task3.service.StAXParserService;

public class ParserFactory {
	private static SAXParserService sax;
	private static StAXParserService stax;
	private ParserFactory()
	{}
	public static IParser getParser(KindParser parser)
	{
		switch(parser)
		{
			case SAX:
				{
					if(sax==null)
					{
						sax = new SAXParserService();
					}
					return sax;
				}
			case StAX:
				{
					if(stax==null)
					{
						stax = new StAXParserService();
					}
					return stax;
				}
			default:break;
		}
		return null;
	}
}
