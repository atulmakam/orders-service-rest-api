package com.atul.orders.model;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductTest {

    @Test
    public void testProduct_name_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product(1, "apple", 100,0.6);

        product.setName("apple");

        final Field field = product.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertThat(field.get(product)).isEqualTo("apple");
    }

    @Test
    public void testProduct_name_getsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product();
        final Field field = product.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(product, "apple");

        final String result = product.getName();

        assertThat(result).isEqualTo("apple");
    }

    @Test
    public void testProduct_id_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product(1, "apple", 100,0.6);

        product.setId(1);

        final Field field = product.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertThat(field.get(product)).isEqualTo(1);
    }

    @Test
    public void testProduct_id_getsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product();
        final Field field = product.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(product, 1);

        final int result = product.getId();

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testProduct_quantity_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product(1, "apple", 100,0.6);

        product.setQuantity(100);

        final Field field = product.getClass().getDeclaredField("quantity");
        field.setAccessible(true);
        assertThat(field.get(product)).isEqualTo(100);
    }

    @Test
    public void testProduct_quantity_getsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product();
        final Field field = product.getClass().getDeclaredField("quantity");
        field.setAccessible(true);
        field.set(product, 100);

        final int result = product.getQuantity();

        assertThat(result).isEqualTo(100);
    }

    @Test
    public void testProduct_price_setsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product(1, "apple", 100,0.6);

        product.setPrice(0.6);

        final Field field = product.getClass().getDeclaredField("price");
        field.setAccessible(true);
        assertThat(field.get(product)).isEqualTo(0.6);
    }

    @Test
    public void testProduct_price_getsProperly() throws NoSuchFieldException, IllegalAccessException {
        final Product product = new Product();
        final Field field = product.getClass().getDeclaredField("price");
        field.setAccessible(true);
        field.set(product, 0.6);

        final double result = product.getPrice();

        assertThat(result).isEqualTo(0.6);
    }

}
