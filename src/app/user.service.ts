import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ //com gen me
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  url="http://localhost:9654/pizza-app"
  url1="http://localhost:9001/user"  

  register(userObj:any){
    return this.http.post(this.url+"/reg",userObj)
  }

  login(user1:any){
    return this.http.post(this.url1+"/login",user1)
  }

}
