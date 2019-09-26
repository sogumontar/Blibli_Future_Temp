function getAPI(){
	let URL="https://swapi.co/api/starships"

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
		window.divList.innerHTML=html
	})
}
function generateCastHtml(list){
	return list.map(i=>
		`<li>${i.name}, ${i.mass}</li>`).join('')
}
getAPI()