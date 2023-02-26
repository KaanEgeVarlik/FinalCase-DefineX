const form1 = document.querySelector('#form1');
const form2 = document.querySelector('#form2');

form1.addEventListener('submit' , event =>{
    event.preventDefault();

    const value = Object.fromEntries(new FormData(form1));

    fetch('http://localhost:8080/users' , {
        method: "POST",
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify(value)
    })
    .then(res => res.json())
    .then(data => console.log(data))
    .then(err => console.log(err));
});

form2.addEventListener('submit' , event =>{
    event.preventDefault();

    //const value2 = Object.fromEntries(new FormData(form2).entries());
    const value2 = new FormData(form2);
    //const data ={};
    //value2.forEach((value, key) => (data[key] = value));
    console.log(value2.getAll("ssn").toString());
    console.log(value2.getAll("bornDate"));

    fetch('http://localhost:8080/sendSMS/' + value2.getAll("ssn").toString() +'/'+ value2.getAll("bornDate") , {
        
    })
    .then(res => res.json())
    .then(data => console.log(data))
    .then(err => console.log(err));
});