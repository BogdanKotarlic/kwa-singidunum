import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fakultet } from '../model/fakultet';
import { StudijskiProgram } from '../model/studijski-program';
import { FakultetService } from '../services/fakultet.service';
import { StudijskiProgramService } from '../services/studijski-program.service';

@Component({
  selector: 'app-studijski-program',
  templateUrl: './studijski-program.component.html',
  styleUrls: ['./studijski-program.component.css']
})
export class StudijskiProgramComponent implements OnInit {
  fakulteti: Fakultet [] = [];
  studijskiProgram: StudijskiProgram [] = [];
  studijskiProgramUpdate: StudijskiProgram|null = null;
  
  constructor(private studijskiProgramService: StudijskiProgramService, private fakultetService: FakultetService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.fakultetService.getAll().subscribe((value) => {
      this.fakulteti = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.studijskiProgramService.getAll().subscribe((value) => {
      this.studijskiProgram = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.studijskiProgramService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(studijskiProgram: StudijskiProgram) {
    this.studijskiProgramService.create(studijskiProgram).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(studijskiProgram: StudijskiProgram) {
    if(this.studijskiProgramUpdate && this.studijskiProgramUpdate.id) {
      this.studijskiProgramService.update(this.studijskiProgramUpdate?.id, studijskiProgram).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(studijskiProgram: any) {
    this.studijskiProgramUpdate = { ...studijskiProgram };
  }

  prikaziDetalje(studijskiProgram: StudijskiProgram) {
    this.router.navigate(["studijski_programi", "/", {id: studijskiProgram.id}])
  }
}
