var buttonBox = document.getElementById('users');
var buttonBox2 = document.getElementById('types');


for (let index = 0; index < 10; index++) {
    let btn = document.createElement('button');
    btn.innerHTML = "User "+index;
    btn.addEventListener('click', function(){
        alert(btn.innerHTML);
    });
    buttonBox.appendChild(btn);
}

for (let index = 0; index < 12; index++) {
    let btn = document.createElement('button');
    btn.innerHTML = "Type "+index;
    btn.addEventListener('click', function(){
        alert(btn.innerHTML);
    });
    buttonBox2.appendChild(btn);
}