import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Fakultet } from 'src/app/model/fakultet';
import { StudijskiProgram } from 'src/app/model/studijski-program';
import { FakultetService } from 'src/app/services/fakultet.service';
import { StudijskiProgramService } from 'src/app/services/studijski-program.service';

@Component({
  selector: 'app-studijski-program-form',
  templateUrl: './studijski-program-form.component.html',
  styleUrls: ['./studijski-program-form.component.css']
})
export class StudijskiProgramFormComponent implements OnInit {
  @Input()
  fakulteti: Fakultet [] = []

  @Input()
  studijskiProgram: StudijskiProgram|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    naziv: new FormControl(null, [Validators.required]),
    fakultet: new FormControl(null, [Validators.required])
  });

  constructor(private studijskiProgramService: StudijskiProgramService, private router: Router, public fakultetService: FakultetService) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("naziv")?.setValue(this.studijskiProgram?.naziv);
    this.form.get("fakultet")?.setValue({...this.studijskiProgram?.fakultet});
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
