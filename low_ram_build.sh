#!/usr/bin/env bash

NC='\033[0m'
GREEN='\033[0;32m'


docker build -t registry-service ./server/registry-service;

docker build -t config-service ./server/config-service;

docker build -t gateway-service ./server/gateway-service;

docker build -t games-service ./server/games-service;

docker build -t login-service ./server/login-service;

docker build -t orders-service ./server/orders-service;

docker build -t cart-service ./server/cart-service;

docker build -t client-application ./client


printf ${GREEN}"===Fnd_games_store build completed==="${NC}
echo
