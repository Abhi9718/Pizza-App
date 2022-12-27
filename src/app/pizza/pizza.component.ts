import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {

  constructor(private pizzaserv:PizzaService,private router:Router) {
    this.showPizzas()
   }

  ngOnInit(): void {
  }
  pizzaForm=new FormGroup({
    pizzaName:new FormControl(''),
    size:new FormControl(''),
    cost:new FormControl('')
  })
  pizza:any
  email:any
  store:any
  respdata:any
  get(){
    this.pizzaserv.showPizza().subscribe(res=>
      {
        this.respdata=res;
        this.pizza=this.respdata.pizza
      }
      )
  }

  add(){
    this.pizzaserv.addPizza(this.pizzaForm.value).subscribe(res=>{alert("pizza posted successfully")
  this.get()
})
  }

  add1(p1:any){
    this.pizzaserv.addPizza(this.hold).subscribe(res=>{alert("plz work")})
  }

  deletePizzaFromList(pizzaName:String){
    this.pizzaserv.deletePizza(pizzaName).subscribe(res=>{alert("deleted successfully")})
  }


  showPizzas(){
    this.pizzaserv.showPizzaWhichWasAlreadyInDataBase().subscribe(res=>{this.store=res})
  }

  
  hold:any
  save(p:any){
     this.hold=p.loginForm
    alert(this.hold=p)
    console.log(this.hold=p)
    this.add1(p)
    alert("added successfully into your order into your work")
    this.get()
  }


  confirm(){
    alert("Thank you for ordering, your order will be delivered soon")
  
  }

  remove(pizzaName:String){
    this.pizzaserv.deletePizza(pizzaName).subscribe(res=>
      {
        alert("Deleted Successfully")
        this.get()
      }
      )
    }

    log(){
      localStorage.removeItem('jwt')
      alert("You redirecting to login page")
      // this.router.navigate(['/register'])
      this.router.navigate(['/login'])
    }

}
