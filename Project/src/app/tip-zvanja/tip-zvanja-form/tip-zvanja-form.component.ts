import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TipZvanja } from 'src/app/model/tip-zvanja';
import { Zvanje } from 'src/app/model/zvanje';

@Component({
  selector: 'app-tip-zvanja-form',
  templateUrl: './tip-zvanja-form.component.html',
  styleUrls: ['./tip-zvanja-form.component.css']
})
export class TipZvanjaFormComponent implements OnInit {
  @Input()
  zvanje: Zvanje[] = [];

  @Input()
  tipZvanja: TipZvanja|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    zvanje: new FormControl(null, [Validators.required])
  });

  constructor(private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.tipZvanja?.id);
    this.form.get("naziv")?.setValue(this.tipZvanja?.naziv);
    this.form.get("zvanje")?.setValue(this.tipZvanja?.zvanje);
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
