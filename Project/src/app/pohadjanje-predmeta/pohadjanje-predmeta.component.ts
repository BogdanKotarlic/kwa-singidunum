import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PohadjanjePredmeta } from '../model/pohadjanje-predmeta';
import { Student } from '../model/student';
import { PohadjanjePredmetaService } from '../services/pohadjanje-predmeta.service';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-pohadjanje-predmeta',
  templateUrl: './pohadjanje-predmeta.component.html',
  styleUrls: ['./pohadjanje-predmeta.component.css']
})
export class PohadjanjePredmetaComponent implements OnInit {
  studenti: Student [] = [];
  pohadjanjePredmeta: PohadjanjePredmeta [] = [];
  pohadjanjePredmetaUpdate: PohadjanjePredmeta|null = null;
  
  constructor(private pohadjanjePredmetaService: PohadjanjePredmetaService, private studentService: StudentService
    , private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.studentService.getAll().subscribe((value) => {
      this.studenti = value;
    }, (error) => 
    console.log(error))
  }

  getAll() {
    this.pohadjanjePredmetaService.getAll().subscribe((value) => {
      this.pohadjanjePredmeta = value; 
      debugger;
      console.log(this.pohadjanjePredmeta)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.pohadjanjePredmetaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(pohadjanjePredmeta: PohadjanjePredmeta) {
    this.pohadjanjePredmetaService.create(pohadjanjePredmeta).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(pohadjanjePredmeta: PohadjanjePredmeta) {
    if(this.pohadjanjePredmetaUpdate && this.pohadjanjePredmetaUpdate.id) {
      this.pohadjanjePredmetaService.update(this.pohadjanjePredmetaUpdate?.id, pohadjanjePredmeta).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(pohadjanjePredmeta: any) {
    this.pohadjanjePredmetaUpdate = { ...pohadjanjePredmeta };
  }

  prikaziDetalje(pohadjanjePredmeta: PohadjanjePredmeta) {
    this.router.navigate(["pohadjanjepredmeta", "/", {id: pohadjanjePredmeta.id}])
  }
}
