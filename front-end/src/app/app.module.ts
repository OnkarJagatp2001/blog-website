import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
import { ProfileComponent } from './profile/profile.component';
=======
import { HomePageComponent } from './components/home-page/home-page.component';
>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
<<<<<<< HEAD
    ProfileComponent
=======
    HomePageComponent
>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
