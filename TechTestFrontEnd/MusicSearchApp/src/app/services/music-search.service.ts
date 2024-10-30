import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MusicSearchResponse } from '../models/music-search-response.model';

@Injectable({
  providedIn: 'root'
})
export class MusicSearchService {
  private apiURL = 'http://localhost:8081/music-search/search_tracks';

  constructor(private http: HttpClient) {}

  searchSongs(artistName: string): Observable<MusicSearchResponse> {
    const params = new HttpParams().set('artistName', artistName);
    return this.http.get<MusicSearchResponse>(this.apiURL, { params });
  }
}
