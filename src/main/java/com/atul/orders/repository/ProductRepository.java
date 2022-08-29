package com.atul.orders.repository;

import com.atul.orders.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public void createProducts() {
        list = List.of(
                new Product(1, "apple", 10, 0.60),
                new Product(2, "orange", 20, 0.25)
        );
    }

    public List<Product> getAllProducts() {
        orderSummary();
        return list;
    }

    public String orderSummary(){
        double totalPrice=0;
        int totalItems=0;
        for (Product p: list){
            totalItems+=p.getQuantity();
        }
        for (Product p: list){
            totalPrice+=p.getQuantity()*p.getPrice();
        }
        String ti = "Total number of items:";
        String totalItemsStr = String.valueOf(totalItems);
        String tc= "Total cost of the order is:$";
        String orderTotalStr = String.valueOf(totalPrice);
        String li = "The list of items are:";
        String listItemsStr = String.valueOf(list);
        String summary = li+"\n"+listItemsStr+"\n"+ti+totalItemsStr+"\n"+tc+orderTotalStr;
        return summary;
    }

    public Product findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Product> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Product save(Product p) {
        Product product = new Product();
        product.setId(p.getId());
        product.setName(p.getName());
        product.setQuantity(p.getQuantity());
        product.setPrice(p.getPrice());
        list.add(product);
        return product;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Product update(Product product) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (product.getId())) {
                id = product.getId();
                idx = i;
                break;
            }
        }

        Product product1 = new Product();
        product1.setId(id);
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());
        list.set(idx, product);
        return product1;
    }

}
