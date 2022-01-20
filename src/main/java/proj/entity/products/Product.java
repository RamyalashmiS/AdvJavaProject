package proj.entity.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Products")
public class Product {
	@Id
	@Column(name="productId")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int productId;
	@Column(name="productname",length=20)
	private String productName;
	@Column(name="description",length=200)
	private String description;
	@Column(name="cost",nullable=false)
	private int cost;
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProdName(String prodName) {
		this.productName = prodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Product(int prodId, String prodName, String description, int cost) {
		super();
		this.productId = prodId;
		this.productName = prodName;
		this.description = description;
		this.cost = cost;
	}


	
	public Product() {
		super();
	}
	
	
}
