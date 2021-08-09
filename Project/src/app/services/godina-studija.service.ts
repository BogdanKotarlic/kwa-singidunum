import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GodinaStudija } from '../model/godina-studija';

@Injectable({
  providedIn: 'root'
})
export class GodinaStudijaService {
  private base: string = "http://localhost:8080/api/godinestudija"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<GodinaStudija[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<GodinaStudija>(`${this.base}/${id}`);
  }

  create(godinaStudija: GodinaStudija) {
    return this.httpClient.post<GodinaStudija>(this.base, godinaStudija);
  }

  update(id: number, godinaStudija: GodinaStudija) {
    return this.httpClient.put<GodinaStudija>(`${this.base}/${id}`, godinaStudija);
  }

  delete(id: number) {
    return this.httpClient.delete<GodinaStudija>(`${this.base}/${id}`);
  }
}
