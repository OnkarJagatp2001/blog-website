import { Component, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { UsersService } from 'src/app/_services/users.service';
import { login } from 'src/app/models/Users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @ViewChild('f') form!: NgForm;

  logi: login = new login();
  // form = new FormGroup({
  //   password: new FormControl('', [Validators.required, this.passwordValidator])
  // });
  onSubmit(form: NgForm) {
    if (form.invalid) {
      alert('Invalid');
    }
    // alert("submitted");
    else{
    console.log(form);
    this.logi.userName = this.form.value.username;
    this.logi.userPass = this.form.value.password;

    console.log(this.logi.userName);
    this.checklogin();
    }
  }
  constructor(private usersService: UsersService) {}

  x:any=undefined;
  checklogin() {
    this.usersService.checkuser(this.logi).subscribe((data: boolean) => { this.x=data;
      console.log(this.x);
      if(this.x){
        alert("logged in");
      }
      else{
        alert("UserName Does not exist");
      }
      
    });
  }
  // passwordValidator(control: FormControl): { [key: string]: boolean } | null {
  //   const password = control.value;
  //   const hasUppercase = /[A-Z]/.test(password);
  //   const hasLowercase = /[a-z]/.test(password);
  //   const hasDigit = /\d/.test(password);
  //   const minLength = 8;

  //   if (!hasUppercase || !hasLowercase || !hasDigit || password.length < minLength) {
  //     return { 'invalidPassword': true };
  //   }

  //   return null;
  // }
  // myForm = new FormGroup({
  //   password: new FormControl('', [Validators.required, this.passwordValidator])
  // });

  // Usage in a form group

}
