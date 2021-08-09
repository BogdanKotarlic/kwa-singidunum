import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Nastavnik } from 'src/app/model/nastavnik';
import { NastavnikNaRealizaciji } from 'src/app/model/nastavnik-na-realizaciji';
import { NastavnikNaRealizacijiService } from 'src/app/services/nastavnik-na-realizaciji.service';

@Component({
  selector: 'app-nastavnik-na-realizaciji-form',
  templateUrl: './nastavnik-na-realizaciji-form.component.html',
  styleUrls: ['./nastavnik-na-realizaciji-form.component.css']
})
export class NastavnikNaRealizacijiFormComponent implements OnInit {
  @Input()
  nastavnici: Nastavnik [] = []

  @Input()
  nastavniciNaRealizaciji: NastavnikNaRealizaciji|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    brojCasova: new FormControl(null, [Validators.required]),
    nastavnik: new FormControl(null, [Validators.required])
  });

  constructor(private nastavnikNaRealizacijiService: NastavnikNaRealizacijiService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.nastavniciNaRealizaciji?.id);
    this.form.get("brojCasova")?.setValue(this.nastavniciNaRealizaciji?.brojCasova);
    this.form.get("nastavnik")?.setValue({...this.nastavniciNaRealizaciji?.nastavnik});
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
