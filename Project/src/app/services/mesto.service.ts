import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mesto } from '../model/mesto';

@Injectable({
  providedIn: 'root'
})
export class MestoService {
  private base: string = "http://localhost:8080/api/mesta"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Mesto[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Mesto>(`${this.base}/${id}`);
  }

  create(mesto: Mesto) {
    return this.httpClient.post<Mesto>(this.base, mesto);
  }

  update(id: number, fakultet: Mesto) {
    return this.httpClient.put<Mesto>(`${this.base}/${id}`, fakultet);
  }

  delete(id: number) {
    return this.httpClient.delete<Mesto>(`${this.base}/${id}`);
  }
}
