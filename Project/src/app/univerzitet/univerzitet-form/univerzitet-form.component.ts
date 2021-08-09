import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresa } from 'src/app/model/adresa';
import { Fakultet } from 'src/app/model/fakultet';
import { Univerzitet } from 'src/app/model/univerzitet';
import { UniverzitetService } from 'src/app/services/univerzitet.service';

@Component({
  selector: 'app-univerzitet-form',
  templateUrl: './univerzitet-form.component.html',
  styleUrls: ['./univerzitet-form.component.css']
})
export class UniverzitetFormComponent implements OnInit, OnChanges {
  @Input()
  adrese: Adresa [] = []

  @Input()
  univerzitet: Univerzitet|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    //id: new FormControl(null, [Validators.required]),
    datumOsnivanja: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    //fakultet: new FormControl(null, [Validators.required])
  });

  constructor(private univerzitetService: UniverzitetService, private router: Router) { }
  ngOnChanges(changes: SimpleChanges): void {
    //this.form.get("id")?.setValue(this.univerzitet?.id);
    this.form.get("datumOsnivanja")?.setValue(this.univerzitet?.datumOsnivanja);
    this.form.get("naziv")?.setValue(this.univerzitet?.naziv);
  }

  ngOnInit(): void {
    console.log(this.univerzitet)
  }

  create() {
    if(this.form.valid) {
      this.createEvent.emit(this.form.value);
    } else {
      console.log("Forma nije validna")
    }
  }

}
