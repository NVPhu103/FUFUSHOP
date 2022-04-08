package fufushop.Service;

import java.util.List;

import fufushop.Model.BrandModel;

public interface IBrandService {
	List<BrandModel> getAllBrandStatus1(); // Lấy brand có status = 1 ( đang hoạt động)
}
