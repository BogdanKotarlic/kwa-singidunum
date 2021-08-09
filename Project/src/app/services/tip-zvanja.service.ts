import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TipZvanja } from '../model/tip-zvanja';

@Injectable({
  providedIn: 'root'
})
export class TipZvanjaService {
  private base: string = "http://localhost:8080/api/tipovizvanja"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<TipZvanja[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<TipZvanja>(`${this.base}/${id}`);
  }

  create(tipZvanja: TipZvanja) {
    return this.httpClient.post<TipZvanja>(this.base, tipZvanja);
  }

  update(id: number, tipZvanja: TipZvanja) {
    return this.httpClient.put<TipZvanja>(`${this.base}/${id}`, tipZvanja);
  }

  delete(id: number) {
    return this.httpClient.delete<TipZvanja>(`${this.base}/${id}`);
  }
}
