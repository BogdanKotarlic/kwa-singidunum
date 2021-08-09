import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdresaDetailsComponent } from './adresa/adresa-details/adresa-details.component';
import { AdresaComponent } from './adresa/adresa.component';
import { FakultetDetailsComponent } from './fakultet/fakultet-details/fakultet-details.component';
import { FakultetComponent } from './fakultet/fakultet.component';
import { GodinaStudijaDetailsComponent } from './godina-studija/godina-studija-details/godina-studija-details.component';
import { GodinaStudijaComponent } from './godina-studija/godina-studija.component';
import { HomeComponent } from './home/home.component';
import { MestoDetailsComponent } from './mesto/mesto-details/mesto-details.component';
import { MestoComponent } from './mesto/mesto.component';
import { NastavnikNaRealizacijiDetailsComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji-details/nastavnik-na-realizaciji-details.component';
import { NastavnikNaRealizacijiComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji.component';
import { NastavnikDetailsComponent } from './nastavnik/nastavnik-details/nastavnik-details.component';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { NaucnaOblastDetailsComponent } from './naucna-oblast/naucna-oblast-details/naucna-oblast-details.component';
import { NaucnaOblastComponent } from './naucna-oblast/naucna-oblast.component';
import { PohadjanjePredmetaDetailsComponent } from './pohadjanje-predmeta/pohadjanje-predmeta-details/pohadjanje-predmeta-details.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { PredmetDetailsComponent } from './predmet/predmet-details/predmet-details.component';
import { PredmetComponent } from './predmet/predmet.component';
import { StudentNaGodiniDetailsComponent } from './student-na-godini/student-na-godini-details/student-na-godini-details.component';
import { StudentNaGodiniComponent } from './student-na-godini/student-na-godini.component';
import { StudentDetailsComponent } from './student/student-details/student-details.component';
import { StudentComponent } from './student/student.component';
import { StudijskiProgramDetailsComponent } from './studijski-program/studijski-program-details/studijski-program-details.component';
import { StudijskiProgramComponent } from './studijski-program/studijski-program.component';
import { TipNastaveDetailsComponent } from './tip-nastave/tip-nastave-details/tip-nastave-details.component';
import { TipNastaveComponent } from './tip-nastave/tip-nastave.component';
import { TipZvanjaDetailsComponent } from './tip-zvanja/tip-zvanja-details/tip-zvanja-details.component';
import { TipZvanjaComponent } from './tip-zvanja/tip-zvanja.component';
import { UniverzitetDetailsComponent } from './univerzitet/univerzitet-details/univerzitet-details.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';
import { ZvanjeDetailsComponent } from './zvanje/zvanje-details/zvanje-details.component';
import { ZvanjeComponent } from './zvanje/zvanje.component';

const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "univerziteti", component: UniverzitetComponent},
  {path: "univerziteti/:id", component: UniverzitetDetailsComponent}, // Tabela za prikaz univerziteta
  {path: "fakulteti", component: FakultetComponent},
  {path: "fakulteti/:id", component: FakultetDetailsComponent},
  {path: "studenti", component: StudentComponent},
  {path: "studenti/:id", component: StudentDetailsComponent},
  {path: "studijski_programi", component: StudijskiProgramComponent},
  {path: "studijski_programi/:id", component: StudijskiProgramDetailsComponent},
  {path: "mesta", component: MestoComponent},
  {path: "mesta/:id", component: MestoDetailsComponent},
  {path: "adrese", component: AdresaComponent},
  {path: "adrese/:id", component: AdresaDetailsComponent},
  {path: "predmeti", component: PredmetComponent},
  {path: "predmeti/:id", component: PredmetDetailsComponent},
  {path: "pohadjanjepredmeta", component: PohadjanjePredmetaComponent},
  {path: "pohadjanjepredmeta/:id", component: PohadjanjePredmetaDetailsComponent},
  {path: "nastavnicinarealizaciji", component: NastavnikNaRealizacijiComponent},
  {path: "nastavnicinarealizaciji/:id", component: NastavnikNaRealizacijiDetailsComponent},
  {path: "tipovinastave", component: TipNastaveComponent},
  {path: "tipovinastave/:id", component: TipNastaveDetailsComponent},
  {path: "studentinagodini", component: StudentNaGodiniComponent},
  {path: "studentinagodini/:id", component: StudentNaGodiniDetailsComponent},
  {path: "godinestudija", component: GodinaStudijaComponent},
  {path: "godinestudija/:id", component: GodinaStudijaDetailsComponent},
  {path: "zvanja", component: ZvanjeComponent},
  {path: "zvanja/:id", component: ZvanjeDetailsComponent},
  {path: "tipzvanja", component: TipZvanjaComponent},
  {path: "tipzvanja/:id", component: TipZvanjaDetailsComponent},
  {path: "naucneoblasti", component: NaucnaOblastComponent},
  {path: "naucneoblasti/:id", component: NaucnaOblastDetailsComponent},
  {path: "nastavnici", component: NastavnikComponent},
  {path: "nastavnici/:id", component: NastavnikDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
