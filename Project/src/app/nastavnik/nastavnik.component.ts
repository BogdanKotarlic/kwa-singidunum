import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fakultet } from '../model/fakultet';
import { Nastavnik } from '../model/nastavnik';
import { Predmet } from '../model/predmet';
import { StudijskiProgram } from '../model/studijski-program';
import { FakultetService } from '../services/fakultet.service';
import { NastavnikService } from '../services/nastavnik.service';
import { PredmetService } from '../services/predmet.service';
import { StudijskiProgramService } from '../services/studijski-program.service';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit {
  predmet: Predmet [] = [];
  fakultet: Fakultet [] = [];
  studijskiProgram: StudijskiProgram [] = [];

  nastavnik: Nastavnik[] = [];
  nastavnikUpdate: Nastavnik|null = null;

  constructor(private predmetService: PredmetService, 
    private router: Router, private fakultetService: FakultetService, 
    private nastavnikService: NastavnikService, private studijskiProgramService: StudijskiProgramService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
    this.getAll4();
  }

  getAll3() {
    this.fakultetService.getAll().subscribe((value) => {
      this.fakultet = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll4() {
    this.studijskiProgramService.getAll().subscribe((value) => {
      this.studijskiProgram = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll2() {
    this.predmetService.getAll().subscribe((value) => {
      this.predmet = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.nastavnikService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(nastavnik: Nastavnik) {
    this.nastavnikService.create(nastavnik).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(nastavnik: Nastavnik) {
    if(this.nastavnikUpdate && this.nastavnikUpdate.id) {
      this.nastavnikService.update(this.nastavnikUpdate?.id, nastavnik).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }    
  }

  setUpdate(nastavnik: any) {
    this.nastavnikUpdate = { ...nastavnik };
  }

  prikaziDetalje(nastavnik: Nastavnik) {
    this.router.navigate(["nastavnici", "/", {id: nastavnik.id}])
  }
}
