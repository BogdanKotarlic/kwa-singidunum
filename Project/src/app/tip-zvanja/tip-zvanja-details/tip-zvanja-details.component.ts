import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TipZvanjaService } from 'src/app/services/tip-zvanja.service';

@Component({
  selector: 'app-tip-zvanja-details',
  templateUrl: './tip-zvanja-details.component.html',
  styleUrls: ['./tip-zvanja-details.component.css']
})
export class TipZvanjaDetailsComponent implements OnInit {
  tipZvanja:any = {}

  constructor(private tipZvanjaService: TipZvanjaService ,
    private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let tipZvanjaId = Number(this.route.snapshot.paramMap.get("id"));
    this.tipZvanja = this.tipZvanjaService.getOne(tipZvanjaId).subscribe((value:any)=> {
      this.tipZvanja = value;
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
