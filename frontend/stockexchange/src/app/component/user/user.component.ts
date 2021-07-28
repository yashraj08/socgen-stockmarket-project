import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users:User[]|undefined;
 
  constructor(private registerService:RegisterService) { }

  ngOnInit(): void {
    this.registerService.getUsers().subscribe(Users=>{this.users=Users});
  }

}
