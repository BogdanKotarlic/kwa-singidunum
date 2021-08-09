import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudentNaGodini } from 'src/app/model/student-na-godini';
import { StudijskiProgramService } from 'src/app/services/studijski-program.service';

@Component({
  selector: 'app-student-na-godini-form',
  templateUrl: './student-na-godini-form.component.html',
  styleUrls: ['./student-na-godini-form.component.css']
})
export class StudentNaGodiniFormComponent implements OnInit {
  @Input()
  student: Student [] = []

  @Input()
  studentNaGodini: StudentNaGodini|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    datumUpisa: new FormControl(null, [Validators.required]),
    brojIndeksa: new FormControl(null, [Validators.required]),
    student: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.studentNaGodini?.id);
    this.form.get("datumUpisa")?.setValue(this.studentNaGodini?.datumUpisa);
    this.form.get("brojIndeksa")?.setValue(this.studentNaGodini?.brojIndeksa);
    this.form.get("student")?.setValue({...this.studentNaGodini?.student});
  }

  ngOnInit(): void {
    
   }

  create() {
    if(this.form.valid) {
      console.log(this.form.value)
      this.createEvent.emit(this.form.value); 
      
    } else {
      console.log("Forma nije validna")
    }
  }
}
