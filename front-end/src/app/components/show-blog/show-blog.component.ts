import { AUTO_STYLE } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { delay } from 'rxjs';
import { blogd, userN } from 'src/app/models/create-blog';
import { BlogService } from 'src/app/_services/blog.service';

@Component({
  selector: 'app-show-blog',
  templateUrl: './show-blog.component.html',
  styleUrls: ['./show-blog.component.css'],
})
export class ShowBlogComponent implements OnInit {
  constructor(private blogService: BlogService) {}

  blogtitle = '';
  blogtxt = `lorem`;
  name = '';
  f=0;
  numlike = 0;
  id: number = 13;
  bdata: blogd = new blogd();

  ngOnInit(): void {
    this.showblog();
  }

  startDelay(): void {
    setTimeout(() => {
      this.viewed();
    }, 10000); // Delay of 10 seconds (10000 milliseconds)
  }

  viewed() {
    delay(5000);
    this.blogService.viewUpdate(this.id).subscribe((data) => {
      console.log(data);
    });
  }

  likein() {
    if(this.f==1) {this.f=0;
    this.numlike--;
  this.blogService.liked(this.id).subscribe((data)=>{console.log(data);
  })}
    else {this.f=1;
    this.numlike++;
    this.blogService.likein(this.id).subscribe((data)=>{console.log(data);
    })}
  }

  x: any = undefined;
  showblog() {
    this.blogService.getBlog(this.id).subscribe((data) => {
      console.log(data);
      this.x = data;
      this.bdata = this.x;
      console.log(this.bdata.blog_title);
      this.blogtxt = this.bdata.blog_text;
      this.blogtitle = this.bdata.blog_title;
      this.numlike = this.bdata.likes;
      this.UserName();
    });
  }
  y: any = undefined;
  u: userN = new userN();
  UserName() {
    // console.log(this.bdata.user_id);

    this.blogService.getName(this.bdata.user_id).subscribe((data) => {
      console.log(data);
      this.y = data;
      this.u = this.y;
      this.name = this.u.name;
      this.startDelay();
    });
  }

  config: AngularEditorConfig = {
    editable: false,
    showToolbar: false,
    height: 'auto',
    minHeight: 'auto',
    width: '100%',
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
