import { Component } from '@angular/core';
import {MusicSearchResponse} from "../../models/music-search-response.model";
import {MusicSearchService} from "../../services/music-search.service";

@Component({
  selector: 'app-music-search',
  templateUrl: './music-search.component.html',
  styleUrls: ['./music-search.component.css']
})
export class MusicSearchComponent {
  artistName: string = '';
  musicSearchResponse!: MusicSearchResponse;

  constructor(private musicSearchService: MusicSearchService) {}

  searchSongs(artistName: string): void {
    this.musicSearchService.searchSongs(artistName).subscribe((response) => {
      this.musicSearchResponse = response;
    });
  }

}
