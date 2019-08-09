package com.ss.eshopping.product.dashboard.controller;

import com.ss.eshopping.product.dashboard.model.Product;
import com.ss.eshopping.product.dashboard.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    Logger logger = LoggerFactory.getLogger(ProductsController.class);

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * endpoint to read products from database
     * @param category optional
     * @param availability optional
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(@RequestParam(name = "category",required = false) String category, @RequestParam(name = "availability",required = false) Integer availability){
        List<Product> products;
        if(category==null && availability ==null){
            logger.debug("getProducts...");
            products= productService.findAllProducts();
        }else if(category!=null && availability==null ){
            logger.debug("getProducts by category...");
            products= productService.findProductByCategory(category);
        }else{
            logger.debug("getProducts by category and availability...");
            products=productService.findProductByCategoryAndAvailability(category,availability!=0);
        }

        return products;
    }

    /**
     * endpoint to create product
     * @param product
     * @return
     */
    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * endpoint to update the product details
     * @param productId
     * @param product
     * @return
     */

    @PutMapping(path = "/{productId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@PathVariable long productId, @RequestBody Product product){
        productService.updateProduct(productId,product);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * edpoint to find the product using product id
     * @param productId
     * @return
     */

    @GetMapping(path = "/{productId}")
    public Product getProdct(@PathVariable long productId){
        return productService.getproductbyid(productId);
    }

}
