import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NastavnikNaRealizacijiService } from 'src/app/services/nastavnik-na-realizaciji.service';

@Component({
  selector: 'app-nastavnik-na-realizaciji-details',
  templateUrl: './nastavnik-na-realizaciji-details.component.html',
  styleUrls: ['./nastavnik-na-realizaciji-details.component.css']
})
export class NastavnikNaRealizacijiDetailsComponent implements OnInit {
  nastavnikNaRealizaciji:any = {}

  constructor(private nastavnikNaRealizacijiService: NastavnikNaRealizacijiService 
    ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let nastavnikNaRealizacijiId = Number(this.route.snapshot.paramMap.get("id"));
    this.nastavnikNaRealizacijiService.getOne(nastavnikNaRealizacijiId).subscribe((value:any)=> {
      this.nastavnikNaRealizaciji = value;
      console.log(value)
      
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
