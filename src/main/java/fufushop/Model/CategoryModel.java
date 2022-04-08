package fufushop.Model;

public class CategoryModel {
	public int id;
	public String name;
	public int status;	// 1: HOẠT ĐỘNG || 2: NGỪNG HOẠT ĐỘNG
	
	public CategoryModel(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public CategoryModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
}
