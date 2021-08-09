import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  univerziteti() {
    this.router.navigate(["univerziteti"]);
  }

  fakulteti() {
    this.router.navigate(["fakulteti"]);
  }

  studenti() {
    this.router.navigate(["studenti"]);
  }

  studijskiProgram(){
    this.router.navigate(["studijski_programi"]);
  }

  mesto(){
    this.router.navigate(["mesta"]);
  }

  adresa(){
    this.router.navigate(["adrese"]);
  }

  predmet(){
    this.router.navigate(["predmeti"]);
  }

  pohadjanjePredmeta(){
    this.router.navigate(["pohadjanjepredmeta"]);
  }

  nastavnikNaRealizaciji(){
    this.router.navigate(["nastavnicinarealizaciji"]);
  }

  tipNastave(){
    this.router.navigate(["tipovinastave"]);
  }

  studentNaGodini(){
    this.router.navigate(["studentinagodini"]);
  }

  godinaStudija(){
    this.router.navigate(["godinestudija"]);
  }

  zvanje(){
    this.router.navigate(["zvanja"]);
  }

  tipZvanja(){
    this.router.navigate(["tipzvanja"]);
  }

  naucnaOblast(){
    this.router.navigate(["naucneoblasti"]);
  }

  nastavnik(){
    this.router.navigate(["nastavnici"]);
  }
}
