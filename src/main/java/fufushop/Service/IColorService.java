package fufushop.Service;


import java.util.List;

import fufushop.Model.ColorModel;

public interface IColorService {
	List<ColorModel> getAllColor(int productID);
	
	ColorModel getColor(String colorName, int productID);
	
	boolean checkNameExist(String name, int productID);
	
	void insertColor(ColorModel color);
	
	void deleteColor(String name, int productID);
	
	void addOldColor(ColorModel color);	// Add extra quantity to old Color
	
	boolean decreaseColor(ColorModel color);	// true == success || false == failure
}
