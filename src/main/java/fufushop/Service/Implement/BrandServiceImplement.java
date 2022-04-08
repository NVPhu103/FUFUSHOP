package fufushop.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import fufushop.DAO.IBrandDAO;
import fufushop.DAO.Implement.BrandDAOImplement;
import fufushop.Model.BrandModel;
import fufushop.Service.IBrandService;

public class BrandServiceImplement implements IBrandService{
	IBrandDAO brandDAO = new BrandDAOImplement();
	@Override
	public List<BrandModel> getAllBrandStatus1() {
		List<BrandModel> listBrand = brandDAO.getAllBrand();
		List<BrandModel> listBrandStatus1 = new ArrayList<BrandModel>();
		for(int i = 0; i < listBrand.size(); i++) {
			if(listBrand.get(i).getStatus() == 1) {
				listBrandStatus1.add(listBrand.get(i));
			}
		}
		return listBrandStatus1;
	}

}
