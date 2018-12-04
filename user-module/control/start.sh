#!/usr/bin/env bash


# start dns cache server
nscd

# start server
nginx/sbin/nginx


# 服务是否运行
function is_server_running() {
  return 1
}

# loop
while true
do
  is_server_running
  if [ $? -eq 0 ]; then
    nginx/sbin/nginx
  fi
  sleep 5
done
