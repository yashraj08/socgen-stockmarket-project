import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Company } from 'src/app/models/Company';
import { CompanyService } from 'src/app/service/company.service';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companies:Company[]; 
  constructor(private router:Router,private companyService:CompanyService,private authService:AuthService) {
    this.companies=[];
   }

  ngOnInit(): void {
    this.companyService.getCompanies();
  }

}
