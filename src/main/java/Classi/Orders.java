package Classi;

import java.time.LocalDate;
import java.util.List;

public class Orders {
    private Long id;
    private String status;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private List<Products> products;

    private Customers customer;

    public Orders(Long id,String status,List<Products> products,Customers customer){
        this.id = id;
        this.orderDate= LocalDate.now();
        this.deliveryDate = orderDate.plusDays(2);
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Customers getCustomer() {
        return customer;
    }

    public List<Products> getProducts() {
        return products;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
