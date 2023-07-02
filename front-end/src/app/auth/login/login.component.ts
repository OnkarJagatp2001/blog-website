import { Component, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { UsersService } from 'src/app/_services/users.service';
import { login, Users } from 'src/app/models/Users';
import { Router } from '@angular/router';

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

  userData : Users = new Users();
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
    navigator
    }
  }
  constructor(private usersService: UsersService,private router: Router) {}
  isLoggedIn:boolean=false;
  x:any=undefined;
  checklogin() {
    this.usersService.checkuser(this.logi).subscribe((data: boolean) => { this.x=data;
      // console.log(this.x);
      if(this.x){
        sessionStorage.setItem('username', this.logi.userName);
        // alert("logged in");
        this.getudata();
<<<<<<< HEAD
        // console.log(sessionStorage.getItem('userid'));
        
        // this.router.navigate(['/home'])
        this.router.navigate(['/profile'])
=======
        this.isLoggedIn=this.isUserLoggedIn();
        this.router.navigate(['/home']); 

>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509
      }
      else{
        alert("UserName Does not exist");
      }
      
    });
  }


  i:string = "";
  v:any=undefined;
  forSession : Users = new Users();
  getudata(){
    let un = sessionStorage.getItem('username');
    this.usersService.udata(un).subscribe((data)=>{this.v=data;
    // console.log(this.v);
    this.userData = this.v;
    this.i=this.userData.userId.toString();
    sessionStorage.setItem('userid',this.i );
    sessionStorage.setItem('name',this.userData.name );
    sessionStorage.setItem('email',this.userData.userEmail );
    sessionStorage.setItem('gender',this.userData.gender );
    sessionStorage.setItem('proff',this.userData.userProf );
    this.i = this.userData.userAge.toString();
    sessionStorage.setItem('age',this.i );
    // console.log("in udata");
    // console.log(sessionStorage.getItem('userid'));
    });
  }

//Check is user logged in or not
  // isUserLoggedIn() {
  //   console.log(sessionStorage.getItem('username'));
  //   sessionStorage.getItem('userid');
<<<<<<< HEAD
  
  // }
=======
    
  // }
  isUserLoggedIn()
  {
    let vl = sessionStorage.getItem('userid')
    let vs = parseInt(vl || '')
    
    if(Number.isNaN(vs))
    return false;
    else
    return true;
  }
 
>>>>>>> bb212b775f7a376a31a80e6c7a82fc16480c8509

    // to get id as number
  getId()
  {
    let vl = sessionStorage.getItem('userid')
    // console.log(vl);
    
    let vs = parseInt(vl || '')
    
    if(Number.isNaN(vs))
    return false
    
    else
    return vs;
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
