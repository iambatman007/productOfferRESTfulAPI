# Product Offer RESTfulAPI
### Create and query product offers

This web service is created using Java 8 , SpringBoot, H2 in-memory database and deployed on Apache tomcat server.

It has the following features 

#### 1. Create a product offer by hitting the following URL (deploying on local machine)
  URL: http://localhost:8080/offerlist/createoffer
  
  JSON Request Body: {
	"title":"furniture discount",
	"description":"get 20% discount on furniture",
	"validTill":"09/11/2020",
	"discountPercent":"20",
	"appliesTo":"furniture"
}

*Note:*

*a. **"appliesTo"** has the following categories *"apparel,toys,food,games,furniture"**

*b. Date should be entered in the following format **dd/mm/yyyy***


#### 2. To Query an offer you can hit the following URL 

URL: http://localhost:8080/offerlist/{offerId}

#### 3. Delete an existing valid offer

URL: http://localhost:8080/offerlist/delete/{offerId}
