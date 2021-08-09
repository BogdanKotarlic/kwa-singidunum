import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Univerzitet } from '../model/univerzitet';

@Injectable({
  providedIn: 'root'
})
export class UniverzitetService {
  private base: string = "http://localhost:8080/api/univerziteti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Univerzitet[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Univerzitet>(`${this.base}/${id}`);
  }

  create(univerzitet: Univerzitet) {
    return this.httpClient.post<Univerzitet>(this.base, univerzitet);
  }

  update(id: number, univerzitet: Univerzitet) {
    return this.httpClient.put<Univerzitet>(`${this.base}/${id}`, univerzitet);
  }

  delete(id: number) {
    return this.httpClient.delete<Univerzitet>(`${this.base}/${id}`);
  }
}
