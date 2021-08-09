import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NaucnaOblast } from 'src/app/model/naucna-oblast';
import { Zvanje } from 'src/app/model/zvanje';

@Component({
  selector: 'app-naucna-oblast-form',
  templateUrl: './naucna-oblast-form.component.html',
  styleUrls: ['./naucna-oblast-form.component.css']
})
export class NaucnaOblastFormComponent implements OnInit {
  @Input()
  zvanje: Zvanje[] = [];

  @Input()
  naucnaOblast: NaucnaOblast|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    zvanje: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.naucnaOblast?.id);
    this.form.get("naziv")?.setValue(this.naucnaOblast?.naziv);
    this.form.get("zvanje")?.setValue(this.naucnaOblast?.zvanje);
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
