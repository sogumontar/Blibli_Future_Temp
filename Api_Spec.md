#Profile
@Detail Account

*GetProfile(id)
+EndPoint : ``/profiles/1``
+Http Method  : 'GET'
+Request Param: +(id)
+Result : [{
     "id": "1",
     "nama": "Sogumontar Hendra Simangunsong",
     "email": "hendra@gmail.com",
     "telepon": "082234568392",
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
+Request Param: +('nama','email','password','confirm_password','telepon','alamat','tanggal_lahir');
+Result : [{
     "id": "1",
     "nama": "Sogumontar Hendra Simangunsong",
     "email": "hendra@gmail.com",
     "telepon": "082234568392",
     "alamat": "silaen",
     "tanggal_lahir": "25-05-2000",
     "role": "customer",
     "pict": "sxasdw.PNG",
     "created_at": "12-0 5-2019"
}] 

#products

*GetProduk(id)
+EndPoint : ``/products/1``
+Http Method  : 'Get'
+Request Param: +(id)
+Result : [{
      "id": "1",
     "kode_buku": "123",
     "judul": "Belajar matematika",
     "penerbit": "Erlangga",
     "tahun_terbit": "12-04-2002",
     "penulis": "Sogumontar Simangunsong",
     "ISBN": "9123-123-342",
     "bahasa": "indonesia",
     "jumlah_halaman": "244",
     "kategori": "pelajaran",
     "created_at": "12-07-2019"
}] 

*EntryProduk(id)
+EndPoint : ``/entryProducts/``
+Http Method  : 'POST'
+Request Param: +('kode_buku','judul','penerbit','tahun_terbit','penulis','ISBN','bahasa','jumlah_halaman','kategori')
+Result : [{
      "id": "1",
     "kode_buku": "123",
     "judul": "Belajar matematika",
     "penerbit": "Erlangga",
     "tahun_terbit": "12-04-2002",
     "penulis": "Sogumontar Simangunsong",
     "ISBN": "9123-123-342",
     "bahasa": "indonesia",
     "jumlah_halaman": "244",
     "kategori": "pelajaran",
     "created_at": "12-07-2019"
}] 


#Login

*Login('email','password')
+EndPoint : ``/login``
+Http Method  : 'POST'
+Request Param: +('email','password');
+Result : [{
     "email": "hendrasimz92@gmail.com",
     "password": "123aczxichjsdLKASJD81KJ"
     
}] 
