import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NaucnaOblastService } from 'src/app/services/naucna-oblast.service';

@Component({
  selector: 'app-naucna-oblast-details',
  templateUrl: './naucna-oblast-details.component.html',
  styleUrls: ['./naucna-oblast-details.component.css']
})
export class NaucnaOblastDetailsComponent implements OnInit {
  naucnaOblast:any = {}

  constructor(private naucnaOblastService: NaucnaOblastService ,
    private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let naucnaOblastId = Number(this.route.snapshot.paramMap.get("id"));
    this.naucnaOblast = this.naucnaOblastService.getOne(naucnaOblastId).subscribe((value:any)=> {
      this.naucnaOblast = value;
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
