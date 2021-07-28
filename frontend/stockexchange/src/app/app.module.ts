import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { UserComponent } from './component/user/user.component';
import { RegisterComponent } from './component/register/register.component';
import { LoginComponent } from './component/login/login.component';
import {RegisterService} from './service/register.service';
import { ExchangeService } from './service/exchange.service';
import { SectorService } from './service/sector.service';
import { AuthService } from './service/auth.service';
import { CompanyService } from './service/company.service';
import { ImportService } from './service/import.service';
import { CompanyComponent } from './component/company/company.component';
import { ExchangeComponent } from './component/exchange/exchange.component';
import { IpoComponent } from './component/ipo/ipo.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserComponent,
    RegisterComponent,
    LoginComponent,
    CompanyComponent,
    ExchangeComponent,
    IpoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RegisterService,AuthService,ExchangeService,SectorService,CompanyService,ImportService],
  bootstrap: [AppComponent]
})
export class AppModule { }
