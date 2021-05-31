package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.etities.concretes.Product;
import kodlamaio.northwind.etities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();
	
	//Sayfalama 100 ürün 10 sayfa da gelsin vb. yapı
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	//Sorted
	DataResult<List<Product>> getAllSorted();

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStarts(String productName);

	DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId);

	//dto
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
