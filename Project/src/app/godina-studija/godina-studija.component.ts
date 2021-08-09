import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GodinaStudija } from '../model/godina-studija';
import { StudentNaGodini } from '../model/student-na-godini';
import { StudijskiProgram } from '../model/studijski-program';
import { GodinaStudijaService } from '../services/godina-studija.service';
import { StudentNaGodiniService } from '../services/student-na-godini.service';
import { StudijskiProgramService } from '../services/studijski-program.service';

@Component({
  selector: 'app-godina-studija',
  templateUrl: './godina-studija.component.html',
  styleUrls: ['./godina-studija.component.css']
})
export class GodinaStudijaComponent implements OnInit {
  studijskiProgram: StudijskiProgram [] = [];
  studentNaGodini: StudentNaGodini [] = [];

  godinaStudija: GodinaStudija [] = [];
  godinaStudijaUpdate: GodinaStudija|null = null;
  
  constructor(private godinaStudijaService: GodinaStudijaService, 
    private studijskiProgramService: StudijskiProgramService, 
    private studentNaGodiniService: StudentNaGodiniService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
  }

  getAll3() {
    this.godinaStudijaService.getAll().subscribe((value) => {
      this.godinaStudija = value;
    }, (error) => 
    console.log(error))
  }

  getAll2() {
    this.studijskiProgramService.getAll().subscribe((value) => {
      this.studijskiProgram = value;
    }, (error) => 
    console.log(error))
  }

  getAll() {
    this.studentNaGodiniService.getAll().subscribe((value) => {
      this.studentNaGodini = value;
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.godinaStudijaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(godinaStudija: GodinaStudija) {
    this.godinaStudijaService.create(godinaStudija).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(godinaStudija: GodinaStudija) {
    if(this.godinaStudijaUpdate && this.godinaStudijaUpdate.id) {
      this.godinaStudijaService.update(this.godinaStudijaUpdate?.id, godinaStudija).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(godinaStudija: any) {
    this.godinaStudijaUpdate = { ...godinaStudija };
  }

  prikaziDetalje(godinaStudija: GodinaStudija) {
    this.router.navigate(["godinestudija", "/", {id: godinaStudija.id}])
  }
}
