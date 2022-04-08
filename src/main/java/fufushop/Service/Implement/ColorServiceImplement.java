package fufushop.Service.Implement;

import java.util.List;

import fufushop.DAO.IColorDAO;
import fufushop.DAO.Implement.ColorDAOImplement;
import fufushop.Model.ColorModel;
import fufushop.Service.IColorService;
import fufushop.Service.IProductService;

public class ColorServiceImplement implements IColorService{
	IColorDAO colorDAO = new ColorDAOImplement();
	IProductService productService = new ProductServiceImplement();
	
	@Override
	public List<ColorModel> getAllColor(int productID) {
		return colorDAO.getAllColor(productID);
	}

	@Override
	public boolean checkNameExist(String name, int productID) {
		ColorModel color =  colorDAO.getColor(name, productID);
		if(color == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void insertColor(ColorModel color) {
		colorDAO.insertColor(color);	
	}

	@Override
	public void deleteColor(String name, int productID) {
		colorDAO.deleteColor(name, productID);
	}

	@Override
	public void addOldColor(ColorModel color) {
		ColorModel oldColor = colorDAO.getColor(color.getName(), color.getProductID());
		int newQuantity = oldColor.getQuantity() + color.getQuantity();
		color.setQuantity(newQuantity);
		colorDAO.editColor(color);
	}

	@Override
	public boolean decreaseColor(ColorModel color) {
		ColorModel oldColor = colorDAO.getColor(color.getName(), color.getProductID());
		if(oldColor.quantity >= color.quantity) {
			int newQuantity = oldColor.getQuantity() - color.getQuantity();
			color.setQuantity(newQuantity);
			colorDAO.editColor(color);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public ColorModel getColor(String colorName, int productID) {
		return colorDAO.getColor(colorName, productID);
	}
	
	/*public static void main(String[] args) {
		ColorServiceImplement colorService = new ColorServiceImplement();
		IColorDAO colorDAO = new ColorDAOImplement();
		
	}*/
}
