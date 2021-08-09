import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../model/student';
import { StudentNaGodini } from '../model/student-na-godini';
import { StudentNaGodiniService } from '../services/student-na-godini.service';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-student-na-godini',
  templateUrl: './student-na-godini.component.html',
  styleUrls: ['./student-na-godini.component.css']
})
export class StudentNaGodiniComponent implements OnInit {
  student: Student [] = [];

  studentNaGodini: StudentNaGodini [] = [];
  studentNaGodiniUpdate: StudentNaGodini|null = null;
  
  constructor(private studentNaGodiniService: StudentNaGodiniService, private studentService: StudentService,
     private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.studentService.getAll().subscribe((value) => {
      this.student = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.studentNaGodiniService.getAll().subscribe((value) => {
      this.studentNaGodini = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.studentNaGodiniService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(studentNaGodini: StudentNaGodini) {
    this.studentNaGodiniService.create(studentNaGodini).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(studentNaGodini: StudentNaGodini) {
    if(this.studentNaGodiniUpdate && this.studentNaGodiniUpdate.id) {
      this.studentNaGodiniService.update(this.studentNaGodiniUpdate?.id, studentNaGodini).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(studentNaGodini: any) {
    this.studentNaGodiniUpdate = { ...studentNaGodini };
  }

  prikaziDetalje(studentNaGodini: StudentNaGodini) {
    this.router.navigate(["studentinagodini", "/", {id: studentNaGodini.id}])
  }
}
