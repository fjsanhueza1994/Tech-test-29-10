export interface Precio {
  valor: number;
  moneda: string;
}

export interface Cancion {
  songId: number;
  nombre_album: string;
  nombre_cancion: string;
  preview_url: string;
  fecha_lanzamiento: string;
  precio: Precio;
}

export interface MusicSearchResponse {
  total_albumes: number;
  total_canciones: number;
  albumes: string[];
  canciones: Cancion[];
}
