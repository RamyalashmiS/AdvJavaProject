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
	@Column(name="ProductId")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int prodId;
	@Column(name="productname")
	private String prodName;
	@Column(name="description")
	private String description;
	@Column(name="cost")
	private int cost;
	
	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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
		this.prodId = prodId;
		this.prodName = prodName;
		this.description = description;
		this.cost = cost;
	}


	
	public Product() {
		super();
	}
	
	
}
