import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Predmet } from '../model/predmet';

@Injectable({
  providedIn: 'root'
})
export class PredmetService {
  private base: string = "http://localhost:8080/api/predmeti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Predmet[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Predmet>(`${this.base}/${id}`);
  }

  create(predmet: Predmet) {
    return this.httpClient.post<Predmet>(this.base, predmet);
  }

  update(id: number, predmet: Predmet) {
    return this.httpClient.put<Predmet>(`${this.base}/${id}`, predmet);
  }

  delete(id: number) {
    return this.httpClient.delete<Predmet>(`${this.base}/${id}`);
  }
}
