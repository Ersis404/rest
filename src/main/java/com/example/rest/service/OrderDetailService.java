package com.example.rest.service;

import com.example.rest.model.OrderDetail;
import com.example.rest.model.Product;
import com.example.rest.repository.OrderDetailRepository;
import com.example.rest.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    public final OrderDetailRepository orderDetailRepository;
    public final ProductRepository productRepository;
    public OrderDetailService(OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
    }

    public void addNewOrderDetail(OrderDetail newOrderDetail, Long product_id) {
        Product product = productRepository.findById(product_id).get();
        newOrderDetail.setPrice(product.getPrice());
        orderDetailRepository.save(newOrderDetail);
    }

    public void delOrderDetail(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    public void searchOrderDetail(){
    };
}
