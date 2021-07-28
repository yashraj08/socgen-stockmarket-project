import { BoardOfDirectors } from "./BoardOfDirector";
export interface Company{
    name:string,
    turnover:number,
    about:string,
    ceo:string,
    listed?:boolean,
    sectorName:String,
    boardOfDirectors:BoardOfDirectors[]

}