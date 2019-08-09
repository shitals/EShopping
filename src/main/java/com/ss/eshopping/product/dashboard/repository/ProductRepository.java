package com.ss.eshopping.product.dashboard.repository;

import com.ss.eshopping.product.dashboard.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by shital on 2019-08-04 12:58.
 */
@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product,Long> {

    List<Product> findProductByCategory(String category, Sort sort);

    @Query(value = "SELECT * FROM PRODUCT where category=:category AND availability=:availability order by ((RETAIL_PRICE-DISCOUNTED_PRICE )/RETAIL_PRICE*100) desc, discounted_price asc, id asc",nativeQuery = true)
    List<Product> findProductByCategoryAndAvailability(@Param("category") String category, @Param("availability") boolean availability);

    List<Product> findAllByOrderByIdAsc();

    Product findById(long id);

    Product save(Product Object);



}
