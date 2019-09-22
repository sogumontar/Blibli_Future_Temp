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
		 "nama": "Sogumontar Hendra Simangunsong",
		 "email": "hendra@gmail.com",
		 "telepon": "082234568392",
		 "password": "asdasczxc5324XCasd2CZ",
		 "alamat": "silaen",
		 "tanggal_lahir": "25-05-2000",
		 "role": "customer",
		 "pict": "sxasdw.PNG",
		 "created_at": "12-0 5-2019"
    },{
		"id": "2",
		 "nama": "Andreas Tampubolon",
		 "email": "Andreas Tampubolon@gmail.com",
		 "telepon": "082248953434",
		 "password": "asdasczxc5324XCasd2CZ",
		 "alamat": "balige",
		 "tanggal_lahir": "10-09-1999",
		 "role": "customer",
		 "pict": "sxasdw.PNG",
		 "created_at": "12-0 5-2019"
	}]
}	


## Register Accounts (Customer or Merchant)
*GetProfile(id)
+EndPoint : ``/register``
+Http Method  : `POST`
+Request Param: +('nama','email','password','telepon','alamat','tanggal_lahir');
+Request Body :
	+name
	+email
	+password
	+telepon
	+alamat
	+tanggal_lahir
+Response body(success) :
	```json
{
	"code": 200,
    "status": "OK",
    "data": {
        "id": 1,
        "nama": "Andreas Tampubolon",
        "email": "andreas@gmail.com",
        "password": "macan123",
        "telepon": 082248953434,
        "alamat": "balige",
        "tanggal_lahir": 10/009/1999
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
+Request Param: +('nama','gambar','email','password','tanggal_lahir','alamat');
+Request body : 
	+nama
	+gambar
	+email
	+password
	+tanggal_lahir
	+alamat
+Response body(success) :
```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "nama": "andreas",
        "gambar": "andreas.jpg",
        "email": "andreas@gmail.com",
        "password": macan123,
        "tanggal_lahir": "10/09/1999",
        "alamat": "balige"
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
+Request Param: +('nama','alamat','noNPWP','noKTP','fotoKTP'');
+Response body (success) :
```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "nama": "andreas",
        "alamat": "balige",
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
	+judul
	+penerbit
	+tahun_terbit
	+penulis
	+harga
	+ISBN
	+kategori
	+deskripsi
	+foto_produk
+ Response Body (Success) : 

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
     "id": "1",
	 "sku" :abc-123
     "judul": "Belajar matematika",
     "penerbit": "Erlangga",
     "tahun_terbit": "12-04-2002",
     "penulis": "Sogumontar Simangunsong",
     "harga": "500000",
     "ISBN": "9123-123-342",
     "kategori": "pelajaran",
     "deskripsi": "lorem ispum dolor sit amet",
     "foto_produk": "lorem.jpg"
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
	+judul
	+penerbit
	+tahun_terbit
	+penulis
	+harga
	+ISBN
	+kategori
	+deskripsi
	+foto_produk

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
	+judul
	+penerbit
	+tahun_terbit
	+penulis
	+harga
	+ISBN
	+kategori
	+deskripsi
	+foto_produk

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
	+judul
	+penerbit
	+tahun_terbit
	+penulis
	+harga
	+ISBN
	+kategori
	+deskripsi
	+foto_produk

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
		"date" : "10/09/2019"
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
		"date" : "10/09/2019"
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

