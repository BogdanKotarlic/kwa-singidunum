import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NastavnikNaRealizaciji } from '../model/nastavnik-na-realizaciji';

@Injectable({
  providedIn: 'root'
})
export class NastavnikNaRealizacijiService {
  private base: string = "http://localhost:8080/api/nastavnicinarealizaciji"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<NastavnikNaRealizaciji[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<NastavnikNaRealizaciji>(`${this.base}/${id}`);
  }

  create(nastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    return this.httpClient.post<NastavnikNaRealizaciji>(this.base, nastavnikNaRealizaciji);
  }

  update(id: number, nastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    return this.httpClient.put<NastavnikNaRealizaciji>(`${this.base}/${id}`, nastavnikNaRealizaciji);
  }

  delete(id: number) {
    return this.httpClient.delete<NastavnikNaRealizaciji>(`${this.base}/${id}`);
  }
}
