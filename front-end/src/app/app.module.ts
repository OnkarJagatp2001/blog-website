import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule } from '@angular/forms';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProfileComponent } from './profile/profile.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { CreateBlogComponent } from './components/create-blog/create-blog.component';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { ShowBlogComponent } from './components/show-blog/show-blog.component';
import { CommentsComponent } from './components/comments/comments.component';
import { CommentServiceService } from './_services/comment-service.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ProfileComponent,
    HomePageComponent,
    CreateBlogComponent,
    SidebarComponent,
    ShowBlogComponent,
    CommentsComponent
  ],
  imports: [
    BrowserModule,
    AngularEditorModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
