import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GodinaStudija } from 'src/app/model/godina-studija';
import { PohadjanjePredmeta } from 'src/app/model/pohadjanje-predmeta';
import { Predmet } from 'src/app/model/predmet';
import { PredmetService } from 'src/app/services/predmet.service';

@Component({
  selector: 'app-predmet-form',
  templateUrl: './predmet-form.component.html',
  styleUrls: ['./predmet-form.component.css']
})
export class PredmetFormComponent implements OnInit {
  @Input()
  pohadjanjePredmeta: PohadjanjePredmeta [] = []

  @Input()
  godinaStudija: GodinaStudija [] = []

  @Input()
  predmet: Predmet|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    brojPredavanja: new FormControl(null, [Validators.required]),
    brojVezbi: new FormControl(null, [Validators.required]),
    drugiObliciNastave: new FormControl(null, [Validators.required]),
    espb: new FormControl(null, [Validators.required]),
    istrazivackiRad: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    obavezan: new FormControl(null, [Validators.required]),
    ostaliCasovi: new FormControl(null, [Validators.required]),
    godinaStudija: new FormControl(null, [Validators.required]),
    pohadjanjePredmeta: new FormControl(null, [Validators.required])
  });

  constructor(private predmetService: PredmetService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.predmet?.id);
    this.form.get("brojPredavanja")?.setValue(this.predmet?.brojPredavanja);
    this.form.get("brojVezbi")?.setValue(this.predmet?.brojVezbi);
    this.form.get("drugiObliciNastave")?.setValue(this.predmet?.drugiObliciNastave);
    this.form.get("espb")?.setValue(this.predmet?.espb);
    this.form.get("istrazivackiRad")?.setValue(this.predmet?.istrazivackiRad);
    this.form.get("naziv")?.setValue(this.predmet?.naziv);
    this.form.get("obavezan")?.setValue(this.predmet?.obavezan);
    this.form.get("ostaliCasovi")?.setValue(this.predmet?.ostaliCasovi);
    this.form.get("godinaStudija")?.setValue({...this.predmet?.godinaStudija});
    this.form.get("pohadjanjePredmeta")?.setValue({...this.predmet?.pohadjanjePredmeta});
    console.log(this.godinaStudija)
  }

  ngOnInit(): void {
    
   }

  create() {
    if(this.form.valid) {
      console.log(this.form.value)
      this.createEvent.emit(this.form.value); 
      
      console.log(this.form.value)
      
    } else {
      console.log("Forma nije validna")
    }
  }
}
