function getAPI(){
	let URL="https://swapi.co/api/starships"
	let urlProduct="https://swapi.co/api/starships"
	window.fetch(urlProduct).then((ress)=>{
		return res.json()
	}).then((ress)=>{
		let d=ress.results
		let s=d.map(i=>{
			return{
				manufacturer:i.manufacturer
			}
		})
		let ht=gen(s)
		window.divListss.innerHTML=ht
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
		`<li>${i.name}, ${i.mass}</li>`).join('')
}
function gen(list){
	return list.map(i=>
		`<li>${i.manufacturer}</li>`).join('')
}
getAPI()