FROM node:18.20.4-slim AS build
WORKDIR /app

RUN npm install -g @angular/cli

COPY package*.json ./
RUN npm install
COPY . .
RUN ng build --configuration=production

# Usa una imagen de Nginx para servir los archivos estáticos
FROM nginx:alpine
COPY --from=build /app/dist/music-search-app /usr/share/nginx/html

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]
