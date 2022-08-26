package com.atul.orders.controller;

import com.atul.orders.model.Product;
import com.atul.orders.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private Product product1;
    private Product product2;

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        product1 = new Product();
        product1.setId(1);
        product1.setName("apple");
        product1.setPrice(0.60);
        product1.setQuantity(10);

        product2 = new Product();
        product2.setId(2);
        product2.setName("orange");
        product2.setPrice(0.25);
        product2.setQuantity(20);
    }

    @Test
    public void getAllProducts(){
        List<Product> listOfProducts = Arrays.asList(product1,product2);
        when(productService.getProducts()).thenReturn(listOfProducts);
        List<Product> response = productController.findAllProducts();
        assertThat(response).isEqualTo(listOfProducts);
    }

    @Test
    public void getProductById(){
        when(productService.getProductById(1)).thenReturn(product1);
        Product response = productController.findProductById(1);
        assertThat(response).isEqualTo(product1);
    }

    @Test
    public void deleteProductById(){
        ProductController controller = mock(ProductController.class);
        controller.deleteProduct(1);
        verify(controller, times(1)).deleteProduct(1);
    }

    @Test
    public void saveProduct(){
        when(productService.saveProduct(product1)).thenReturn(product1);
        Product response = productController.addProduct(product1);
        assertThat(response).isEqualTo(product1);
    }

}
