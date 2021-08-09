import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ishod } from '../model/ishod';

@Injectable({
  providedIn: 'root'
})
export class IshodService {
  private base: string = "http://localhost:8080/api/ishodi"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Ishod[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Ishod>(`${this.base}/${id}`);
  }

  create(ishod: Ishod) {
    return this.httpClient.post<Ishod>(this.base, ishod);
  }

  update(id: number, ishod: Ishod) {
    return this.httpClient.put<Ishod>(`${this.base}/${id}`, ishod);
  }

  delete(id: number) {
    return this.httpClient.delete<Ishod>(`${this.base}/${id}`);
  }
}
