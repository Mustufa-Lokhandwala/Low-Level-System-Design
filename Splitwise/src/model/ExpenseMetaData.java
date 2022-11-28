package model;

public class ExpenseMetaData {

	private String name;
	private String imageURL;
	private String notes;
	
	public ExpenseMetaData(String name, String imageURL, String notes) {
		this.name = name;
		this.imageURL = imageURL;
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setDescription(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
