import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Exchange } from 'src/app/models/Exchange';
import { ExchangeService } from 'src/app/service/exchange.service';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {

  exchanges:Exchange[];
  constructor(private router:Router,private exchangeService:ExchangeService) {
    this.exchanges=[];
   }

  ngOnInit(): void {
    this.exchangeService.getExchanges().subscribe(Exchanges=>{this.exchanges=Exchanges});
  }


}
