import { Component, Input, SimpleChanges } from '@angular/core';
import { blog } from 'src/app/models/users';
import { BlogService } from 'src/app/_services/blog.service';

@Component({
  selector: 'app-blogs-list',
  templateUrl: './blogs-list.component.html',
  styleUrls: ['./blogs-list.component.css']
})
export class BlogsListComponent {

  @Input() public page = 1;
  constructor(private blogService : BlogService){}
  blogs : blog[] = [];
  flag:boolean = true;
  ngOnInit():void{
    this.myBlogs();
  }

  stripHtmlTags(html: string): string {
    return html.replace(/<[^>]*>/g, '');
  }

  ngOnChanges(changes: SimpleChanges): void {
      console.log(changes);
      if(changes['page'].firstChange) return;
      this.myBlogs();
      
  }

  myBlogs(){
    this.blogService.nextPage(this.blogService.getPage()).subscribe((d : blog[])=>{
      
      console.log(d);
      this.blogs = d;
      if(this.blogs.length == 0){
        this.flag = false;
        BlogService.total =0;
      }
      else{
        this.flag = true;
      }
    })
  }
}
