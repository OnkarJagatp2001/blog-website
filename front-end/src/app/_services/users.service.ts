import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users, login } from '../models/Users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseURL = "http://localhost:8883/userapi/users";
  private LogURL = "http://localhost:8883/userapi/login";

  constructor(private httpClient: HttpClient) { }

  createUser(userData:Users):Observable<object>{
    return this.httpClient.post(`${this.baseURL}`, userData);
  }

  checkuname(user:Users) : Observable<boolean>{
    return this.httpClient.post<boolean>(`${this.baseURL}/check`,user);
  }
  
  
  checkuser(login:login) : Observable<boolean>
  {
      return this.httpClient.post<boolean>(`${this.LogURL}`,login);
  }
  
}
