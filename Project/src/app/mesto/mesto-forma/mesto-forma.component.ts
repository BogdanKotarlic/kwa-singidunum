import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresa } from 'src/app/model/adresa';
import { Mesto } from 'src/app/model/mesto';
import { MestoService } from 'src/app/services/mesto.service';

@Component({
  selector: 'app-mesto-forma',
  templateUrl: './mesto-forma.component.html',
  styleUrls: ['./mesto-forma.component.css']
})
export class MestoFormaComponent implements OnInit {
  @Input()
  adrese: Adresa [] = []

  @Input()
  mesto: Mesto|null = null;

  @Output()
  private createEvent: EventEmitter<any> = new EventEmitter<any>();

  form: FormGroup = new FormGroup({
    id: new FormControl(null, [Validators.required]),
    naziv: new FormControl(null, [Validators.required]),
    drzava: new FormControl(null, [Validators.required]),
    adresa: new FormControl(null, [Validators.required])
  });

  constructor(private mestoService: MestoService, private router: Router) { }
  ngOnChanges(changes: SimpleChanges): void {
    this.form.get("id")?.setValue(this.mesto?.id);
    this.form.get("naziv")?.setValue(this.mesto?.naziv);
    this.form.get("drzava")?.setValue(this.mesto?.drzava);
    this.form.get("adresa")?.setValue({...this.mesto?.adresa});
  }

  ngOnInit(): void {
    
  }

  create() {
    if(this.form.valid) {
      this.createEvent.emit(this.form.value);
    } else {
      console.log("Forma nije validna")
    }
  }
}
