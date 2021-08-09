import { Nastavnik } from "./nastavnik";

export interface Zvanje {
    id: number,
    datumIzbora: Date,
    datumPrestanka: Date,
    nastavnik: Nastavnik
}
