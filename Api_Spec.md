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
+EndPoint : ``/edit``
+Http Method  : `POST`
+Request Param: +('nama','gambar','email','password','tanggal_lahir','alamat');
+Request body : 
	+nama
	+gambar
	+email
	+password
	+tanggal_lahir
	+alamat
Response {'Update Success'}


@registerMerchant
*merchantRegister(id)
+EndPoint : ``/merchantRegister``
+Http Method  : 'POST'
+Request Param: +('nama','alamat','noNPWP','NOKTP','fotoKTP'');
Response {'Register Success'}




#products

#Get by product id
*GetProduk(id)
+EndPoint : ``/products/1``
+Http Method  : 'Get'
+Request Param: +(id)
+Result : [{
     "id": "1",
     "judul": "Belajar matematika",
     "penerbit": "Erlangga",
     "tahun_terbit": "12-04-2002",
     "penulis": "Sogumontar Simangunsong",
     "harga": "500000",
     "ISBN": "9123-123-342",
     "kategori": "pelajaran",
     "deskripsi": "lorem ispum dolor sit amet",
     "created_at": "12-07-2019"
}] 

@EntryProduk(id)
+EndPoint : ``/entryProducts/``
+Http Method  : 'POST'
+Request Param: +('kode_buku','judul','penerbit','tahun_terbit','penulis','ISBN','bahasa','jumlah_halaman','kategori')
+Response {"Entry product success"}

@AddWishlist
+EndPoint : ``/wishlist{idBuku}/``
+Http Method  : 'POST'
+Request Param: +('id_buku','date');
+Response {"Add to wishlist success"}

@AddToCart
+EndPoint : ``/cart{idBuku}/``
+Http Method  : 'POST'
+Request Param: +('id_buku','date');
+Response {"Add to Cart success"}

