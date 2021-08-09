import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudentNaGodini } from '../model/student-na-godini';

@Injectable({
  providedIn: 'root'
})
export class StudentNaGodiniService {
  private base: string = "http://localhost:8080/api/studentinagodini"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<StudentNaGodini[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<StudentNaGodini>(`${this.base}/${id}`);
  }

  create(studentNaGodini: StudentNaGodini) {
    return this.httpClient.post<StudentNaGodini>(this.base, studentNaGodini);
  }

  update(id: number, studentNaGodini: StudentNaGodini) {
    return this.httpClient.put<StudentNaGodini>(`${this.base}/${id}`, studentNaGodini);
  }

  delete(id: number) {
    return this.httpClient.delete<StudentNaGodini>(`${this.base}/${id}`);
  }
}
