#### Step 1: Build the react application
FROM node:16-alpine3.14@sha256:60ef0bed1dc2ec835cfe3c4226d074fdfaba571fd619c280474cc04e93f0ec5b as build

# Set Working directory for build
WORKDIR /app

# Copy package.json, package-lock.json and install
COPY package.json ./
COPY package-lock.json ./

RUN npm install

# Copy the application source codes
COPY . ./

# Arguments
ARG API_BASE_URL
ENV API_BASE_URL=${API_BASE_URL}

# Build the application
RUN npm run build

#### Step 2: Run Nginx and serve the application
FROM nginx:1.21.4-alpine@sha256:12aa12ec4a8ca049537dd486044b966b0ba6cd8890c4c900ccb5e7e630e03df0

# Copy build file to /var/www
COPY --from=build /app/build /var/www

# Copy nginx config file
COPY nginx.conf /etc/nginx/nginx.conf

# Expose 3000 to docker host, so we can access it from outside
EXPOSE 3000

ENTRYPOINT ["nginx","-g","daemon off;"]