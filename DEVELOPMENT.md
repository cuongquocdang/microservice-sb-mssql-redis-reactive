# Development

## Redis

```sh
docker run --name redis-development --restart always -p 6379:6379 -d redis redis-server --requirepass "P@ssword12345"
```

## MS Sql Server

```sh
docker run --name mssql-development --restart always -p 1433:1433 -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=P@ssword12345" --platform linux/amd64 -d mcr.microsoft.com/mssql/server:2022-latest
```