import { Adresa } from "./adresa";

export interface Mesto {
    id: number,
    naziv: String,
    drzava: String,
    adresa: Adresa
}
