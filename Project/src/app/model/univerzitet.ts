import { Adresa } from "./adresa";

export interface Univerzitet {
    id?: number,
    datumOsnivanja: Date,
    naziv: String,
    adresa: Adresa
}
