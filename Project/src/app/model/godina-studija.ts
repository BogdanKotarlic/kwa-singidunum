import { StudentNaGodini } from "./student-na-godini";
import { StudijskiProgram } from "./studijski-program";

export interface GodinaStudija {
    id: number,
    godina: Date,
    studentNaGodini: StudentNaGodini,
    studijskiProgram: StudijskiProgram
}
