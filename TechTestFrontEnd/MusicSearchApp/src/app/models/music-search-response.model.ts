export interface Price {
  value: number;
  currency: string;
}

export interface Song {
  songName: string;
  albumName: string;
  previewUrl: string;
  price: Price;
  releaseDate: string;
}

export interface MusicSearchResponse {
  total_albums: number;
  total_songs: number;
  albums: string[];
  songs: Song[];
}
