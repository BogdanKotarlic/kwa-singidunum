import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Nastavnik } from '../model/nastavnik';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {
  private base: string = "http://localhost:8080/api/nastavnici"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Nastavnik[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Nastavnik>(`${this.base}/${id}`);
  }

  create(nastavnik: Nastavnik) {
    return this.httpClient.post<Nastavnik>(this.base, nastavnik);
  }

  update(id: number, nastavnik: Nastavnik) {
    return this.httpClient.put<Nastavnik>(`${this.base}/${id}`, nastavnik);
  }

  delete(id: number) {
    return this.httpClient.delete<Nastavnik>(`${this.base}/${id}`);
  }
}
