package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.etities.concretes.Product;
import kodlamaio.northwind.etities.dtos.ProductWithCategoryDto;

@Service                                       //bu class service görevi görecek diye bilgi geçtik.
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired                                 //bean class, Spring ProductDao ya karşılık gelecek sınıf bulur(productdao ya karşılık) ve verir.
	public ProductManager(ProductDao productDao) {
		super(); 
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		           (this.productDao.findAll(),"Data listelendi");
		
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult(true,"Ürün eklendi");
	}
	
	


	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>
        (this.productDao.getByProductName(productName),"Ürün adı listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>
        (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Product adı ve category listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>
        (this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Product adı veya category listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>
        (this.productDao.getByProductNameContains(productName),"Product adı veya category like listelendi");
	}

	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>
        (this.productDao.GetByNameAndCategory(productName,categoryId),"Adı ve category şu olanlar listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
        (this.productDao.getByCategoryIn(categories),"Product adı veya category listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStarts(String productName) {
		return new SuccessDataResult<List<Product>>
        (this.productDao.getByProductNameStartsWith(productName),"Product adı veya category listelendi");
	}
	
	//Sayfalama
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable =PageRequest.of(pageNo-1,pageSize);
		
		return new SuccessDataResult<List<Product>>
				(this.productDao.findAll(pageable).getContent());
	}

	//sıralama ASC yaptık
	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC,"productName");//sıralama yapacağı parametreyi vermeliyiz.
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Başarılı sortlandı");
}

	
	//DTO
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(
				this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
	}

}
