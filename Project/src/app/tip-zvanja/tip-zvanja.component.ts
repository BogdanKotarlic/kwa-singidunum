import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipZvanja } from '../model/tip-zvanja';
import { Zvanje } from '../model/zvanje';
import { TipZvanjaService } from '../services/tip-zvanja.service';
import { ZvanjeService } from '../services/zvanje.service';

@Component({
  selector: 'app-tip-zvanja',
  templateUrl: './tip-zvanja.component.html',
  styleUrls: ['./tip-zvanja.component.css']
})
export class TipZvanjaComponent implements OnInit {
  zvanje: Zvanje [] = [];
  tipZvanja: TipZvanja [] = [];
  tipZvanjaUpdate: TipZvanja|null = null;
  
  constructor(private zvanjeService: ZvanjeService, private tipZvanjaService: TipZvanjaService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }

  getAll2() {
    this.zvanjeService.getAll().subscribe((value) => {
      this.zvanje = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.tipZvanjaService.getAll().subscribe((value) => {
      this.tipZvanja = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.tipZvanjaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(tipZvanja: TipZvanja) {
    this.tipZvanjaService.create(tipZvanja).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(tipZvanja: TipZvanja) {
    if(this.tipZvanjaUpdate && this.tipZvanjaUpdate.id) {
      this.tipZvanjaService.update(this.tipZvanjaUpdate?.id, tipZvanja).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(tipZvanja: any) {
    this.tipZvanjaUpdate = { ...tipZvanja };
  }

  prikaziDetalje(tipZvanja: TipZvanja) {
    this.router.navigate(["tipzvanja", "/", {id: tipZvanja.id}])
  }
}
