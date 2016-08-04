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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the DEMO_ORDERS database table.
 * 
 */
@Entity
@Table(name="DEMO_ORDERS")
@NamedQuery(name="DemoOrder.findAll", query="SELECT d FROM DemoOrder d")
public class DemoOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEMO_ORDERS_ORDERID_GENERATOR", sequenceName="DEMO_ORD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMO_ORDERS_ORDERID_GENERATOR")
	@Column(name="ORDER_ID")
	private long orderId;

	@Column(name="ORDER_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTimestamp;

	@Column(name="ORDER_TOTAL")
	private BigDecimal orderTotal;

	//bi-directional many-to-one association to DemoCustomer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private DemoCustomer demoCustomer;

	//bi-directional many-to-one association to DemoUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private DemoUser demoUser;

	//bi-directional many-to-one association to DemoOrderItem
	@OneToMany(mappedBy="demoOrder")
	private List<DemoOrderItem> demoOrderItems;

	public DemoOrder() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Object getOrderTimestamp() {
		return this.orderTimestamp;
	}

	public void setOrderTimestamp(Date orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public BigDecimal getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public DemoCustomer getDemoCustomer() {
		return this.demoCustomer;
	}

	public void setDemoCustomer(DemoCustomer demoCustomer) {
		this.demoCustomer = demoCustomer;
	}

	public DemoUser getDemoUser() {
		return this.demoUser;
	}

	public void setDemoUser(DemoUser demoUser) {
		this.demoUser = demoUser;
	}

	public List<DemoOrderItem> getDemoOrderItems() {
		return this.demoOrderItems;
	}

	public void setDemoOrderItems(List<DemoOrderItem> demoOrderItems) {
		this.demoOrderItems = demoOrderItems;
	}

	public DemoOrderItem addDemoOrderItem(DemoOrderItem demoOrderItem) {
		getDemoOrderItems().add(demoOrderItem);
		demoOrderItem.setDemoOrder(this);

		return demoOrderItem;
	}

	public DemoOrderItem removeDemoOrderItem(DemoOrderItem demoOrderItem) {
		getDemoOrderItems().remove(demoOrderItem);
		demoOrderItem.setDemoOrder(null);

		return demoOrderItem;
	}

}