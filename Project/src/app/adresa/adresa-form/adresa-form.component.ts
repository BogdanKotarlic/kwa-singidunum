import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresa } from 'src/app/model/adresa';
import { Fakultet } from 'src/app/model/fakultet';
import { Nastavnik } from 'src/app/model/nastavnik';
import { Student } from 'src/app/model/student';
import { Univerzitet } from 'src/app/model/univerzitet';

@Component({
  selector: 'app-adresa-form',
  templateUrl: './adresa-form.component.html',
  styleUrls: ['./adresa-form.component.css']
})
export class AdresaFormComponent implements OnInit {
  @Input()
  univerzitet: Univerzitet [] = []

  @Input()
  nastavnik: Nastavnik [] = []

  @Input()
  student: Student [] = []
  
  @Input()
  fakultet: Fakultet [] = []

  @Input()
  adrese: Adresa|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    ulica: new FormControl(null, [Validators.required]),
    broj: new FormControl(null, [Validators.required]),
    fakultet: new FormControl(null, [Validators.required]),
    univerzitet: new FormControl(null, [Validators.required]),
    student: new FormControl(null, [Validators.required]),
    nastavnik: new FormControl(null, [Validators.required]),
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.adrese?.id);
    this.form.get("ulica")?.setValue(this.adrese?.ulica);
    this.form.get("broj")?.setValue(this.adrese?.broj);
    this.form.get("fakultet")?.setValue({...this.adrese?.fakultet});
    this.form.get("univerzitet")?.setValue({...this.adrese?.univerzitet});
    this.form.get("student")?.setValue({...this.adrese?.student});
    this.form.get("nastavnik")?.setValue({...this.adrese?.nastavnik});
    console.log(this.fakultet)
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
