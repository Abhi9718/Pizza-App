import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app1';
  constructor(private router:Router){}
  log(){
    localStorage.removeItem('jwt')
    // this.router.navigate(['/register'])
    this.router.navigate(['/login'])
  }
}
