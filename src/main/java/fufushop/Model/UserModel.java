package fufushop.Model;

import java.sql.Date;

public class UserModel {
	public int id;
	public String lastName;
	public String firstName;
	public String userName;
	public String password;
	public Date birthdate;
	public String gender;
	public String phone;
	public String email;
	public String address;
	public String image;
	public int roleID;
	
	
	
	@Override
	public String toString() {
		return "UserDAO [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", userName=" + userName
				+ ", password=" + password + ", birthdate=" + birthdate + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", image=" + image + ", roleID=" + roleID + "]";
	}


	public UserModel() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public UserModel(int id, String lastName, String firstName, String userName, String password, Date birthdate,
			String gender, String phone, String email, String address, String image, int roleID) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.image = image;
		this.roleID = roleID;
	}
	
	public UserModel(String lastName, String firstName, String userName, String password,
			String phone) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}
	
	
}
