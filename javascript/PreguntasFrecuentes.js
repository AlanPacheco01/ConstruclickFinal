const comoFun = document.getElementById("comoFunciona");
comoFun.hidden =true;
const bepart = document.getElementById("formaParte");
bepart.hidden = true;
const comoCon = document.getElementById("comoContacto");
comoCon.hidden = true;
const payment = document.getElementById("comoPago");
payment.hidden = true;
const services = document.getElementById("cuantosServicios");
services.hidden = true;


const howWorks = document.getElementById("comoFunc");
howWorks.addEventListener('click', ()=> {
    comoFun.hidden=false;
    bepart.hidden=true;
    comoCon.hidden = true;
    payment.hidden=true;
    services.hidden = true;
})
howWorks.addEventListener('mouseover',()=>{
    comoFun.hidden=false;
    bepart.hidden=true;
    comoCon.hidden = true;
    payment.hidden=true;
    services.hidden = true;
})

const joinUs= document.getElementById("formaPart");
joinUs.addEventListener('click', ()=>{
    comoFun.hidden=true;
    bepart.hidden=false;
    comoCon.hidden =true;
    payment.hidden=true;
    services.hidden = true;
})

joinUs.addEventListener('mouseover', ()=> {
    comoFun.hidden=true;
    bepart.hidden=false;
    comoCon.hidden =true;
    payment.hidden=true;
    services.hidden = true;
})

const contactUs = document.getElementById("comoContact");
contactUs.addEventListener('click', ()=> {
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden =false;
    payment.hidden=true;
    services.hidden=true;
});

contactUs.addEventListener('mouseover', ()=>{
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden=false;
    payment.hidden=true;
    services.hidden=true;
})

const howPay = document.getElementById("comoPa");
howPay.addEventListener('click', ()=> {
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden=true;
    payment.hidden=false;
    services.hidden=true;
});

howPay.addEventListener('mouseover', ()=>{
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden=true;
    payment.hidden=false;
    services.hidden=true;
})

const howServices = document.getElementById("cuanServic");
howServices.addEventListener('click', ()=> {
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden=true;
    payment.hidden=true;
    services.hidden=false;
});

howServices.addEventListener('mouseover', ()=>{
    comoFun.hidden=true;
    bepart.hidden=true;
    comoCon.hidden=true;
    payment.hidden=true;
    services.hidden=false;
})