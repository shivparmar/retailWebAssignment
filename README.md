# retailWebAssignment
Retail Web Assignment


This is Spring Boot project build by Maven.
To run this application either import this project to your favourite IDE or go to the root directory and type following command

`MVN clean install
`
after building project using maven, run application by following below steps

1. If running using IDE then point 'Application.java' as main class and hit run application icon
2. Running using command line `java - jar RetailWebAssignment-1.0-SNAPSHOT
                              `
Application will be up on localhost port 8080. To run health-check please enter http://localhost:8080/health/check

List of available endpoint 

1. Add UserType: POST-> http://localhost:8080/user/type/add 
2. Add User: POST-> http://localhost:8080/user/add
3. Add Product Category: GET-> http://localhost:8080/product/type/add/{category}
4. Add Product : POST-> http://localhost:8080/product/add
5. Create cart for User : GET-> http://localhost:8080/cart/create/{userId}
6. Delete cart : GET-> http://localhost:8080/cart/delete/{cartId}
7. Order product/ Add product in cart : GET-> http://localhost:8080/order/add/{cartId}/{productId}/{quantity}
8. Calculate Discount on cart: GET-> http://localhost:8080/checkout/discount/{cartId}
9. Calculate Total amount on cart: GET-> http://localhost:8080/checkout/total/{cartId}
10. Calculate Toalal Payable amount after discount: GET -> http://localhost:8080/checkout/payable/{cartId}


Prerequisite for this Application

Java    :- 1.8

Maven   : 3 and above

Junit   : 4 and above


UML Diagram is available in directory <Root>/uml
