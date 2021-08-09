import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';
import { FakultetComponent } from './fakultet/fakultet.component';
import { HomeComponent } from './home/home.component';
import { UniverzitetFormComponent } from './univerzitet/univerzitet-form/univerzitet-form.component';
import { UniverzitetDetailsComponent } from './univerzitet/univerzitet-details/univerzitet-details.component';
import { FakultetDetailsComponent } from './fakultet/fakultet-details/fakultet-details.component';
import { FakultetFormComponent } from './fakultet/fakultet-form/fakultet-form.component';
import { StudentComponent } from './student/student.component';
import { StudentDetailsComponent } from './student/student-details/student-details.component';
import { StudentFormComponent } from './student/student-form/student-form.component';
import { StudijskiProgramComponent } from './studijski-program/studijski-program.component';
import { StudijskiProgramDetailsComponent } from './studijski-program/studijski-program-details/studijski-program-details.component';
import { StudijskiProgramFormComponent } from './studijski-program/studijski-program-form/studijski-program-form.component';
import { MestoComponent } from './mesto/mesto.component';
import { MestoFormaComponent } from './mesto/mesto-forma/mesto-forma.component';
import { MestoDetailsComponent } from './mesto/mesto-details/mesto-details.component';
import { AdresaComponent } from './adresa/adresa.component';
import { AdresaFormComponent } from './adresa/adresa-form/adresa-form.component';
import { AdresaDetailsComponent } from './adresa/adresa-details/adresa-details.component';
import { IshodComponent } from './ishod/ishod.component';
import { IshodDetailsComponent } from './ishod/ishod-details/ishod-details.component';
import { IshodFormComponent } from './ishod/ishod-form/ishod-form.component';
import { ZvanjeComponent } from './zvanje/zvanje.component';
import { ZvanjeDetailsComponent } from './zvanje/zvanje-details/zvanje-details.component';
import { ZvanjeFormComponent } from './zvanje/zvanje-form/zvanje-form.component';
import { NaucnaOblastComponent } from './naucna-oblast/naucna-oblast.component';
import { NaucnaOblastDetailsComponent } from './naucna-oblast/naucna-oblast-details/naucna-oblast-details.component';
import { NaucnaOblastFormComponent } from './naucna-oblast/naucna-oblast-form/naucna-oblast-form.component';
import { TipZvanjaComponent } from './tip-zvanja/tip-zvanja.component';
import { TipZvanjaDetailsComponent } from './tip-zvanja/tip-zvanja-details/tip-zvanja-details.component';
import { TipZvanjaFormComponent } from './tip-zvanja/tip-zvanja-form/tip-zvanja-form.component';
import { NastavnikNaRealizacijiComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji.component';
import { NastavnikNaRealizacijiDetailsComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji-details/nastavnik-na-realizaciji-details.component';
import { NastavnikNaRealizacijiFormComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji-form/nastavnik-na-realizaciji-form.component';
import { TipNastaveComponent } from './tip-nastave/tip-nastave.component';
import { TipNastaveDetailsComponent } from './tip-nastave/tip-nastave-details/tip-nastave-details.component';
import { TipNastaveFormComponent } from './tip-nastave/tip-nastave-form/tip-nastave-form.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { PohadjanjePredmetaFormComponent } from './pohadjanje-predmeta/pohadjanje-predmeta-form/pohadjanje-predmeta-form.component';
import { PohadjanjePredmetaDetailsComponent } from './pohadjanje-predmeta/pohadjanje-predmeta-details/pohadjanje-predmeta-details.component';
import { StudentNaGodiniComponent } from './student-na-godini/student-na-godini.component';
import { StudentNaGodiniDetailsComponent } from './student-na-godini/student-na-godini-details/student-na-godini-details.component';
import { StudentNaGodiniFormComponent } from './student-na-godini/student-na-godini-form/student-na-godini-form.component';
import { PredmetComponent } from './predmet/predmet.component';
import { PredmetDetailsComponent } from './predmet/predmet-details/predmet-details.component';
import { PredmetFormComponent } from './predmet/predmet-form/predmet-form.component';
import { GodinaStudijaComponent } from './godina-studija/godina-studija.component';
import { GodinaStudijaDetailsComponent } from './godina-studija/godina-studija-details/godina-studija-details.component';
import { GodinaStudijaFormComponent } from './godina-studija/godina-studija-form/godina-studija-form.component';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { NastavnikDetailsComponent } from './nastavnik/nastavnik-details/nastavnik-details.component';
import { NastavnikFormComponent } from './nastavnik/nastavnik-form/nastavnik-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UniverzitetComponent,
    FakultetComponent,
    HomeComponent,
    UniverzitetFormComponent,
    UniverzitetDetailsComponent,
    FakultetDetailsComponent,
    FakultetFormComponent,
    StudentComponent,
    StudentDetailsComponent,
    StudentFormComponent,
    StudijskiProgramComponent,
    StudijskiProgramDetailsComponent,
    StudijskiProgramFormComponent,
    MestoComponent,
    MestoFormaComponent,
    MestoDetailsComponent,
    AdresaComponent,
    AdresaFormComponent,
    AdresaDetailsComponent,
    IshodComponent,
    IshodDetailsComponent,
    IshodFormComponent,
    ZvanjeComponent,
    ZvanjeDetailsComponent,
    ZvanjeFormComponent,
    NaucnaOblastComponent,
    NaucnaOblastDetailsComponent,
    NaucnaOblastFormComponent,
    TipZvanjaComponent,
    TipZvanjaDetailsComponent,
    TipZvanjaFormComponent,
    NastavnikNaRealizacijiComponent,
    NastavnikNaRealizacijiDetailsComponent,
    NastavnikNaRealizacijiFormComponent,
    TipNastaveComponent,
    TipNastaveDetailsComponent,
    TipNastaveFormComponent,
    PohadjanjePredmetaComponent,
    PohadjanjePredmetaFormComponent,
    PohadjanjePredmetaDetailsComponent,
    StudentNaGodiniComponent,
    StudentNaGodiniDetailsComponent,
    StudentNaGodiniFormComponent,
    PredmetComponent,
    PredmetDetailsComponent,
    PredmetFormComponent,
    GodinaStudijaComponent,
    GodinaStudijaDetailsComponent,
    GodinaStudijaFormComponent,
    NastavnikComponent,
    NastavnikDetailsComponent,
    NastavnikFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
