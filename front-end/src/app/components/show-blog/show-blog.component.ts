import { AUTO_STYLE } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { blogd } from 'src/app/models/create-blog';
import { BlogService } from 'src/app/_services/blog.service';

@Component({
  selector: 'app-show-blog',
  templateUrl: './show-blog.component.html',
  styleUrls: ['./show-blog.component.css']
})
export class ShowBlogComponent implements OnInit{
  
  constructor(private blogService : BlogService){}
  
blogtxt = "hellp";
blogtitle="";
  id:number=11;
  bdata : blogd = new blogd();

  ngOnInit(): void {
    this.showblog();
  }
  x :any =undefined;
  showblog()
  {
    this.blogService.getBlog(this.id).subscribe((data)=>{
      console.log(data);
      this.x = data;
      this.bdata = this.x;
      console.log(this.bdata.blog_title);
      this.blogtxt = this.bdata.blog_text;
      this.blogtitle = this.bdata.blog_title;
    })
  }

  config: AngularEditorConfig = {
    editable: false,
    showToolbar: false,
    height: '100rem',
    minHeight: '50%',
    width:'90%'
  };

  // config: AngularEditorConfig = {
  //   editable: false,
  //   spellcheck: true,
  //   height: '50%',
  //   minHeight: '28rem',
  //   width: '90%',
  //   enableToolbar:false,
  //   showToolbar: false
  // };
  uploadImage(event: any) {
    const file = event.target.files[0];
  }
}
