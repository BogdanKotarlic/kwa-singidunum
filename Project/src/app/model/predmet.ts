import { GodinaStudija } from "./godina-studija";
import { PohadjanjePredmeta } from "./pohadjanje-predmeta";

export interface Predmet {
    id: number,
    brojPredavanja: number,
    brojVezbi: number,
    drugiObliciNastave: number,
    espb: number,
    istrazivackiRad: number,
    naziv: String,
    obavezan: boolean,
    ostaliCasovi: number,
    godinaStudija: GodinaStudija,
    pohadjanjePredmeta: PohadjanjePredmeta
}
