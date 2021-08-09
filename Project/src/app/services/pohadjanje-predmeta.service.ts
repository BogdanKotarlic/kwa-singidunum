import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PohadjanjePredmeta } from '../model/pohadjanje-predmeta';

@Injectable({
  providedIn: 'root'
})
export class PohadjanjePredmetaService {
  private base: string = "http://localhost:8080/api/pohadjanjepredmeta"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<PohadjanjePredmeta[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<PohadjanjePredmeta>(`${this.base}/${id}`);
  }

  create(pohadjanjePredmeta: PohadjanjePredmeta) {
    return this.httpClient.post<PohadjanjePredmeta>(this.base, pohadjanjePredmeta);
  }

  update(id: number, pohadjanjePredmeta: PohadjanjePredmeta) {
    return this.httpClient.put<PohadjanjePredmeta>(`${this.base}/${id}`, pohadjanjePredmeta);
  }

  delete(id: number) {
    return this.httpClient.delete<PohadjanjePredmeta>(`${this.base}/${id}`);
  }
}
