function getCasts(){
	// const url ='https://swapi.co/api/people'
	const url ='http://localhost:9094/product/1'
	window.fetch(url).then((res)=>{
		return res.json()
	}).then((res)=>{
		const html= `

			
		`
		window.detail.innerHTML =html


	}).then(() => {
		console.log("selesai")
	}).then(()=>console.log("del"))


	const wait = time => new Promise((resolve) => setTimeout(resolve, time));

	
	console.log("test")
}

function generateCastHtml(list){
	// console.log(list.title)
	return list.map(i=>
	`<p>Judul Buku :${i.title}</p>
    <p>Deskripsi Buku : ${i.price}</p>
    <p>Kategori : ${i.categories}</p>
    <p>Tahun Terbit : ${i.publication_year}</p>
    <p>Price : ${i.price}</p>
    <p>Author : ${i.author}</p>
    <p>publisher : ${i.publisher}</p>
    <p>Isbn : ${i.isbn}</p>

    <hr>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-5">
          <img src="Pict/buku_fashion.jpg" alt="">
        </div>
        <div class="col-md-7">
          <p>Belajar Menulis <br>Rp 150.000</p>
        </div>
      </div>
    </div>
		<li>${i.title}, ${i.description}</li>`).join('')
}
getCasts()