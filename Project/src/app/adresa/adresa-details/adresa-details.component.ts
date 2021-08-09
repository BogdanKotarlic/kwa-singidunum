import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdresaService } from 'src/app/services/adresa.service';

@Component({
  selector: 'app-adresa-details',
  templateUrl: './adresa-details.component.html',
  styleUrls: ['./adresa-details.component.css']
})
export class AdresaDetailsComponent implements OnInit {
  adresa:any = {}

  constructor(private adresaService: AdresaService ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let adresaId = Number(this.route.snapshot.paramMap.get("id"));
    this.adresaService.getOne(adresaId).subscribe((value:any)=> {
      this.adresa = value;
      
    }, (error)=> {
      console.log(error);
      this.router.navigate(["home"]); 
      // na klik dugmeta se pozove metoda sa ovim sadrzajem i promeni na stranicu novu
    });
  }

  back() {
    this.location.back();
  }
}
