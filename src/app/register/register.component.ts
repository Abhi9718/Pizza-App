import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userv:UserService,private router:Router) { }

  ngOnInit(): void {
  }

  userForm=new FormGroup({
    employeeName:new FormControl('',),
    email:new FormControl(''),
    password:new FormControl('')
    
  })

  register(){
    this.userv.register(this.userForm.value).subscribe(response=>{alert("registered successfully")
  this.router.navigate(['/login'])})
  }

}