import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {
  @Input()
  student: Student|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    ime: new FormControl(null, [Validators.required]),
    jmbg: new FormControl(null, [Validators.required])
  });

  constructor(private studentService: StudentService, private router: Router) { }
  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.student?.id);
    this.form.get("ime")?.setValue(this.student?.ime);
    this.form.get("jmbg")?.setValue(this.student?.jmbg);
  }

  ngOnInit(): void {
    
  }

  create() {
    if(this.form.valid) {
      this.createEvent.emit(this.form.value);
    } else {
      console.log("Forma nije validna")
    }
  }
}
