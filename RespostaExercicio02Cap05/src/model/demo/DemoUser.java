package model.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the DEMO_USERS database table.
 * 
 */
@Entity
@Table(name="DEMO_USERS")
@NamedQuery(name="DemoUser.findAll", query="SELECT d FROM DemoUser d")
public class DemoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMO_USERS_USERID_GENERATOR", sequenceName="DEMO_USERS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMO_USERS_USERID_GENERATOR")
	@Column(name="USER_ID")
	private long userId;

	@Column(name="ADMIN_USER")
	private String adminUser;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name="EXPIRES_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiresOn;

	private String password;

	private String products;

	@Column(name="\"QUOTA\"")
	private BigDecimal quota;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to DemoOrder
	@OneToMany(mappedBy="demoUser")
	private List<DemoOrder> demoOrders;

	public DemoUser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public Object getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Object getExpiresOn() {
		return this.expiresOn;
	}

	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProducts() {
		return this.products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public BigDecimal getQuota() {
		return this.quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<DemoOrder> getDemoOrders() {
		return this.demoOrders;
	}

	public void setDemoOrders(List<DemoOrder> demoOrders) {
		this.demoOrders = demoOrders;
	}

	public DemoOrder addDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().add(demoOrder);
		demoOrder.setDemoUser(this);

		return demoOrder;
	}

	public DemoOrder removeDemoOrder(DemoOrder demoOrder) {
		getDemoOrders().remove(demoOrder);
		demoOrder.setDemoUser(null);

		return demoOrder;
	}

}