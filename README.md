# EShopping
The REST API service should implement the following functionalities:

1. Add a product: The service should be able to add a product by the POST request at /products. The product JSON is sent in the request body. If a product with the same ID already exists then the HTTP response code should be 400; otherwise, the response code should be 201.
2. Update a product by id: The service should be able to update a product by the PUT request at /products/{product_id}. The product JSON sent in the request body is described by the following keys:
retail_price: The updated retail price. The value may remain unchanged.
discounted_price: The updated discounted price. The value may remain unchanged.
availability: The updated availability. The value may remain unchanged.
If the product with the requested ID does not exist then the HTTP response code should be 400; otherwise, the response code should be 200.
3. Return a product by id: The service should be able to return the product by the given ID by the GET request at /products/{product_id}. If the product with the requested ID does not exist then the HTTP response code should be 404; otherwise, the response code should be 200.



4. Return products by category: The service should be able to return the JSON array of all the products by the given category by the GET request at /products?category={category}. 
The HTTP response code should be 200. 
The JSON array should be sorted by the availability,in stock products must be listed before out of stock products. 
The products with same availability status must be sorted by the discounted price in the ascending order.
Finally, the products with same discounted price must be sorted by the ID in the ascending order.

5. Return products by category and availability: 
The service should be able to return the JSON array of all the products by the given category and availability by the GET request at /products?category={category}&availability={availability}. 
The availability is described by 0 (false) and 1 (true). 
The HTTP response code should be 200.The JSON array should be sorted by the discount percentage in the descending order. 
The products with same discount percentage status must be sorted by the discounted price in the ascending order. 
Finally, the products with same discounted price must be sorted by the ID in the ascending order.
The discount percentage is calculated as:

Discount Percentage  =  (Retail Price — Discounted Price) ⁄ Retail Price  × 100

It is guaranteed that the discount percentage is always an integer.

6. Return all products: The service should be able to return the JSON array of all products by the GET request at /products. The HTTP response code should be 200. The JSON array should be sorted by the ID in the ascending order.
 

Complete the given project so that it passes all the test cases when running the provided JUnit tests. The project by default supports the use of H2 database, but you can make use of any database to store the data by specifying the dependency in the pom.xml file. Make sure that:

You configure the models correctly, so serialization and deserialization work as expected.
The field names in the response JSON and expected response JSON must exactly match. For example, sending retailprice, retail-price, or retailPrice in the response when retail_price is expected is a wrong response.

