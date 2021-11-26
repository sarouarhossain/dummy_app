#### Step 1: Build the application
FROM openjdk:17-alpine3.14 as build

# Set working directory for build
WORKDIR /build/app

# Copy maven
COPY . .

# Build dependencies
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build

#### Step 2: run the app
FROM openjdk:17-alpine3.14

RUN apk add dumb-init

# Set working directory to run the app
WORKDIR /opt/app

# Create user group and user to run the app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser

# Set build dependency directory to copy jar
ARG DEPENDENCY=/build/app/build

# Copy jar file from build
COPY --from=build ${DEPENDENCY}/libs/*.jar /opt/app/app.jar

# Change the owner of the files
RUN chown -R javauser:javauser /opt/app

# Change current user
USER javauser

# Run the app
ENTRYPOINT ["dumb-init","java","-jar","app.jar"]