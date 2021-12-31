FROM node:latest
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
CMD ["npm", "start"]
#docker run --name jee-front -d -p 3001:3000 jee:front