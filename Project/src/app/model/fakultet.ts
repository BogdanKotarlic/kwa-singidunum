import { StudijskiProgram } from "./studijski-program";
import { Univerzitet } from "./univerzitet";

export interface Fakultet {
    id: number,
    naziv: String,
    studijskiProgram: StudijskiProgram[]|null,
    univerzitet: Univerzitet|null
}