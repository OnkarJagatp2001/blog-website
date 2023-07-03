import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { CreateBlogComponent } from './components/create-blog/create-blog.component';
import { ShowBlogComponent } from './components/show-blog/show-blog.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path:'profile', component: ProfileComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path:'home',component:HomePageComponent},
  {path:'create-blog',component:CreateBlogComponent},
  {path:'show-blog',component:ShowBlogComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
