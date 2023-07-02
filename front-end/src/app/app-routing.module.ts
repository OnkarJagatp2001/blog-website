import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
<<<<<<< HEAD
import { ProfileComponent } from './profile/profile.component';
=======
import { HomePageComponent } from './components/home-page/home-page.component';
>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
<<<<<<< HEAD
  {path:'profile', component: ProfileComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'}
  // {path: 'update-employee/:id', component: UpdateEmployeeComponent},
  // {path: 'employee-details/:id', component: EmployeeDetailsComponent}
=======
  {path:'home',component:HomePageComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
