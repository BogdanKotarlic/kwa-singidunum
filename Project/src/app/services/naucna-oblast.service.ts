import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NaucnaOblast } from '../model/naucna-oblast';

@Injectable({
  providedIn: 'root'
})
export class NaucnaOblastService {
  private base: string = "http://localhost:8080/api/naucneoblasti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<NaucnaOblast[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<NaucnaOblast>(`${this.base}/${id}`);
  }

  create(naucnaOblast: NaucnaOblast) {
    return this.httpClient.post<NaucnaOblast>(this.base, naucnaOblast);
  }

  update(id: number, naucnaOblast: NaucnaOblast) {
    return this.httpClient.put<NaucnaOblast>(`${this.base}/${id}`, naucnaOblast);
  }

  delete(id: number) {
    return this.httpClient.delete<NaucnaOblast>(`${this.base}/${id}`);
  }
}
