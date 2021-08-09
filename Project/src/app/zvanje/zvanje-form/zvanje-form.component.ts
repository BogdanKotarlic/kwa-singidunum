import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Nastavnik } from 'src/app/model/nastavnik';
import { Zvanje } from 'src/app/model/zvanje';
import { ZvanjeService } from 'src/app/services/zvanje.service';

@Component({
  selector: 'app-zvanje-form',
  templateUrl: './zvanje-form.component.html',
  styleUrls: ['./zvanje-form.component.css']
})
export class ZvanjeFormComponent implements OnInit {
  @Input()
  nastavnik: Nastavnik [] = []

  @Input()
  zvanje: Zvanje|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    datumIzbora: new FormControl(null, [Validators.required]),
    datumPrestanka: new FormControl(null, [Validators.required]),
    nastavnik: new FormControl(null, [Validators.required])
  });

  constructor(private zvanjeService: ZvanjeService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.zvanje?.id);
    this.form.get("datumIzbora")?.setValue(this.zvanje?.datumIzbora);
    this.form.get("datumPrestanka")?.setValue(this.zvanje?.datumPrestanka);
    this.form.get("nastavnik")?.setValue({...this.zvanje?.nastavnik});
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
