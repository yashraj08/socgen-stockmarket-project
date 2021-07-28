import { Component, OnInit ,ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import { Login } from 'src/app/models/Login';
import { AuthService } from 'src/app/service/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login:Login={
    username:"",
    password:""
  };

  constructor(private authService:AuthService,private router:Router) { }
  @ViewChild('loginForm')form:any;
  ngOnInit(): void {

  }
  onSubmit({value}:{value:Login}){  
  
    this.authService.loginUser(value);
    this.router.navigate(['/company']);
  
 
}

}
