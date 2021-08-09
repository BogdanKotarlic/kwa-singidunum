import { Fakultet } from "./fakultet";
import { Predmet } from "./predmet";
import { StudijskiProgram } from "./studijski-program";

export interface Nastavnik {
    id: number,
    biografija: String,
    ime: String,
    jmbg: String,
    fakultet: Fakultet,
    predmet: Predmet,
    studijskiProgram: StudijskiProgram
}
