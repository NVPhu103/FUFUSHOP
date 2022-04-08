package fufushop.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import fufushop.DAO.ICategoryDAO;
import fufushop.DAO.Implement.CategoryDAOImplement;
import fufushop.Model.CategoryModel;
import fufushop.Service.ICategoryService;

public class CategoryServiceImplement implements ICategoryService{
	ICategoryDAO categoryDAO = new CategoryDAOImplement();
	@Override
	public List<CategoryModel> getAllCategoryStatus1() {
		List<CategoryModel> listCate = categoryDAO.getAllCategory();
		List<CategoryModel> listCateStatus1 = new ArrayList<CategoryModel>();
		for(int i = 0; i < listCate.size(); i++) {
			if(listCate.get(i).getStatus() == 1) {
				listCateStatus1.add(listCate.get(i));
			}
		}
		return listCateStatus1;
	}

}
