package by.training.task3.entity;

public enum DishesTagName {
	MENU,LIST_DISHES,FOOD,NAME,DESCRIPTION,PORTION,PRICE;
	public static DishesTagName getElementTagName(String element)
	{
		switch(element)
		{
		case "menu":
			return MENU;
		case "list-dishes":
			return LIST_DISHES;
		case "food":
			return FOOD;
		case "price":
			return PRICE;
		case "portion":
			return PORTION;
		case "name":
			return NAME;
		case "description":
		return DESCRIPTION;
			default: 
					throw new EnumConstantNotPresentException(DishesTagName.class,element);
		}
	}
}
