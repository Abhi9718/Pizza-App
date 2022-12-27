import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  constructor(private http:HttpClient) { }

  url="http://localhost:65100/pizza-app"

  email:any;
  hold:any
  piz:any

  addPizza(pizza:any){
    let httpHeaders=new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwt')
    })
    alert(this.email)
    let requestOpt={headers:httpHeaders}
    return this.http.post(this.url+"/addpizza/"+this.email,pizza,requestOpt)
  }

  showPizza(){
    this.hold=this.email
    console.log(this.hold=this.email)
    return this.http.get(this.url+"/userpizzas/"+this.email)
  }

  deletePizza(pizzaName:String){
    let httpHeaders=new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwt')
    })
    alert(this.email)
    let requestOpt={headers:httpHeaders}
    return this.http.delete(this.url+"/delete/"+this.email+"/"+pizzaName,requestOpt)
  }

  showPizzaWhichWasAlreadyInDataBase(){
    this.hold=this.email
    return this.http.get(this.url+"/get")
  }

  postPizzas(pizzas:any){
    this.hold=this.email
    return this.http.post(this.url+"/savepizza",pizzas)
  }


}

