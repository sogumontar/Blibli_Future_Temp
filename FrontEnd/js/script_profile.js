  function getCasts(){
  // const url ='https://swapi.co/api/people'
  const url ="http://localhost:9097/account/find/17";
  window.fetch(url).then((res)=>{
    return res.json()
  }).then((i)=>{
    var gend=i.gender;

    
      const pit=`<img class="card" style="width: 150px; height: 150px;" src="Pict/male.png"><br><br>`;
      const pitt=`<img class="card" style="width: 150px; height: 150px;" src="Pict/girl.png"><br><br>`;
    
    
    const html= `
<input type="text" id="name" required="" class="form-control" name="" readonly value="${i.name}" placeholder="Nama Lengkap" >
          <br>
          <input type="text" id="email" required=""  class="form-control" readonly value="${i.email}" name="" placeholder="Email">
          <br>
          <input type="text" id="username" required="" class="form-control" readonly name="" value="${i.username}" placeholder="Username">
          <br>
          <input type="text" id="username" required="" class="form-control" readonly name="" value="${i.gender}" placeholder="Username">
          <br>
          <input type="number" id="telepon" class="form-control" value="${i.telepon}" readonly name="" placeholder="Telepon">
          <br>
          <input type="text" id="alamat" class="form-control" value="${i.alamat}" name="" readonly placeholder="Alamat">
          <br>
          <input type="date" id="tanggal_lahir" class="form-control" value=${i.tanggal_lahir} readonly required="required" placeholder="Tanggal Lahir">
          <br><br>
          <button style="height:  40px;" class="btn btn-primary" id="register">Edit</button>
          <br><br>



    `
    if(gend==="male"){
      window.pic.innerHTML=pit;  
    }else{
      window.pic.innerHTML=pitt;
    }
    
    window.detail.innerHTML =html


  }).then(() => {
    console.log("selesai")
  }).then(()=>console.log("del"))


  const wait = time => new Promise((resolve) => setTimeout(resolve, time));


  console.log("test")
}


getCasts()
