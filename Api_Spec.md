#Account

@GetProfile(id)
+EndPoint : ``/profiles/1``
+Http Method  : 'GET'
+Request Param: +(id)
+Result : [{
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
}] 


@Register Accounts
*GetProfile(id)
+EndPoint : ``/register``
+Http Method  : 'POST'
+Request Param: +('nama','email','password','telepon','alamat','tanggal_lahir');
+Respon {'Register Success'}


@Login
*Login('email','password')
+EndPoint : ``/login``
+Http Method  : 'POST'
+Request Param: +('email','password');
+Respon {'Login Success' / 'Login Failed'}

@Update Account
*EditProfile(id)
+EndPoint : ``/edit``
+Http Method  : 'POST'
+Request Param: +('nama','gambar','email','password','tanggal_lahir','alamat');
Response {'Update Success'}


@registerMerchant
*merchantRegister(id)
+EndPoint : ``/merchantRegister``
+Http Method  : 'POST'
+Request Param: +('nama','alamat','noNPWP','NOKTP','fotoKTP'');
Response {'Register Success'}



#products

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

