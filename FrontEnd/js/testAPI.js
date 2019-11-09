let URL="http://localhost:9097/account/"
	let urlProduct="https://swapi.co/api/starships"
	axios.get(URL,{
		headers:{
			'Accept' : 'application/json'
		}
	})
 	.then((res)=>{
 		var result=res.results;
	 	 	console.log(res[1].nama)
 	})
 function generateCastHtml(list){
	
	return list.map(i=>
		`'asd'${i.nama}`
		).join('')
} 
