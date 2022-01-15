FROM node:latest
WORKDIR /app
#COPY package.json ./
COPY . .
RUN npm install
CMD ["npm", "start"]
#docker run --name jee-front -d -p 3001:3000 jee:front