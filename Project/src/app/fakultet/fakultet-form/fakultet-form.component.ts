import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Fakultet } from 'src/app/model/fakultet';
import { StudijskiProgram } from 'src/app/model/studijski-program';
import { Univerzitet } from 'src/app/model/univerzitet';
import { FakultetService } from 'src/app/services/fakultet.service';
import { UniverzitetService } from 'src/app/services/univerzitet.service';

@Component({
  selector: 'app-fakultet-form',
  templateUrl: './fakultet-form.component.html',
  styleUrls: ['./fakultet-form.component.css']
})

export class FakultetFormComponent implements OnInit {
  @Input()
  univerziteti: Univerzitet [] = []

  @Input()
  fakultet: Fakultet|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    univerzitet: new FormControl(null, [Validators.required])
  });

  constructor(private fakultetService: FakultetService, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.fakultet?.id);
    this.form.get("naziv")?.setValue(this.fakultet?.naziv);
    this.form.get("univerzitet")?.setValue({...this.fakultet?.univerzitet});
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
