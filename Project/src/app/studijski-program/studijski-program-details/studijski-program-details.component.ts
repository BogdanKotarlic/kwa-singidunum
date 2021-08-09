import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudijskiProgramService } from 'src/app/services/studijski-program.service';

@Component({
  selector: 'app-studijski-program-details',
  templateUrl: './studijski-program-details.component.html',
  styleUrls: ['./studijski-program-details.component.css']
})
export class StudijskiProgramDetailsComponent implements OnInit {
  studijskiProgram:any = {}

  constructor(private studijskiProgramService: StudijskiProgramService ,private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let studijskiProgramId = Number(this.route.snapshot.paramMap.get("id"));
    this.studijskiProgram = this.studijskiProgramService.getOne(studijskiProgramId).subscribe((value:any)=> {
      this.studijskiProgram = value;
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
