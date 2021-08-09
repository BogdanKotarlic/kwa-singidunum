import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NastavnikNaRealizaciji } from '../model/nastavnik-na-realizaciji';
import { TipNastave } from '../model/tip-nastave';
import { NastavnikNaRealizacijiService } from '../services/nastavnik-na-realizaciji.service';
import { TipNastaveService } from '../services/tip-nastave.service';

@Component({
  selector: 'app-tip-nastave',
  templateUrl: './tip-nastave.component.html',
  styleUrls: ['./tip-nastave.component.css']
})
export class TipNastaveComponent implements OnInit {
  nastavniciNaRealizaciji: NastavnikNaRealizaciji [] = [];

  tipoviNastave: TipNastave [] = [];
  tipoviNastaveUpdate: TipNastave|null = null;
  
  constructor(private tipNastaveService: TipNastaveService, 
    private nastavnikNaRealizacijiService: NastavnikNaRealizacijiService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.nastavnikNaRealizacijiService.getAll().subscribe((value) => {
      this.nastavniciNaRealizaciji = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.tipNastaveService.getAll().subscribe((value) => {
      this.tipoviNastave = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.tipNastaveService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(tipoviNastave: TipNastave) {
    this.tipNastaveService.create(tipoviNastave).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(tipoviNastave: TipNastave) {
    if(this.tipoviNastaveUpdate && this.tipoviNastaveUpdate.id) {
      this.tipNastaveService.update(this.tipoviNastaveUpdate?.id, tipoviNastave).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(tipNastave: any) {
    this.tipoviNastaveUpdate = { ...tipNastave };
  }

  prikaziDetalje(tipNastave: TipNastave) {
    this.router.navigate(["tipovinastave", "/", {id: tipNastave.id}])
  }
}
