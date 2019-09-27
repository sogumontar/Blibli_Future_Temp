function getAPI(){
	let URL="https://swapi.co/api/starships"
	let urlProduct="https://swapi.co/api/starships"
	window.fetch(urlProduct).then((ress)=>{
		return ress.json()
	}).then((ress)=>{
		let d=ress.results
		let s=d.map(i=>{
			return{
				manufacturer:i.manufacturer
			}
		})
		let ht=gen(s)
		window.divListss.innerHTML=ht;
	})

	window.fetch(URL).then((res)=>{
		return res.json()
	}).then((res)=>{
		let data=res.results
		let l=data.map(i=>{
			return {
				name:i.name,
				mass:i.mass
			}
		})
		let html=generateCastHtml(l)
		let htmls=generateCastHtml(l)
		window.divList.innerHTML=html
		window.divLists.innerHTML=htmls
	})
}
function generateCastHtml(list){
	return list.map(i=>
		`<div class='container'>
			<ul>
				<div class="form-inline">	
					<img width='80px' src="pict/351498779_9037cd50-325c-4d33-8025-d4ef0201c0a5_2048_2048.jpg">	
					<p>${i.name} 
							<p style="color: green ;"> ${i.mass}</p>
						</p>
				</div>
				<div class="form-inline">
					<button class="btn btn-danger" style="margin-left:150px;">Hapus</button>
				</div>
				<br><br>
				<hr>
			</ul>
		</div>
		<br><br><br>
		<hr>`).join('')
} 
function gen(list){
	return list.map(i=>
		`<li>${i.manufacturer}</li>`).join('')
}
getAPI()