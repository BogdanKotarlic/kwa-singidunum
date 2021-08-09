import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GodinaStudija } from 'src/app/model/godina-studija';
import { StudentNaGodini } from 'src/app/model/student-na-godini';
import { StudijskiProgram } from 'src/app/model/studijski-program';

@Component({
  selector: 'app-godina-studija-form',
  templateUrl: './godina-studija-form.component.html',
  styleUrls: ['./godina-studija-form.component.css']
})
export class GodinaStudijaFormComponent implements OnInit {
  @Input()
  studijskiProgram: StudijskiProgram [] = []
  @Input()
  studentNaGodini: StudentNaGodini [] = []


  @Input()
  godinaStudija: GodinaStudija|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    godina: new FormControl(null, [Validators.required]),
    studijskiProgram: new FormControl(null, [Validators.required]),
    studentNaGodini: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.godinaStudija?.id);
    this.form.get("godina")?.setValue(this.godinaStudija?.godina);
    this.form.get("studijskiProgram")?.setValue({...this.godinaStudija?.studijskiProgram});
    this.form.get("studentNaGodini")?.setValue({...this.godinaStudija?.studentNaGodini});
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
