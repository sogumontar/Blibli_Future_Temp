#Account API

## Get Profile(by Id)

+EndPoint : ``/profiles/{id}``
+Http Method  : `GET`
+Request Param: 
	+(id)
+ Request Header : 
	+ Accept: `application/json`
+ Response Body (Success) : 

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": "1",
		 "name": "Sogumontar Hendra Simangunsong",
		 "email": "hendra@gmail.com",
		 "telephone": "082234568392",
		 "password": "asdasczxc5324XCasd2CZ",
		 "address": "silaen",
		 "date_of_birth": "939456671",
		 "role": "customer",
		 "picture": "sxasdw.PNG",
		 "created_at": "939456671"
    },{
		"id": "2",
		 "name": "Andreas Tampubolon",
		 "email": "Andreas Tampubolon@gmail.com",
		 "telephone": "082248953434",
		 "password": "asdasczxc5324XCasd2CZ",
		 "address": "balige",
		 "date_of_birth": "939456671",
		 "role": "customer",
		 "picture": "sxasdw.PNG",
		 "created_at": "939456671"
	}]
}	


## Register Accounts (Customer or Merchant)
*GetProfile(id)
+EndPoint : ``/register``
+Http Method  : `POST`
+Request Param: +('name','email','password','telephone','address','date_of_birth');
+Request Body :
	+name
	+email
	+password
	+telephone
	+address
	+date_of_birth
	+Response body(success) :
	```json
{
	"code": 200,
    "status": "OK",
    "data": {
        "id": 1,
        "name": "Andreas Tampubolon",
        "email": "andreas@gmail.com",
        "password": "macan123",
        "telephone": 082248953434,
        "address": "balige",
        "date_of_birth": 939456671
    }
}
```


## Login
*Login('email','password')
+EndPoint : ``/login``
+Http Method  : 'POST'
+Request Param: +('email','password');
+Request Body :
	+email
	+password
+Respon {'Login Success' / 'Login Failed'}
+Response body(success) :
``json
	{
		"code": 200,
		"status": "OK",
		"access_token" : yRQYnWzskCZUxPwaQupWkiUzKELZ49eM7oWxAQK_ZXw
	}
```	
+ Response Body (Fail) : 
```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 400,
    "status": "Bad Request",
    "message": "Invalid Request: Invalid request format",
    "path": "/login"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 401,
    "status": "Unauthorized",
    "message": "Invalid Request: Invalid user authentication or Unauthorized",
    "path": "/login"
}
```

## Update Account
*EditProfile(id)
+EndPoint : ``/editAccount``
+Http Method  : `POST`
+Request Param: +('name','picture','email','password','date_of_birth','address');
+Request body : 
	+name
	+picture
	+email
	+password
	+date_of_birth
	+address
+Response body(success) :
```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "name": "andreas",
        "picture": "andreas.jpg",
        "email": "andreas@gmail.com",
        "password": macan123,
        "date_of_birth": "10/09/1999",
        "address": "balige"
    }
}
```

+Response body(fail) :
```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 400,
    "status": "Bad Request",
    "message": "Invalid Request: Invalid request format",
    "path": "/editAccount"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 401,
    "status": "Unauthorized",
    "message": "Invalid Request: Invalid user authentication or Unauthorized",
    "path": "/editAccount"
}
```

## registerMerchant
*merchantRegister(id)
+EndPoint : ``/merchantRegister``
+Http Method  : `POST`
+Request Param: +('name','address','noNPWP','noKTP','fotoKTP'');
+Response body (success) :
```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "name": "andreas",
        "address": "balige",
        "noNPWP": "1234126634",
        "noKTP": 1212423235234234,
        "fotoKTP": "andreas.jpg"
    }
}
```

+Response body(fail) :
```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 400,
    "status": "Bad Request",
    "message": "Invalid Request: Invalid request format",
    "path": "/merchantRegister"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 401,
    "status": "Unauthorized",
    "message": "Invalid Request: Invalid user authentication or Unauthorized",
    "path": "/merchantRegister"
}
```	


#products

##Get by product id
*GetProduk(id)
+EndPoint : ``/products/{id}``
+Http Method  : 'Get'
+Request Param: +(id)
+Request body :
	+id
	+sku
	+title
	+publisher
	+publication_year
	+author
	+price
	+ISBN
	+categories
	+description
	+picture_produk
+ Response Body (Success) : 

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
     "id": "1",
	 "sku" :abc-123
     "title": "Belajar matematika",
     "publisher": "Erlangga",
     "publication_year": "12-04-2002",
     "author": "Sogumontar Simangunsong",
     "price": "500000",
     "ISBN": "9123-123-342",
     "categories": "pelajaran",
     "description": "lorem ispum dolor sit amet",
     "picture_produk": "lorem.jpg"
}] 
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/products/{id}"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/products/{id}"
}
```

