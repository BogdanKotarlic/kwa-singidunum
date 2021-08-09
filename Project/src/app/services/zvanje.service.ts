import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Zvanje } from '../model/zvanje';

@Injectable({
  providedIn: 'root'
})
export class ZvanjeService {
  private base: string = "http://localhost:8080/api/zvanja"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Zvanje[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Zvanje>(`${this.base}/${id}`);
  }

  create(zvanje: Zvanje) {
    return this.httpClient.post<Zvanje>(this.base, zvanje);
  }

  update(id: number, zvanje: Zvanje) {
    return this.httpClient.put<Zvanje>(`${this.base}/${id}`, zvanje);
  }

  delete(id: number) {
    return this.httpClient.delete<Zvanje>(`${this.base}/${id}`);
  }
}
