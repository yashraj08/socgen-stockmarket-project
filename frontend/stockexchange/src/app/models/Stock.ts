import { Time } from "@angular/common";

export interface Stock{
    companyId:number,
    exchangeId:number,
    currentPrice:number,
    date:Date,
    time:Time
}