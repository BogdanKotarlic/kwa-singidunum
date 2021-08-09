import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresa } from '../model/adresa';
import { Fakultet } from '../model/fakultet';
import { Nastavnik } from '../model/nastavnik';
import { Student } from '../model/student';
import { Univerzitet } from '../model/univerzitet';
import { AdresaService } from '../services/adresa.service';
import { FakultetService } from '../services/fakultet.service';
import { NastavnikService } from '../services/nastavnik.service';
import { StudentService } from '../services/student.service';
import { UniverzitetService } from '../services/univerzitet.service';

@Component({
  selector: 'app-adresa',
  templateUrl: './adresa.component.html',
  styleUrls: ['./adresa.component.css']
})
export class AdresaComponent implements OnInit {
  fakultet: Fakultet[] = []
  univerzitet: Univerzitet[] = []
  student: Student[] = []
  nastavnik: Nastavnik[] = []

  adrese: Adresa [] = [];
  adresaUpdate: Adresa|null = null;
  
  constructor(private adresaService: AdresaService, private router: Router,
    private fakultetService: FakultetService, private univerzitetService: UniverzitetService,
    private studentService: StudentService, private nastavnikService: NastavnikService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
    this.getAll4();
    this.getAll5();
  }

  getAll3() {
    this.univerzitetService.getAll().subscribe((value) => {
      this.univerzitet = value;
      console.log(value)
      console.log("UNVIERZITET")
    }, (error) => 
    console.log(error))
  }

  getAll4() {
    this.studentService.getAll().subscribe((value) => {
      this.student = value;
    }, (error) => 
    console.log(error))
  }

  getAll5() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
    }, (error) => 
    console.log(error))
  }


  getAll2() {
    this.fakultetService.getAll().subscribe((value) => {
      this.fakultet = value;
    }, (error) => 
    console.log(error))
  }

  getAll() {
    this.adresaService.getAll().subscribe((value) => {
      this.adrese = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.adresaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(adrese: Adresa) {
    this.adresaService.create(adrese).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(adrese: Adresa) {
    if(this.adresaUpdate && this.adresaUpdate.id) {
      this.adresaService.update(this.adresaUpdate?.id, adrese).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(adrese: any) {
    this.adresaUpdate = { ...adrese };
  }

  prikaziDetalje(adrese: Adresa) {
    this.router.navigate(["adrese", "/", {id: adrese.id}])
  }
}
