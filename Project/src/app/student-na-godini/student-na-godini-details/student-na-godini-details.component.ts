import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentNaGodiniService } from 'src/app/services/student-na-godini.service';

@Component({
  selector: 'app-student-na-godini-details',
  templateUrl: './student-na-godini-details.component.html',
  styleUrls: ['./student-na-godini-details.component.css']
})
export class StudentNaGodiniDetailsComponent implements OnInit {
  studentNaGodini:any = {}

  constructor(private studentNaGodiniService: StudentNaGodiniService ,
    private route: ActivatedRoute, private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    let studentNaGodiniId = Number(this.route.snapshot.paramMap.get("id"));
    this.studentNaGodini = this.studentNaGodiniService.getOne(studentNaGodiniId).subscribe((value:any)=> {
      this.studentNaGodini = value;
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
