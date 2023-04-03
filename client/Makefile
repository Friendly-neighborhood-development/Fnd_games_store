build:
	docker build -t game-store-client .

build-multi-arch:
	docker buildx build --platform linux/amd64,linux/arm64 -t andrewsemenov/game-store-client:latest --push .

run:
	docker run -d --name game-store-client --rm -p 5173:5173 game-store-client

stop:
	docker stop game-store-client
