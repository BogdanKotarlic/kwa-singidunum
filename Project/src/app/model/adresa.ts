import { Fakultet } from "./fakultet";
import { Nastavnik } from "./nastavnik";
import { Student } from "./student";
import { Univerzitet } from "./univerzitet";

export interface Adresa {
    id: number,
    broj: number,
    ulica: String,
    fakultet: Fakultet,
    nastavnik: Nastavnik,
    student: Student,
    univerzitet: Univerzitet
}
