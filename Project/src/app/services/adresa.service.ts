import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Adresa } from '../model/adresa';

@Injectable({
  providedIn: 'root'
})
export class AdresaService {
  private base: string = "http://localhost:8080/api/adrese"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Adresa[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Adresa>(`${this.base}/${id}`);
  }

  create(adresa: Adresa) {
    return this.httpClient.post<Adresa>(this.base, adresa);
  }

  update(id: number, adresa: Adresa) {
    return this.httpClient.put<Adresa>(`${this.base}/${id}`, adresa);
  }

  delete(id: number) {
    return this.httpClient.delete<Adresa>(`${this.base}/${id}`);
  }
}
