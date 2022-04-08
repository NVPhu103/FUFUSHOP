package fufushop.DAO;


import java.util.List;

import fufushop.Model.ColorModel;

public interface IColorDAO {

	List<ColorModel> getAllColor(int productID);

	ColorModel getColor(String name, int productID);
	
	void insertColor(ColorModel color);

	void deleteColor(String name, int productID);
	
	void editColor(ColorModel color);
}