# add new product
+EndPoint : ``/products/``
+Http Method  : `POST`
+Request Param: +('kode_buku','judul','penerbit','tahun_terbit','penulis','ISBN','bahasa','jumlah_halaman','kategori')
+Request body :
	+id
	+sku
	+title
	+publisher
	+publication_year
	+author
	+price
	+ISBN
	+categories
	+description
	+picture_produk

```json
{
    "code": 200,
    "status": "OK",
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/products"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/products"
}
```


## edit product 
+EndPoint : ``/products/{id}``
+Http Method  : `PUT`
+Request Param: +('kode_buku','judul','penerbit','tahun_terbit','penulis','ISBN','bahasa','jumlah_halaman','kategori')
+Request body :
	+id
	+sku
	+title
	+publisher
	+publication_year
	+author
	+price
	+ISBN
	+categories
	+description
	+picture_produk

```json
{
    "code": 200,
    "status": "OK",
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/products/{id}"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/products/{id}"
}
```


## delete product (Merchant) 
+EndPoint : ``/products/{id}``
+Http Method  : `DELETE`
+Request Param: +('kode_buku','judul','penerbit','tahun_terbit','penulis','ISBN','bahasa','jumlah_halaman','kategori')
+Request body :
	+id
	+sku
	+title
	+publisher
	+publication_year
	+author
	+price
	+ISBN
	+categories
	+description
	+picture_produk

```json
{
    "code": 200,
    "status": "OK",
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/products/{id}"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/products/{id}"
}
```

# Wishlist

## Add Wishlist (Customer)
+EndPoint : ``/wishlist/``
+Http Method  : 'POST'
+Request Param: +('id_buku','date');
```json
{
    "code": 200,
    "status": "OK",
	"data" : [{
		"id_buku" : "2"
		"date" : "939456671"
	}]
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/wishlist"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/wishlist"
}
```


## Delete Wishlist (Customer)
+EndPoint : ``/wishlist/id``
+Http Method  : 'DELETE'
+Request Param: +('id');
```json
{
    "code": 200,
    "status": "OK"
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/wishlist/{id}"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/wishlist/{id}"
}
```

# Order

## Add Order (Customer)
+EndPoint : ``/order/``
+Http Method  : `POST`
+Request Param: +('id','id_buku','id_customer','date');
```json
{
    "code": 200,
    "status": "OK",
	"data" : [{
		"id_buku" : "2"
		"id_customer" : "3"
		"date" : "939456671"
	}]
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/order"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/order"
}
```

## delete Order (Customer)
+EndPoint : ``/order/{id}``
+Http Method  : `POST`
+Request Param: +('id','id_buku','id_customer','date');
```json
{
    "code": 200,
    "status": "OK"
}
```	

+ Response Body (Fail) : 

```json
{
	"code" : "400",
    "status" : "Bad Request",
    "message" : "Invalid Request: Invalid user authentication or invalid request format",
    "path" : "/order/{id}"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 404,
    "status": "Not Found",
    "message": "Invalid Request: Cannot find a Product with that Id.",
    "path": "/order/{id}"
}
```

@AddToCart
+EndPoint : ``/cart{idBuku}/``
+Http Method  : 'POST'
+Request Param: +('id_buku','date');
+Response {"Add to Cart success"}

