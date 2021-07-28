import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/service/company.service';
import {Router} from '@angular/router';
import {Ipo} from '../../models/Ipo';

@Component({
  selector: 'app-ipo',
  templateUrl: './ipo.component.html',
  styleUrls: ['./ipo.component.css']
})
export class IpoComponent implements OnInit {

  ipos:Ipo[];
  constructor(private router:Router,private companService:CompanyService) {
     this.ipos=[]
   }

  ngOnInit(): void {
    this.companService.getIpos().subscribe(response=>{this.ipos=response});
  }

}
