import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { CompanyComponent } from './component/company/company.component';
import { ExchangeComponent } from './component/exchange/exchange.component';
import { IpoComponent } from './component/ipo/ipo.component';

const routes: Routes = [
  // { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'company', component: CompanyComponent },
  // { path: 'comparison', component: ComparisonComponent },
  { path: 'exchange', component: ExchangeComponent },
  // { path: 'addExchange', component: AddExchangeComponent },
  { path: 'ipo', component: IpoComponent },
  // { path: 'addIpo', component: AddIpoComponent },
  // { path: 'updateIpo/:id', component: AddIpoComponent },
  // { path: 'sector', component: SectorComponent },
  // { path: 'stock', component: StockComponent },
  // { path: 'importData', component: ExcelDataComponent },
  // { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
