import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, Observable } from 'rxjs';
import { blogd } from '../models/create-blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private blogURL = "http://localhost:8883/Blogapi";
  private userUrl = "http://localhost:8883/userapi/users/name"
  // http://localhost:8883/Blogapi/getblogbyid/1
  constructor(private httpClient: HttpClient) { }

  getId()
  {
    let vl = sessionStorage.getItem('userid');
    let vs = parseInt(vl || '')
    return vs;
  }


  createBlog(bd:blogd) : Observable<boolean>
  {
    return this.httpClient.post<boolean>(`${this.blogURL}/addblog`,bd);
  }

  getBlog(id:number):Observable<object>
  {
    return this.httpClient.get<object>(`${this.blogURL}/getblogbyid/${id}`);
  }

  likein(id:number){
    return this.httpClient.get(`${this.blogURL}/like/${id}`);
  }

  liked(id:number){
    return this.httpClient.get(`${this.blogURL}/liked/${id}`);
  }

  viewUpdate(id : number)
  {
    console.log(id);
    delay(10000);
    return this.httpClient.get(`${this.blogURL}/views/${id}`);
  }
//http://localhost:8883/Blogapi/views/13
  getName(id:number)
  { 
    return this.httpClient.get(`${this.userUrl}/${id}`);
  }
}
