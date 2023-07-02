import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit{
  ngOnInit(): void {
    // this.isUserLoggedIn();
  }
  isUserLoggedIn()
  {
    let vl = sessionStorage.getItem('userid')
    let vs = parseInt(vl || '')
    
    if(Number.isNaN(vs))
    return false;
    else
    return true;
  }
  isLoggedIn:boolean=this.isUserLoggedIn();
}
