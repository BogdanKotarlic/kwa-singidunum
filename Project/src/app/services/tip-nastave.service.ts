import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TipNastave } from '../model/tip-nastave';

@Injectable({
  providedIn: 'root'
})
export class TipNastaveService {
  private base: string = "http://localhost:8080/api/tipovinastave"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<TipNastave[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<TipNastave>(`${this.base}/${id}`);
  }

  create(tipNastave: TipNastave) {
    return this.httpClient.post<TipNastave>(this.base, tipNastave);
  }

  update(id: number, tipNastave: TipNastave) {
    return this.httpClient.put<TipNastave>(`${this.base}/${id}`, tipNastave);
  }

  delete(id: number) {
    return this.httpClient.delete<TipNastave>(`${this.base}/${id}`);
  }
}
