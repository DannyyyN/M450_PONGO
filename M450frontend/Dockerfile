FROM node:16-alpine as build
WORKDIR /app
COPY . .
RUN yarn install --network-timeout 30000
RUN yarn run build

FROM nginx:alpine
EXPOSE 443 80
WORKDIR /usr/share/nginx/html
COPY --from=build /app/nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/build .
COPY --from=build /app/.env.production .
RUN apk add --no-cache bash
CMD ["nginx", "-g", "daemon off;"]
