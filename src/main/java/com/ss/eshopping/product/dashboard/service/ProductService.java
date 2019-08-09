package com.ss.eshopping.product.dashboard.service;

import com.ss.eshopping.product.dashboard.Exception.EshoppingException;
import com.ss.eshopping.product.dashboard.model.Product;
import com.ss.eshopping.product.dashboard.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shital on 2019-08-04 14:29.
 */
@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * method to create and save product into productRepository
     * @param product
     * @throws EshoppingException
     */
    public void createProduct(Product product) throws EshoppingException {
        if (findProductById(product.getId()) == null)
            productRepository.save(product);
        else
            throw new EshoppingException("Product already exist", HttpStatus.BAD_REQUEST);
    }

    /**
     * method to find all producs from productRepository
     * @returns list of products
     */
    public List<Product> findAllProducts() {
        return productRepository.findAllByOrderByIdAsc();
    }

    /**
     * method to update product from productRepository
     * @param id
     * @param product
     * @return product
     * @throws EshoppingException
     */
    public Product updateProduct(Long id, Product product) throws EshoppingException {
        Product product1=findProductById(id);
        logger.debug("updating product {}", product1);
        if (product1!=null) {
            product.setId(product1.getId());
            product.setName(product1.getName());
            product.setCategory(product1.getCategory());

            productRepository.save(product);
            logger.debug("updated product {}", product);
        } else {
            logger.error("Product with {} id does not exist in database", id);
            throw new EshoppingException("Product does not exist", HttpStatus.BAD_REQUEST);
        }
        return product;
    }

    /**
     * method to find product by id from productRepository
     * @param id
     * @return
     */
    private Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * finds product using category from productRepository
     * @param category
     * @return
     */
    public List<Product> findProductByCategory(String category) {
        List<Product> products = productRepository.findProductByCategory(category,
                new Sort(Sort.Direction.DESC, "availability")
                .and(new Sort(Sort.Direction.ASC,"discountedPrice"))
                .and(new Sort(Sort.Direction.ASC,"id"))
        );
        return products;
    }

    /**
     * finds product by category and availability in productRepository
     * @param category
     * @param availability
     * @return
     */

    public List<Product> findProductByCategoryAndAvailability(String category,boolean availability) {
        List<Product> products = productRepository.findProductByCategoryAndAvailability(category, availability);
        return products;
    }

    /**
     * returns product by id number
     * @param productId
     * @return
     * @throws EshoppingException with 404 status code if product not found in database
     */

    public Product getproductbyid(long productId) {
        Product product=findProductById(productId);
        if(product==null){
            logger.error("Product with {} id does not exist in database", productId);
            throw  new EshoppingException("Product does not exist", HttpStatus.NOT_FOUND);
        }
        return product;
    }
}
