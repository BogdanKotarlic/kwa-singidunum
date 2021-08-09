import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fakultet } from '../model/fakultet';

@Injectable({
  providedIn: 'root'
})
export class FakultetService {
  private base: string = "http://localhost:8080/api/fakulteti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Fakultet[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Fakultet>(`${this.base}/${id}`);
  }

  create(fakultet: Fakultet) {
    return this.httpClient.post<Fakultet>(this.base, fakultet);
  }

  update(id: number, fakultet: Fakultet) {
    return this.httpClient.put<Fakultet>(`${this.base}/${id}`, fakultet);
  }

  delete(id: number) {
    return this.httpClient.delete<Fakultet>(`${this.base}/${id}`);
  }
}
