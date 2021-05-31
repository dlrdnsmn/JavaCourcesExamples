package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.etities.concretes.Product;
import kodlamaio.northwind.etities.dtos.ProductWithCategoryDto;

//interface interfacesi extend eder.
//JpaRepository crud,findAll ile filtreleme sıralama,sayfalama yapabiliyoruz.

public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);   
	                                              // JpaRepository name i görünce tabloya gidip where koşulu ekliyor
													// getbu findby ile başlamalıyız ama yani isimlendirme standardına
													// uymalıyız

	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);       // AND yazımı

	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);  // OR yazımı

	List<Product> getByCategoryIn(List<Integer> category);                       // IN yazımı

	List<Product> getByProductNameContains(String productName);                      // like içermek

	List<Product> getByProductNameStartsWith(String productName);                        // bununla başlayan

	// JPQL(Sorguyu yazdığımız zaman objeler üzerinden yapma.)
    //select*from products where product_name=bisey and category_id=bisey
	//Veritabanını unut tablo bu classmız gibi davranırız query yazarken
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	List<Product> GetByNameAndCategory(String productName, int categoryId);
	
	//Select p.product_id,p.product_name,c.category_name from category c inner join product p on c.category_id=p.category_id
	
	@Query("Select new kodlamaio.northwind.etities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) "
			+ "From Category c Inner Join c.products p")                                           //on koşuluna gerek yok
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
}
