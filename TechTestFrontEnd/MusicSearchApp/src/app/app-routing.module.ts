import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MusicSearchComponent} from "./components/music-search/music-search.component";

const routes: Routes = [
  {path: '', component: MusicSearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
