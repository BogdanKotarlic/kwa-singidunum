import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Fakultet } from 'src/app/model/fakultet';
import { Nastavnik } from 'src/app/model/nastavnik';
import { Predmet } from 'src/app/model/predmet';
import { StudijskiProgram } from 'src/app/model/studijski-program';

@Component({
  selector: 'app-nastavnik-form',
  templateUrl: './nastavnik-form.component.html',
  styleUrls: ['./nastavnik-form.component.css']
})
export class NastavnikFormComponent implements OnInit {
  @Input()
  predmet: Predmet [] = []

  @Input()
  fakultet: Fakultet [] = []

  @Input()
  studijskiProgram: StudijskiProgram [] = []

  @Input()
  nastavnik: Nastavnik|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    ime: new FormControl(null, [Validators.required]),
    biografija: new FormControl(null, [Validators.required]),
    jmbg: new FormControl(null, [Validators.required]),
    predmet: new FormControl(null, [Validators.required]),
    fakultet: new FormControl(null, [Validators.required]),
    studijskiProgram: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }
  
  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.nastavnik?.id);
    this.form.get("ime")?.setValue(this.nastavnik?.ime);
    this.form.get("biografija")?.setValue(this.nastavnik?.biografija);
    this.form.get("jmbg")?.setValue(this.nastavnik?.jmbg);
    this.form.get("predmet")?.setValue({...this.nastavnik?.predmet});
    this.form.get("fakultet")?.setValue({...this.nastavnik?.fakultet});
    this.form.get("studijskiProgram")?.setValue({...this.nastavnik?.studijskiProgram});
  }

  ngOnInit(): void {
  }

  create() {
    if(this.form.valid) {
      this.createEvent.emit(this.form.value);
      console.log(this.form.value)
    } else {
      console.log("Forma nije validna")
    }
  }
}
