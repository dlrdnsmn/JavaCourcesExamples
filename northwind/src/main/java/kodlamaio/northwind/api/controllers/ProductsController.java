package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.etities.concretes.Product;
import kodlamaio.northwind.etities.dtos.ProductWithCategoryDto;

@RestController                                  //Sen bir controllersın.
@RequestMapping("api/products")                  //requestler ne nedir ?böyle bir site uzantısı ise bu controller karar verecek.
public class ProductsController {

	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")                       //kodlamaio/api/products/getall diye istekte bulunursam bu çalışacak demek bu.         
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
		}
	
	
	
	//getByProductName için
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){          //istekten parametreyi oku productnamei dönder bize
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public 	DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory(productName,categoryId);
	}
	
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories){
		return this.productService.getByCategoryIn(categories);
	}
	
	@GetMapping("/getByProductNameContains")
	public 	DataResult<List<Product>>  getByProductNameContains(@RequestParam String productName)  {                 // like içermek{
		return this.productService.getByProductNameContains(productName);
	}
	
	//sayfalama
	@GetMapping("/getAllPages")
	public 	DataResult<List<Product>>  getAll(@RequestParam int pageNo,int pageSize)  {                 // like içermek{
		return this.productService.getAll(pageNo,pageSize);
	}
	
	//sortlama
	@GetMapping("/getAllSortedAsc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	
	//DTO örnek
	@GetMapping("/getProductWithCategoryDetails")                      
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	}
