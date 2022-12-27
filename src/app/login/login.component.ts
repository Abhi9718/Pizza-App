import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PizzaService } from '../pizza.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userv:UserService,private router:Router,private pizzaService:PizzaService) {
  
  }

 ngOnInit(): void {
 }
 
 loginForm=new FormGroup({
   email:new FormControl(''),
   password:new FormControl('')
 })
 data:any
 address:any
 name:any
 login(){
   this.userv.login(this.loginForm.value).subscribe(resp=>{
     alert("logged in successfully");
     // this.pizzaService.email.setItem(this.loginForm.value.email);

     this.address=this.loginForm.value.email;
     this.pizzaService.email=this.address;

     this.router.navigate(['/pizza'])
     this.data=resp
     console.log(this.data.token)
     localStorage.setItem('jwt',this.data.token)
   })
 }

}
