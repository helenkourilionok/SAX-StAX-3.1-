package by.training.task3.entity;

public class Food {
	private String id;
	private String name;
	private String description;
	private String portion;
	private int price;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Food(String id, String name, String description, String portion, int price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.portion = portion;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPortion() {
		return portion;
	}
	public void setPortion(String portion) {
		this.portion = portion;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
