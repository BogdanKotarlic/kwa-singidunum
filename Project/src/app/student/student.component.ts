import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../model/student';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  studenti: Student[] = [];
  studentUpdate: Student|null = null;

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.studentService.getAll().subscribe((value) => {
      this.studenti = value;
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.studentService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(student: Student) {
    this.studentService.create(student).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(student: Student) {
    if(this.studentUpdate && this.studentUpdate.id) {
      this.studentService.update(this.studentUpdate?.id, student).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(student: any) {
    this.studentUpdate = { ...student };
  }

  prikaziDetalje(student: Student) {
    this.router.navigate(["studenti", "/", {id: student.id}])
  }

}
