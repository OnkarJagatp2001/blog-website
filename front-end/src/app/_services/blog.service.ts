import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { blogd } from '../models/create-blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private blogURL = "http://localhost:8883/Blogapi";
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
}
