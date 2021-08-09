import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudijskiProgram } from '../model/studijski-program';

@Injectable({
  providedIn: 'root'
})
export class StudijskiProgramService {
  private base: string = "http://localhost:8080/api/studijski_programi"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<StudijskiProgram[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<StudijskiProgram>(`${this.base}/${id}`);
  }

  create(studijskiProgram: StudijskiProgram) {
    return this.httpClient.post<StudijskiProgram>(this.base, studijskiProgram);
  }

  update(id: number, fakultet: StudijskiProgram) {
    return this.httpClient.put<StudijskiProgram>(`${this.base}/${id}`, fakultet);
  }

  delete(id: number) {
    return this.httpClient.delete<StudijskiProgram>(`${this.base}/${id}`);
  }
}
