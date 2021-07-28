import { Component, OnInit,ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import {User} from '../../models/User';
import { RegisterService } from '../../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User={
    username:"",
    password:"",
    email:"",
    mobile:"",
    isdCode:"",
    isAdmin:false,
    confirmed:false
  };
  @ViewChild('registerForm')form:any;
  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
     
  }
  onSubmit({value}:{value:User}){
    


    
      value.confirmed=false;
      value.isAdmin=false;
      this.registerService.registerUser(value);
      this.form.reset();
    
   
  }

}
