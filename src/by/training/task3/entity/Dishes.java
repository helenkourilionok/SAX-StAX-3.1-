package by.training.task3.entity;

import java.util.ArrayList;
import java.util.List;

public class Dishes {
	private String id;
	private String nameListDishes;
	private List<Food> listFood;
	public Dishes() {
		super();
		listFood = new ArrayList<Food>();
		// TODO Auto-generated constructor stub
	}
	public Dishes(String id, String nameListDishes, List<Food> listFood) {
		super();
		this.id = id;
		this.nameListDishes = nameListDishes;
		this.listFood = listFood;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameListDishes() {
		return nameListDishes;
	}
	public void setNameListDishes(String nameListDishes) {
		this.nameListDishes = nameListDishes;
	}
	public List<Food> getListFood() {
		return listFood;
	}
	public void setListFood(List<Food> listFood) {
		this.listFood = listFood;
	}
	public void addFood(Food food)
	{
		listFood.add(food);
	}
	public String toString()
	{
		StringBuffer sb =  new StringBuffer("Dishes"+"\n");
		sb.append("Id-"+this.id+"\n");
		sb.append("NameDishes-"+this.getNameListDishes()+"\n");
		for(Food f:listFood)
		{
			sb.append("---Food---\n");
			sb.append("---id-"+f.getId()+"\n");
			sb.append("---Name-"+f.getName()+"\n");
			sb.append("---Description-"+f.getDescription()+"\n");
			sb.append("---Price-"+f.getPrice()+"\n");
			sb.append("---Portion-"+f.getPortion()+"\n");
			sb.append("---Food---\n");
		}
		return sb.toString();
	}
}
