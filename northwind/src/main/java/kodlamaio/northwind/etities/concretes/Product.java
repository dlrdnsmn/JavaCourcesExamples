package kodlamaio.northwind.etities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                                                          //lombok getter setterları otomatik alır outlinede görürüz.
@Entity                                                                        //product bir entitiy 'dir dedik.Yani veritabanı nesnesisin
@Table(name = "products")                                                      //denk geldiği tablo 
@AllArgsConstructor                                                            //PARAMETRELİ CONST LOMBAK
@NoArgsConstructor                                                             //PARAMETRESİZ EKLER
public class Product {
	
	@Id                                                                        //Id söylememiz ve belirtmemiz gerek.İşlemler id üzerinden yürütüldüğü için P.K
	@GeneratedValue (strategy =GenerationType.IDENTITY)                        //id bir bir artacak demiş olduk.id nasıl oluşacak
	@Column(name = "product_id")                                               //hangi alan hangi kolon veririz 
	private int id; 
	
	//@Column(name = "category_id")
	//private int categoryId;                                                  // aşağıda ilişki oldu bunlara gerek kalmadı.
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStock;   
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	
	@ManyToOne()
	@JoinColumn(name="category_id")                                           //category_id ile joinle tabloları dedik
	private Category category;                                                //ürün tek olduğu için category gibi liste tanımlamaya gerek yok. Bir ürün vardır.

}

