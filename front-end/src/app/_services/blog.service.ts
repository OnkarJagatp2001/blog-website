import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { blogd } from '../models/create-blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private blogURL = "http://localhost:8883/Blogapi";
  // http://localhost:8883/Blogapi/getblogbyid/1
  constructor(private httpClient: HttpClient) { }

  getId()
  {
    let vl = sessionStorage.getItem('userid');
    let vs = parseInt(vl || '')
    
    // if(Number.isNaN(vs))
    // return false
    
    // else
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

}
